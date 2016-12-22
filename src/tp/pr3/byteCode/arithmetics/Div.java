package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
/**
 * Clase hija de la clase Arithmetics.
 * Esta clase realiza la instruccion de dividir un numero entre otro.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Div extends Arithmetics{
	
	/**
	 * Constructor de la clase Div
	 */
	public Div(){
		super();
	}
	/**
	 * Ejecuta la instruccion de sumar dos numeros, llamando al execute de la clase padre
	 * los saca de la pila de la cpu dada por parámetro y si ha sido posible se divide la subcima
	 * entre la cima, siempre que la cima no sea cero y el resultado se añade a la pila.
	 * @param cpu Una CPU de cuya pila vamos a extraer los operandos y donde vamos a almacenar
	 * el resultado
	 * @return boolean, true si ha podido realizarse la operacion y false eoc como que la cima sea cero
	 */
	public boolean executeAux(CPU cpu, int op1, int op2){
		int result = 0;
		boolean ok = false;
		if(op1 != 0){
			result = op2 / op1;
			ok = cpu.push(result);
		}
		return ok;
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "div" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase Div (si procede) o null
	 */
	public ByteCode parseAux(String s){
		if(s.toUpperCase().equals("DIV"))
			return new Div();
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Div, para poder mostrar la instrucción por pantalla
	 */
	public String toString(){
		return "DIV";
	}
}
