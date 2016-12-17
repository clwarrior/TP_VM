package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
/**
 * Clase hija de la clase ByteCode.
 * Esta clase da a la cpu la instruccion de parar el programa de ByteCodes
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Halt implements ByteCode {

	/**
	 * Invoca al metodo trueEnd de la cpu dada por parametro haciendo que acabe el programa
	 * @param cpu Una CPU cuyo programa vamos a parar
	 * @return boolean, true siempre
	 */
	public boolean execute(CPU cpu){
		cpu.end();
		return true;
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "halt" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeto de clase Halt (si procede) o null
	 */
	public ByteCode parse(String[] s){
		if (s.length==1 && s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Halt para poder la instruccion
	 */
	public String toString(){
		return "HALT";
	}
}
