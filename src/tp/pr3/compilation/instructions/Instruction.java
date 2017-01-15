package tp.pr3.compilation.instructions;

import tp.pr3.exceptions.*;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;

/**
 * Interfaz que engloba todas los tipos de instrucciones
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public interface Instruction{
	
	/**
	 * Transforma un Array de String en la instrucci�n correspondiente, si puede.
	 * @param words Array de String que contiene la instrucci�n
	 * @param lexparser Parseador L�xico
	 * @return Instruction correspondiente, si la hay, o null, si no
	 * @throws LexicalAnalysisException Instrucci�n no v�lida
	 * @throws ArrayException Array lleno
	 */
	Instruction lexParse(String[] words, LexicalParser lexparser) throws LexicalAnalysisException, ArrayException;
	
	/**
	 * Compila una instrucci�n y la transforma en los ByteCode correspondientes, que a�ade al programa.
	 * @param compiler Compilador
	 * @throws ArrayException Array lleno
	 * @throws CompilationError Error de compilaci�n
	 */
	void compile(Compiler compiler) throws ArrayException, CompilationError;
	
}
