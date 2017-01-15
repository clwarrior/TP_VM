package tp.pr3.compilation.terms;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.compilation.Compiler;
import tp.pr3.exceptions.CompilationError;

/**
 * Interfaz que agrupa todos los tipos de t�rminos
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public interface Term {
	
	/**
	 * Transforma un string en el t�rmino correspondiente, si puede
	 * @param term String que se desea transformar
	 * @return Term del tipo correspondiente, o null, si no es de ninguno
	 */
	Term parse(String term);
	
	/**
	 * Se compila y devuelve el ByteCode correspondiente
	 * @param compiler Compilador
	 * @return ByteCode correspondiente al t�rmino
	 * @throws CompilationError Error de compilaci�n
	 */
	ByteCode compile(Compiler compiler) throws CompilationError;
	
}
