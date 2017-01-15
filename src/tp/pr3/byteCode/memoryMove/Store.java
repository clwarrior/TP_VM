package tp.pr3.byteCode.memoryMove;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de MemoryMove (hija de ByteCode).
 * Almacena la cima de la pila en la posición de memoria indicada por this.num.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Store extends MemoryMove{
	
	/**
	 * Constructor dada la posición de memoria.
	 * @param num Int al que se inicializa this.num
	 */
	public Store(int num){
		super(num);
	}
	
	/**
	 * Constructor sin parámetros.
	 */
	public Store() {
		super();
	}
	
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
	 * {@inheritDoc}
	 * s[0] debe ser "STORE" y s[1] debe ser un numero mayor o igual que 0.
	 */
	public ByteCode parseAux(String[] s){
		try {
			if (s[0].equalsIgnoreCase("STORE") && Integer.parseInt(s[1]) >= 0)
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
