package tp.pr3.compilation.instructions.assignments;

import tp.pr3.exceptions.*;
import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.memoryMove.Store;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.compilation.terms.*;
/**
 * Clase hija de Instruction.
 * Realiza el parseo y compilaci�n de las asignaciones simples
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class SimpleAssignment implements Instruction {
	/**
	 * Nombre de la variable
	 */
	private String var_name;
	/**
	 * Nombre del t�rmino
	 */
	private Term rhs;

	/**
	 * Constructor dado el nombre de la variable y del termino
	 * @param name Nombre de la variable
	 * @param rhs Nombre del t�rmino
	 */
	public SimpleAssignment(String name, Term rhs){
		this.var_name=name;
		this.rhs=rhs;
	}
	
	/**
	 * Constructor sin par�metros
	 */
	public SimpleAssignment() {}
	
	/**
	 * {@inheritDoc}
	 * En este caso, la transforma en una asignaci�n simple.
	 * @return SimpleAssignment, si corresponde, o null, si no
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException{
		char name = words[0].charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=3 || !words[1].equals("="))
			return null;
		else{
			Term term = TermParser.parse(words[2]);
			if(term == null)
				throw new LexicalAnalysisException("Instrucci�n no v�lida");
			else{
				return new SimpleAssignment(words[0], term);
			}
		}
	}
	/**
	 * {@inheritDoc}
	 * Concretamente, la transforma en los ByteCode del t�rmino y de la variable a la que se asigna.
	 */
	public void compile(Compiler compiler) throws CompilationError, ArrayException {
		ByteCode b = this.rhs.compile(compiler);
		compiler.addByteCode(b);
		int index = 0;
		try {
			index = compiler.getIndex(var_name);
		}
		catch(CompilationError e) {
			index = compiler.addVariable(var_name);
		}
		finally {
			compiler.addByteCode(new Store(index));
		}
	}
}
