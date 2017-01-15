package tp.pr3.command;

import tp.pr3.exceptions.*;
import tp.pr3.mv.Engine;

/**
 * Clase hija de Command.
 * Ejecuta la orden de compilar el programa.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Compile implements Command {

	/**
	 * {@inheritDoc}
	 * El comando Compile, llamando a engine.compile().
	 */
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException, CompilationError {
		engine.compile();
	}

	/**
	 * {@inheritDoc}
	 * s debe tener longitud 1 y s[0] debe ser igual a "COMPILE".
	 * @return Command Compile, si corresponde, o null, si no
	 */
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * (Compile).
	 */
	public String textHelp() {
		return "COMPILE: Compila el programa fuente almacenado " + System.getProperty("line.separator");
	}

	/**
	 * Redefine el método toString para la clase Compile
	 */
	public String toString() {
		return "COMPILE";
	}
}
