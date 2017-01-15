package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Interfaz que engloba todas las instrucciones ByteCode.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public interface ByteCode {

	/**
	 * Ejecuta la instrucción correspondiente sobre la CPU dada como parametro.
	 * @param cpu CPU
	 * @throws StackException Pila llena, Pila vacía
	 * @throws DivisionByZero División entre 0
	 * @throws ExecutionError Intento de salto a posición no válida
	 * @throws ArrayException Intento de acceso a posición no válida de la memoria
	 */
	abstract public void execute(CPU cpu) throws StackException, DivisionByZero, ExecutionError, ArrayException;
	
	/**
	 * Comprueba si el Array de String dado coincide con algún ByteCode.
	 * @param s Array de String que contiene la instrucción
	 * @return ByteCode de la instrucción a realizar, o null si no coincide con ninguna
	 */
	abstract public ByteCode parse(String[] s);
	
	/**
	 * Redefine el método toString para la clase correspondiente.
	 */
	abstract public String toString();
	
}