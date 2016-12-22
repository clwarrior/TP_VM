package tp.pr3.exceptions;

public class ArrayException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public ArrayException(String string) {
		this.message = string;
	}
	
	public String toString(){
		return "Error: Array Exception " + message;
	}
}
