package tp.pr3.exceptions;

public class DivisionByZero extends ExecutionError{

	private static final long serialVersionUID = 1L;

	public DivisionByZero(String string) {
		super(" - Divisi�n entre 0 " + string);
	}
}
