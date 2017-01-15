package tp.pr3.exceptions;

/**
 * Clase que controla excepciones producidas al hacer el análisis léxico del programa fuente.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class LexicalAnalysisException extends Exception{

	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje de la excepción
	 */
	private String message;
	/**
	 * Constructor dado el mensaje
	 * @param string String al que se inicializa this.message
	 */
	public LexicalAnalysisException(String string) {
		this.message = string;
	}
	/**
	 * Redefine el método toString para la clase LexicalAnalysisException
	 */
	public String toString(){
		return "Error en el análisis léxico " + message;
	}
}
