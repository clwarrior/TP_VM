package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de MemoryMove (hija de ByteCode).
 * Almacena la cima de la pila en la posición de memoria indicada por this.num.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Store implements ByteCode{
	
	/**
	 * Int que indica la posición de memoria a la que se va a acceder
	 */
	private int num;
	
	/**
	 * Constructor dada la posición de memoria.
	 * @param num Int al que queremos inicializar this.num
	 */
	public Store(int num){
		this.num=num;
	}
	
	/**
	 * Constructor sin parámetros.
	 */
	public Store(){}
	
	/**
	 * {@inheritDoc}
	 * Introduce la cima de la pila en la posición de memoria this.num.
	 * @throws ArrayException Intento de acceso a posición no válida de la memoria
	 * @throws StackException Pila vacía
	 */
	public void execute(CPU cpu) throws ArrayException, StackException{
		int elem=cpu.pop();
		cpu.store(num, elem);
	}
	
	/**
	 * Método abstracto que devuelve un ByteCode STORE si el string dado corresponde o null si no
	 * @param s Array de String que contiene la instrucción
	 * @return Store si corresponde o null si no
	 */
	public ByteCode parse(String[] s){
		try {
			if (s.length == 2 && s[0].equalsIgnoreCase("STORE") && Integer.parseInt(s[1]) >= 0)
				return new Store(Integer.parseInt(s[1]));
			else
				return null;
		}
		catch (NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * Redefine el metodo toString para la clase Store.
	 */
	public String toString(){
		return "STORE "+num;
	}
}
