package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
/**
 * Clase hija de la clase ByteCode.
 * Esta clase da a la cpu la instruccion de añadir un entero a la pila de la cpu 
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Push implements ByteCode{
	/**
	 * Un int que nos indica el numero a introducir en la pila
	 */
	private int num;
	/**
	 * Constructor que inicializa this.num a num dado por paramatro
	 * @param num Un int al que vamos a inicializar el atributo this.num
	 */
	public Push(int num){
		this.num = num;
	}
	 /**
	  * Constructor sin parametros
	  */
	public Push() {}
	/**
	 * Invoca al metodo push de la cpu dada por parametro haciendo que añada num a la stack de cpu
	 * @param cpu Una CPU a cuya pila vamos a añadir num
	 * @return boolean, true siempre
	 */
	public boolean execute(CPU cpu){
		return cpu.push(num);
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "push" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase Push (si procede) o null
	 */
	public ByteCode parse(String[] s){
		if (s.length==2 && s[0].equalsIgnoreCase("PUSH"))
			return new Push(Integer.parseInt(s[1]));
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Push para poder la instruccion
	 */
	public String toString(){
		return "PUSH "+ num;
	}
}
