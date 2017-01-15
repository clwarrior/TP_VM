package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.StackException;
/**
 * Clase hija de la clase Arithmetics.
 * Esta clase realiza la instruccion de restar dos numeros.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Sub extends Arithmetics{
	
	/**
	 * Constructor de la clase Sub
	 */
	public Sub(){
		super();
	}
	/**
	 * Ejecuta la instruccion de sumar dos numeros, llamando al execute de la clase padre
	 * los saca de la pila de la cpu dada por parámetro y si ha sido posible se resta 
	 * la cima de la subcima y el resultado se añade a la pila.
	 * @param cpu Una CPU de cuya pila vamos a extraer los operandos y donde vamos a almacenar
	 * el resultado
	 * @throws StackException Si la pila está llena, lanza el error
	 */
	public void executeAux(CPU cpu, int op1, int op2) throws StackException{
		int result = op2 - op1;
		cpu.push(result);
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "sub" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase Sub (si procede) o null
	 */
	public ByteCode parseAux(String s){
		if(s.toUpperCase().equals("SUB"))
			return new Sub();
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Sub, para poder mostrar la instrucción por pantalla
	 */
	public String toString(){
		return "SUB";
	}
}
