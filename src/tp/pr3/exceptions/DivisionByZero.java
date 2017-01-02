package tp.pr3.exceptions;

public class DivisionByZero extends Exception{
	
	private static final long serialVersionUID = 1L;

	private String message;

	public DivisionByZero(String string) {
		this.message = string;
	}
	
	public String toString(){
		return "Error: DivisionByZero " + message;
	}
}
