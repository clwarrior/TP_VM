package tp.pr3.compilation.conditions;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.terms.*;
import tp.pr3.exceptions.*;

/**
 * Clase que engloba todos los tipos de condiciones.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public abstract class Condition {
	
	/**
	 * Primer t�rmino de la condici�n.
	 */
	protected Term term1;
	
	/**
	 * Segundo t�rmino de la condici�n.
	 */
	protected Term term2;
	
	/**
	 * Condici�n a evaluar
	 */
	protected ConditionalJumps condition;
	
	/**
	 * Transforma los atributos dados en un objeto de tipo Condition v�lido, si puede, o devuelve null.
	 * @param t1 Primer t�rmino de la condici�n
	 * @param op Operador de la condici�n
	 * @param t2 Segundo t�rmino de la condici�n
	 * @param lexParser Parseador l�xico
	 * @return Condition del tipo correspondiente, si lo hay, o null en caso contrario         
	 * @throws LexicalAnalysisException Instrucci�n no v�lida
	 */
	public Condition parse(String t1, String op, String t2, LexicalParser lexParser) throws LexicalAnalysisException{
		if (!op.equals("<") && !op.equals("<=") && !op.equals("=") && !op.equals("!="))
			return null;
		else{
			Term term1 = TermParser.parse(t1);
			Term term2 = TermParser.parse(t2);
			if(term1 == null || term2 == null)
				throw new LexicalAnalysisException("(Instrucci�n no v�lida)");
			else{
				return parseAux(term1, term2, op);
			}
		}
	}
	
	/**
	 * Transforma y almacena los datos dados en un Condition del tipo correspondiente, si puede, y lo devuelve.
	 * @param term1 Primer t�rmino de la condici�n
	 * @param term2 Segundo t�rmino de la condici�n
	 * @param op Operador de la condici�n
	 * @return Condition correspondiente, si lo hay, o null, si no
	 */
	public abstract Condition parseAux(Term term1, Term term2, String op);
			
	/**
	 * Compila una instucci�n de tipo Condition.
	 * @param compiler Compilador
	 * @throws CompilationError Error de compilaci�n
	 * @throws ArrayException Array lleno
	 */
	public void compile(Compiler compiler) throws CompilationError, ArrayException {
		ByteCode b1 = term1.compile(compiler);
		compiler.addByteCode(b1);
		ByteCode b2 = term2.compile(compiler);
		compiler.addByteCode(b2);
		compiler.addByteCode(condition);
	}

	/**
	 * Cambia el valor del salto de this.condition
	 * @param jump Int que contiene el nuevo valor del salto
	 */
	public void setJump(int jump) {
		this.condition.setJump(jump);
	}
}
