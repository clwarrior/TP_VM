package tp.pr3.compilation.instructions.assignments;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.Store;
import tp.pr3.byteCode.arithmetics.*;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.compilation.terms.*;
import tp.pr3.exceptions.*;

/**
 * Clase hija de Instruction.
 * Realiza el parseo y compilaci�n de las asignaciones compuestas
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class CompoundAssignment implements Instruction {
	
	/**
	 * Nombre de la variable
	 */
	private String var_name;
	
	/**
	 * Operador de la operaci�n
	 */
	private String operator;
	
	/**
	 * Primer t�rmino de la operaci�n
	 */
	private Term term1;
	
	/**
	 * Segundo t�rmino de la operaci�n
	 */
	private Term term2;
	
	/**
	 * Constructor dado el nombre de la variable y los dos t�rminos y el operador de la asignaci�n
	 * @param name Nombre de la variable
	 * @param operator Operador de la operaci�n
	 * @param term1 Primer t�rmino de la operaci�n
	 * @param term2 Segundo t�rmino de la operaci�n
	 */
	public CompoundAssignment(String name, String operator, Term term1, Term term2){
		this.var_name=name;
		this.operator=operator;
		this.term1=term1;
		this.term2=term2;
	}
	
	/**
	 * Constructor sin par�metros
	 */
	public CompoundAssignment() {}
	
	/**
	 * {@inheritDoc}
	 * En este caso, la transforma en una asignaci�n compuesta con la operaci�n correspondiente.
	 * @return CompoundAssignment, si corresponde, o null, si no
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		if(words.length == 5){
			char name = words[0].toLowerCase().charAt(0);
			if (!('a' <= name && name <= 'z') || !words[1].equals("=") || 
					(!words[3].equals("+") && !words[3].equals("-") && !words[3].equals("*") && !words[3].equals("/")))
				return null;
			else{
				Term term1 = TermParser.parse(words[2]);
				Term term2 = TermParser.parse(words[4]);
				if(term1 == null || term2 == null)
					throw new LexicalAnalysisException("(Instrucci�n no v�lida)");
				else{
					return new CompoundAssignment(words[0], words[3], term1, term2);
				}
			}
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * Concretamente, la transforma en los ByteCode de cada t�rmino de la operaci�n, de la operaci�n en s�,
	 * y de el t�rmino al que se asigna.
	 */
	/*
	 * En esta clase, puede aparecer la excepci�n CompilationError por dos motivos:
	 *  - Al compilar term1 y term2, en cuyo caso queremos que lo lance para que la instrucci�n sea incorrecta
	 *    ya que no se puede inicializar una variable a la derecha de la asignaci�n.
	 *  - Al buscar la variable de la izquierda de la asignaci�n, en cuyo caso, tratamos la excepci�n para crear
	 *    la variable ya que lo entendemos como una inicializaci�n. No podemos a�adir directamente la variable 
   	 *    porque hemos hecho que la funci�n getIndex (utilizada en la compilaci�n de term1 y term2) lance CompilationError
	 *    si la variable no est�, y no se puede quitar porque hay lugares donde necesitamos que lo haga.
	 * 
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
		compiler.addByteCode(new Store(index));
		
	}
}
