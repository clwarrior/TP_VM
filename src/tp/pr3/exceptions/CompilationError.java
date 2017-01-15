package tp.pr3.exceptions;

/**
 * Clase que controla excepciones producidos por la compilaci�n.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class CompilationError extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Mensaje de la excepci�n
	 */
	private String message;

	/**
	 * Constructor dado el mensaje
	 * @param string String al que se inicializa this.message
	 */
	public CompilationError(String string) {
		this.message = string;
	}
	
	/**
	 * Redefine el m�todo toString para la clase CompilationError
	 */
	public String toString(){
		return "Error de compilaci�n  " + message;
	}

}
