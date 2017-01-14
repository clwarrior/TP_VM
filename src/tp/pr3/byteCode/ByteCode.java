package tp.pr3.byteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.DivisionByZero;
import tp.pr3.exceptions.ExecutionError;
import tp.pr3.exceptions.StackException;

/**
 * Clase abstracta que engloba todas las instrucciones ByteCode
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public interface ByteCode {

	/**
	 * Ejecutar� la instrucci�n correspondiente sobre la cpu dada como parametro
	 * @param cpu, Una CPU sobre la cual ejecutaremos las instrucciones ByteCode
	 * @return boolean, true si la ejecuci�n fue correcta, false eoc
	 * @throws StackException 
	 * @throws DivisionByZero 
	 * @throws ExecutionError 
	 * @throws ArrayException 
	 */
	abstract public void execute(CPU cpu) throws StackException, DivisionByZero, ExecutionError, ArrayException;
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