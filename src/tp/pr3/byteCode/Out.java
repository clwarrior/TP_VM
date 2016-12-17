package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
/**
 * Clase hija de la clase ByteCode.
 * Esta clase da a la cpu la instruccion de sacar un entero de la pila y mostrarlo 
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Out implements ByteCode{

	/**
	 * Comprueba que la cpu no esta vacia y entonces invoca al metodo pop de la cpu dada 
	 * por parametro haciendo que quite el ultimo elemento de la stack de cpu y lo muestre
	 * por pantalla
	 * @param cpu Una CPU a cuya pila vamos a quitar el ultimo elemento
	 * @return boolean, true si la pila no esta vecia, false eoc
	 */
	public boolean execute(CPU cpu){
		if(!cpu.empty()) {
			System.out.println(cpu.pop());
			return true;
		}
		else
			return false;		
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
	 * Redefine el metodo toString para la clase Out para poder la instruccion
	 */
	public String toString(){
		return "OUT";
	}
}
