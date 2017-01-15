package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase hija de Arithmetics (hija de ByteCode).
 * Realiza la instrucción de sumar dos números.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Add extends Arithmetics{
	
	/**
	 * {@inheritDoc}
	 * Realiza la operación "op1 + op2"
	 */
	public void executeAux(CPU cpu, int op1, int op2) throws StackException{
		int result = op2 + op1;
		cpu.push(result);
	}
	
	/**
	 * {@inheritDoc}
	 * El String dado debe ser "ADD"
	 * @return ByteCode Add, si corresponde, o null si no
	 */
	public ByteCode parseAux(String s){
		if(s.toUpperCase().equals("ADD"))
			return new Add();
		else
			return null;
	}
	
	/**
	 * Redefine el metodo toString para la clase Add
	 */
	public String toString(){
		return "ADD";
	}
}
