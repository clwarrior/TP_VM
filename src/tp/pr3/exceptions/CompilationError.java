package tp.pr3.exceptions;

public class CompilationError extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public CompilationError(String string) {
		this.message = string;
	}
	
	public String toString(){
		return "Error: Error de compilación " + message;
	}

}
