package tp.pr3.exceptions;

/**
 * Clase que controla excepciones producidas por la escritura incorrecta de los ByteCode.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class BadFormatByteCode extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje de la excepci�n
	 */
	private String message;

	/**
	 * Constructor dado el mensaje
	 * @param string String al que se inicializa this.message
	 */
	public BadFormatByteCode(String string) {
		this.message = string;
	}
	/**
	 * Redefine el m�todo toString para la clase BadFormatByteCode
	 */
	public String toString(){
		return "Error: Formato del ByteCode no v�lido " + message;
	}
}
