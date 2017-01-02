package tp.pr3.exceptions;

public class LexicalAnalysisException extends Exception{

	private static final long serialVersionUID = 1L;

	private String message;

	public LexicalAnalysisException(String string) {
		this.message = string;
	}
	
	public String toString(){
		return "Error: LexicalAnalysisExcepcion " + message;
	}
}
