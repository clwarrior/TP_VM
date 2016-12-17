package tp.pr3.byteCode;
//prueba de cambio
import tp.pr3.cpu.CPU;

/**
 * Clase abstracta que engloba todas las instrucciones ByteCode
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public interface ByteCode {

	/**
	 * Ejecutará la instrucción correspondiente sobre la cpu dada como parametro
	 * @param cpu, Una CPU sobre la cual ejecutaremos las instrucciones ByteCode
	 * @return boolean, true si la ejecución fue correcta, false eoc
	 */
	abstract public boolean execute(CPU cpu);
	/**
	 * Comprueba si el array de cadenas dado como parametro corresponde con el nombre de la clase 
	 * y si es asi devolvera un objeto de la clase, si no null
	 * @param s, array de String que contiene el nombre de una instruccion
	 * @return Un objeto de la clase si es la correcta, null eoc
	 */
	abstract public ByteCode parse(String[] s);
	/**
	 * Redefinira el metodo toString para cada clase hija
	 */
	abstract public String toString();
	
}
