package tp.pr3.byteCode.conditionalJumps;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.ExecutionError;

/**
 * Clase hija de la clase ConditionalJumps.
 * Esta clase realiza saltos en la lectura de las instrucciones del programa siempre que
 * la condicion (subcima!=cima) de la pila no se cumpla.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */

public class IfNeq extends ConditionalJumps{

	/**
	 * Constructor con un parametro que hereda del constructor de la clase padre
	 * (inicializa this.jump a jump)
	 * @param jump, Un int al que inicializar this.jump
	 */
	public IfNeq(int jump){
		super(jump);
	}
	/**
	 * Constructor sin parametros que hereda del constructor de la clase padre
	 */
	public IfNeq() {
		super();
	}
	/**
	 * Llamando al execute de la clase padre saca la cima y la subcima de la pila de la cpu 
	 * dada por parámetro y si ha sido posible se compara la subcima y la cima, y si la
	 * subcima no es distinta que la cima se invoca a changeCounter de cpu para que cambie el 
	 * contador al valor jump.
	 * @param cpu Una CPU de cuya pila vamos a extraer los operandos
	 * @return boolean, true si ha podido realizarse la modificacion del contador y false eoc
	 */
	public void executeAux(CPU cpu, int op1, int op2) throws ExecutionError{
		if(op2==op1)
			cpu.changeCounter(jump);
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "ifneq" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase IfNeq (si procede) o null
	 */
	public ByteCode parseAux(String[] s){
		try {
			if (s[0].equalsIgnoreCase("IFNEQ") && Integer.parseInt(s[1]) >= 0)
				return new IfEq(Integer.parseInt(s[1]));
			else
				return null;
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	/**
	 * Redefine el metodo toString para la clase IfNeq, para poder mostrar la instrucción por pantalla
	 */
	public String toString(){
		return "IFNEQ "+jump;
	}
}
