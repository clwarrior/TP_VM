package tp.pr3.exceptions;

public class BadFormatByteCode extends Exception{

	private static final long serialVersionUID = 1L;

	private String message;

	public BadFormatByteCode(String string) {
		this.message = string;
	}
	
	public String toString(){
		return "Error: Formato del ByteCode no válido " + message;
	}
}
