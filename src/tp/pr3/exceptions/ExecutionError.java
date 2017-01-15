package tp.pr3.exceptions;

/**
 * Clase que controla excepciones producidas al ejecutar el programa.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class ExecutionError extends Exception{

	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje de la excepción
	 */
	private String message;
	/**
	 * Constructor dado el mensaje
	 * @param string String al que se inicializa this.message
	 */
	public ExecutionError(String string) {
		this.message = string;
	}
	/**
	 * Redefine el método toString para la clase ExecutionError
	 */
	public String toString(){
		return message;
	}
}
