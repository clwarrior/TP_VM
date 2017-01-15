package tp.pr3.compilation.terms;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.compilation.Compiler;
import tp.pr3.exceptions.CompilationError;

/**
 * Interfaz que agrupa todos los tipos de términos
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public interface Term {
	
	/**
	 * Transforma un string en el término correspondiente, si puede
	 * @param term String que se desea transformar
	 * @return Term del tipo correspondiente, o null, si no es de ninguno
	 */
	Term parse(String term);
	
	/**
	 * Se compila y devuelve el ByteCode correspondiente
	 * @param compiler Compilador
	 * @return ByteCode correspondiente al término
	 * @throws CompilationError Error de compilación
	 */
	ByteCode compile(Compiler compiler) throws CompilationError;
	
}
