package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.ExecutionError;

/**
 * Clase hija de ByteCode.
 * Realiza saltos incondicionales en la lectura del programa.
 * Tiene un int jump que indica la posicion del programa a la que queremos saltar.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class GoTo implements ByteCode{
	
	/** 
	 * Posicion a la que se movera el contador del programa tras ejecutar esta instruccion.
	 */
	private int jump;
	
	/**
	 * Constructor dado el salto
	 * @param jump Int al que se inicializa this.jump
	 */
	public GoTo(int jump){
		this.jump = jump;
	}
	
	/**
	 * Constructor sin parámetros
	 */
	public GoTo() {}
	
	/**
	 * {@inheritDoc}
	 * Modifica el contador del programa por this.jump
	 */
	public void execute(CPU cpu) throws ExecutionError{
		cpu.changeCounter(jump);		
	}
	
	/**
	 * Comprueba si s corresponde a un ByteCode GoTo. Para ello su longitud debe ser 2, s[0] debe ser
	 * "GOTO" y s[1] un número mayor o igual que 0.
	 * @param s Array de String que contiene la instrucción
	 * @return ByteCode GoTo, si se corresponde, null, si no
	 */
	public ByteCode parse(String[] s){
		try {
			if (s.length==2 && s[0].equalsIgnoreCase("GOTO") && Integer.parseInt(s[1]) >= 0)
				return new GoTo(Integer.parseInt(s[1]));
			else
				return null;
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * Redefine el metodo toString para la clase GoTo
	 */
	public String toString(){
		return "GOTO "+jump;
	}
}
