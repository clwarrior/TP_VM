package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de la clase Arithmetics (hija de ByteCode). 
 * Realiza la instrucción de dividir dos números.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Div extends Arithmetics{
	
	/**
	 * {@inheritDoc}
	 * Realiza la operación "op2 / op1".
	 */
	public void executeAux(CPU cpu, int op1, int op2)throws StackException, DivisionByZero{
		int result = 0;
		if(op1 != 0){
			result = op2 / op1;
			cpu.push(result);
		}
		else
			throw new DivisionByZero("");
	}
	
	/**
	 * {@inheritDoc}
	 * El String dado debe ser "DIV".
	 * @return ByteCode Div, si corresponde, o null, si no
	 */
	public ByteCode parseAux(String s){
		if(s.toUpperCase().equals("DIV"))
			return new Div();
		else
			return null;
	}
	
	/**
	 * Redefine el metodo toString para la clase Div.
	 */
	public String toString(){
		return "DIV";
	}
}
