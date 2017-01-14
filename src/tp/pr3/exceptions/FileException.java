package tp.pr3.exceptions;

public class FileException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public FileException(String string) {
		this.message = string;
	}
	
	public String toString(){
		return "Error de fichero  " + message;
	}
}
