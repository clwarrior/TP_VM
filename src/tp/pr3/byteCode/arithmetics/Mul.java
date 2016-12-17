package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
/**
 * Clase hija de la clase Arithmetics.
 * Esta clase realiza la instruccion de multiplicar dos numeros.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Mul extends Arithmetics{
	
	/**
	 * Constructor de la clase Mul
	 */
	public Mul(){
		super();
	}
	/**
	 * Ejecuta la instruccion de sumar dos numeros, llamando al execute de la clase padre
	 * los saca de la pila de la cpu dada por parámetro y si ha sido posible se multiplican y el 
	 * resultado se añade a la pila.
	 * @param cpu Una CPU de cuya pila vamos a extraer los operandos y donde vamos a almacenar
	 * el resultado
	 * @return boolean, true si ha podido realizarse la operacion y false eoc
	 */
	public boolean executeAux(CPU cpu){
		boolean ok = false;
		int result = op2 * op1;
		ok = cpu.push(result);
		return ok;
	}
	
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "mul" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase Mul (si procede) o null
	 */
	public ByteCode parseAux(String s){
		if(s.toUpperCase().equals("MUL"))
			return new Mul();
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Mul, para poder mostrar la instrucción por pantalla
	 */
	public String toString(){
		return "MUL";
	}
}
