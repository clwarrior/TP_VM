package tp.pr3.compilation.instructions.assignments;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.arithmetics.*;
import tp.pr3.byteCode.memoryMove.Store;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.compilation.terms.*;
import tp.pr3.exceptions.*;

/**
 * Clase hija de Instruction.
 * Realiza el parseo y compilación de las asignaciones compuestas
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class CompoundAssignment implements Instruction {
	
	/**
	 * Nombre de la variable
	 */
	private String var_name;
	
	/**
	 * Operador de la operación
	 */
	private String operator;
	
	/**
	 * Primer término de la operación
	 */
	private Term term1;
	
	/**
	 * Segundo término de la operación
	 */
	private Term term2;
	
	/**
	 * Constructor dado el nombre de la variable y los dos términos y el operador de la asignación
	 * @param name Nombre de la variable
	 * @param operator Operador de la operación
	 * @param term1 Primer término de la operación
	 * @param term2 Segundo término de la operación
	 */
	public CompoundAssignment(String name, String operator, Term term1, Term term2){
		this.var_name=name;
		this.operator=operator;
		this.term1=term1;
		this.term2=term2;
	}
	
	/**
	 * Constructor sin parámetros
	 */
	public CompoundAssignment() {}
	
	/**
	 * {@inheritDoc}
	 * En este caso, la transforma en una asignación compuesta con la operación correspondiente.
	 * @return CompoundAssignment, si corresponde, o null, si no
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		char name = words[0].toLowerCase().charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=5 || !words[1].equals("=") ||
				(!words[3].equals("+") && !words[3].equals("-") && !words[3].equals("*") && !words[3].equals("/")))
			return null;
		else{
			Term term1 = TermParser.parse(words[2]);
			Term term2 = TermParser.parse(words[4]);
			if(term1 == null || term2 == null)
				throw new LexicalAnalysisException("(Instrucción no válida)");
			else{
				return new CompoundAssignment(words[0], words[3], term1, term2);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Concretamente, la transforma en los ByteCode de cada término de la operación, de la operación en sí,
	 * y de el término al que se asigna.
	 */
	public void compile(Compiler compiler) throws CompilationError, ArrayException {
		ByteCode b1 = this.term1.compile(compiler);
		ByteCode b2 = this.term2.compile(compiler);
		compiler.addByteCode(b1);
		compiler.addByteCode(b2);
		ByteCode operacion = null;
		switch(this.operator.charAt(0)) {
		case '+': operacion = new Add(); break;
		case '-': operacion = new Sub(); break;
		case '*': operacion = new Mul(); break;
		case '/': operacion = new Div(); break;
		}
		compiler.addByteCode(operacion);
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
