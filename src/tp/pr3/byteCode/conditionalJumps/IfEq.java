package tp.pr3.byteCode.conditionalJumps;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.ExecutionError;

/**
 * Clase hija de la clase ConditionalJumps (hija de ByteCode).
 * Realiza un salto en la ejecución del programa si no se cumple "subcima == cima".
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class IfEq extends ConditionalJumps{

	/**
	 * Constructor dado el salto.
	 * @param jump Int con el que queremos inicializar this.jump
	 */
	public IfEq(int jump){
		super(jump);
	}
	
	/**
	 * Constructor sin parametros.
	 */
	public IfEq() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 * La condición evaluada es "op1 == op2".
	 */
	public void executeAux(CPU cpu, int op1, int op2) throws ExecutionError{
		if(op2!=op1)
			cpu.changeCounter(jump);
	}
	
	/**
	 * {@inheritDoc}
	 * s[0] debe ser "IFEQ" y s[1] debe ser un número.
	 * @return ByteCode IfEq, si corresponde, o null, si no
	 */
	public ByteCode parseAux(String[] s){
		try {
			if (s[0].equalsIgnoreCase("IFEQ") && Integer.parseInt(s[1]) >= 0)
				return new IfEq(Integer.parseInt(s[1]));
			else
				return null;
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * Redefine el metodo toString para la clase IfEq
	 */
	public String toString(){
		return "IFEQ " + jump;
	}
}
