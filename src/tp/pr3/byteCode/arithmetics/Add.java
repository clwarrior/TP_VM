package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.StackException;

/**
 * Clase hija de la clase Arithmetics.
 * Esta clase realiza la instruccion de sumar dos numeros.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Add extends Arithmetics{
	
	/**
	 * Constructor de la clase Add
	 */
	public Add(){
		super();
	}
	/**
	 * Ejecuta la instruccion de sumar dos numeros, llamando al execute de la clase padre
	 * los saca de la pila de la cpu dada por parámetro y si ha sido posible se suman y el 
	 * resultado se añade a la pila.
	 * @param cpu Una CPU de cuya pila vamos a extraer los operandos y donde vamos a almacenar
	 * el resultado
	 * @return boolean, true si ha podido realizarse la operacion y false eoc
	 */
	public void executeAux(CPU cpu, int op1, int op2) throws StackException{
		int result = op2 + op1;
		cpu.push(result);
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "add" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase Add (si procede) o null
	 */
	public ByteCode parseAux(String s){
		if(s.toUpperCase().equals("ADD"))
			return new Add();
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Add, para poder mostrar la instrucción por pantalla
	 */
	public String toString(){
		return "ADD";
	}
}
