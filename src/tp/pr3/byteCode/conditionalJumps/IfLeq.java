package tp.pr3.byteCode.conditionalJumps;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.ExecutionError;

/**
 * Clase hija de la clase ConditionalJumps.
 * Esta clase realiza saltos en la lectura de las instrucciones del programa siempre que
 * la condicion (subcima menor o igual que cima) de la pila no se cumpla.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */

public class IfLeq extends ConditionalJumps{

	/**
	 * Constructor con un parametro que hereda del constructor de la clase padre
	 * (inicializa this.jump a jump)
	 * @param jump, Un int al que inicializar this.jump
	 */
	public IfLeq(int jump){
		super(jump);
	}
	/**
	 * Constructor sin parametros que hereda del constructor de la clase padre
	 */
	public IfLeq() {
		super();
	}
	/**
	 * {@inheritDoc}
	 * La condición evaluada es "op1 <= op2".
	 * @throws ExecutionError Lanza un error de ejecución cuando se intenta saltar a una posición no válida
	 */
	public void executeAux(CPU cpu, int op1, int op2) throws ExecutionError{
		if(op2>op1)
			cpu.changeCounter(jump);
	}
	/**
	 * {@inheritDoc}
	 * s[0] debe ser "IFLEQ" y s[1] debe ser un número.
	 * @return ByteCode IfLeq, si corresponde, o null, si no
	 */
	public ByteCode parseAux(String[] s){
		try {
			if (s[0].equalsIgnoreCase("IFLEQ") && Integer.parseInt(s[1]) >= 0)
				return new IfEq(Integer.parseInt(s[1]));
			else
				return null;
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	/**
	 * Redefine el metodo toString para la clase IfLeq, para poder mostrar la instrucción por pantalla
	 */
	public String toString(){
		return "IFLEQ "+jump;
	}
}
