package tp.pr3.exceptions;

/**
 * Clase que controla excepciones producidas al tratar de dividir entre 0.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class DivisionByZero extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje de la excepci�n
	 */
	private String message;
	
	/**
	 * Constructor dado el mensaje
	 * @param string String al que se inicializa this.message
	 */
	public DivisionByZero(String string) {
		this.message = string;
	}
	
	/**
	 * Redefine el m�todo toString para la clase DivisionByZero
	 */
	public String toString() {
		return "Divisi�n entre 0" + this.message;
	}
}
