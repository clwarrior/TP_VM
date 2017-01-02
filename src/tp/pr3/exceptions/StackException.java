package tp.pr3.exceptions;

public class StackException extends Exception{

	private static final long serialVersionUID = 1L;

	private String message;

	public StackException(String string) {
		this.message = string;
	}
	
	public String toString(){
		return "Error: StackException " + message;
	}
}
