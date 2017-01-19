package tp.pr3.compilation.instructions;

import tp.pr3.byteCode.Load;
import tp.pr3.byteCode.Out;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
/**
 * Clase hija de Instruction.
 * Realiza el parseo y compilación de las instrucciones de escritura de variables
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Write implements Instruction {
	
	/**
	 * Nombre de la variable
	 */
	private String varName;
	 /**
	  * Constructor sin argumentos
	  */
	public Write() {}

	/**
	 * Constructor que dado un string inicializa el varName al string
	 * @param string Nombre de la variable
	 */
	public Write(String string) {
		this.varName = string;
	}

	/**
	 * {@inheritDoc}
	 * Si la cadena tiene como primer string "WRITE" (ignorando mayus y minus) devuelve un nuevo
	 * objeto de la clase Write, con nombre de la variable, lo que haya en el segundo lugar de la cadena
	 */
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		Instruction inst = null;
		if(words[0].equalsIgnoreCase("WRITE"))
			inst = new Write(words[1]);
		return inst;
	}

	/**
	 * {@inheritDoc}
	 * Para la clase Write añade los byteCodes Load y Out, que cargan el valor de la varible
	 * y la muestran
	 */
	public void compile(Compiler compiler) throws ArrayException, CompilationError{
		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(new Load(index));
		compiler.addByteCode(new Out());
	}
}
