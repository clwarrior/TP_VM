package tp.pr3.exceptions;

/**
 * Clase que controla excepciones producidas al tratar con el fichero de código fuente.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class FileException extends Exception{

	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje de la excepción
	 */
	private String message;
	/**
	 * Constructor dado el mensaje
	 * @param string String al que se inicializa this.message
	 */
	public FileException(String string) {
		this.message = string;
	}
	/**
	 * Redefine el método toString para la clase FileException
	 */
	public String toString(){
		return "Error de fichero  " + message;
	}
}
