package tp.pr3.exceptions;

public class DivisionByZero extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DivisionByZero(String message) {
		super(message);
	}
}
