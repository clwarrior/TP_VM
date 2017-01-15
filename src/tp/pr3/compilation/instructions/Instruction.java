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
	 * Transforma un Array de String en la instrucción correspondiente, si puede.
	 * @param words Array de String que contiene la instrucción
	 * @param lexparser Parseador Léxico
	 * @return Instruction correspondiente, si la hay, o null, si no
	 * @throws LexicalAnalysisException Instrucción no válida
	 * @throws ArrayException Array lleno
	 */
	Instruction lexParse(String[] words, LexicalParser lexparser) throws LexicalAnalysisException, ArrayException;
	
	/**
	 * Compila una instrucción y la transforma en los ByteCode correspondientes, que añade al programa.
	 * @param compiler Compilador
	 * @throws ArrayException Array lleno
	 * @throws CompilationError Error de compilación
	 */
	void compile(Compiler compiler) throws ArrayException, CompilationError;
	
}
