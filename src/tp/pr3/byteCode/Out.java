package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.StackException;
/**
 * Clase hija de la clase ByteCode.
 * Esta clase da a la cpu la instruccion de sacar un entero de la pila y mostrarlo 
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Out implements ByteCode{

	/**
	 * Comprueba que la cpu no esta vacia y entonces invoca al metodo pop de la cpu dada 
	 * por parametro haciendo que quite el ultimo elemento de la stack de cpu y lo muestre
	 * por pantalla
	 * @param cpu Una CPU a cuya pila vamos a quitar el ultimo elemento
	 * @throws StackException Si la pila está vacía
	 */
	public void execute(CPU cpu) throws StackException{
		System.out.println("Consola: " + cpu.pop());		
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "out" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase Out (si procede) o null
	 */
	public ByteCode parse(String[] s){
		if (s.length==1 && s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Out para poder mostrar la instruccion
	 */
	public String toString(){
		return "OUT";
	}
}
