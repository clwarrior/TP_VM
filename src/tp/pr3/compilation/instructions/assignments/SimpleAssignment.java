package tp.pr3.compilation.instructions.assignments;

import tp.pr3.exceptions.*;
import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.Store;
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
		if(words.length==3){
			char name = words[0].charAt(0);
			if (!('a' <= name && name <= 'z') || !words[1].equals("="))
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
		else
			return null;
	}
	/**
	 * {@inheritDoc}
	 * Concretamente, la transforma en los ByteCode del t�rmino y de la variable a la que se asigna.
	 */
	/*En esta clase, puede aparecer la excepci�n CompilationError por dos motivos:
	*  - Al compilar rhs, en cuyo caso queremos que lo lance para que la instrucci�n sea incorrecta
	*    ya que no se puede inicializar una variable a la derecha de la asignaci�n.
	*  - Al buscar la variable de la izquierda de la asignaci�n, en cuyo caso, tratamos la excepci�n para crear
	*    la variable ya que lo entendemos como una inicializaci�n. No podemos a�adir directamente la variable 
	*    porque hemos hecho que la funci�n getIndex (utilizada en la compilaci�n de rhs) lance CompilationError
	*    si la variable no est�, y no se puede quitar porque hay lugares donde necesitamos que lo haga.
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
		compiler.addByteCode(new Store(index));
	}
}
