package tp.pr3.exceptions;

public class ExecutionError extends Exception{

	private static final long serialVersionUID = 1L;

	private String message;

	public ExecutionError(String string) {
		this.message = string;
	}
	
	public String toString(){
		return message;
	}
}
