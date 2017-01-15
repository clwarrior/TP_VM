package tp.pr3.compilation.instructions;

import tp.pr3.byteCode.Halt;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.exceptions.ArrayException;
/**
 * Clase hija de Instruction.
 * Realiza el parseo y compilación de la instrucción return
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Return implements Instruction {

	/**
	 * {@inheritDoc}
	 * Si la cadena tiene como primer string "RETURN" (ignorando mayus y minus) devuelve un nuevo
	 * objeto de la clase Return
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		Instruction inst = null;
		if(words[0].equalsIgnoreCase("RETURN"))
			inst = new Return();
		return inst;
	}

	/**
	 * {@inheritDoc}
	 * Para la clase Return añade el byteCode Halt que detiene la ejecución del programa
	 */
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}

}
