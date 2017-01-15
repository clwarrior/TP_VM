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
	 * Ejecuta la instrucci�n correspondiente sobre la CPU dada como parametro.
	 * @param cpu CPU
	 * @throws StackException Pila llena, Pila vac�a
	 * @throws DivisionByZero Divisi�n entre 0
	 * @throws ExecutionError Intento de salto a posici�n no v�lida
	 * @throws ArrayException Intento de acceso a posici�n no v�lida de la memoria
	 */
	abstract public void execute(CPU cpu) throws StackException, DivisionByZero, ExecutionError, ArrayException;
	
	/**
	 * Comprueba si el Array de String dado coincide con alg�n ByteCode.
	 * @param s Array de String que contiene la instrucci�n
	 * @return ByteCode de la instrucci�n a realizar, o null si no coincide con ninguna
	 */
	abstract public ByteCode parse(String[] s);
	
	/**
	 * Redefine el m�todo toString para la clase correspondiente.
	 */
	abstract public String toString();
	
}