package tp.pr3.byteCode.memoryMove;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de la MemoryMove (hija de ByteCode).
 * Introduce el elemento de la posición de memoria num en la pila
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Load extends MemoryMove {
	
	/**
	 * Constructor dada la posición de memoria.
	 * @param num Int al que se quiere inicializar this.num
	 */
	public Load(int num){
		super(num);
	}
	
	/**
	 * Constructor sin parámetros.
	 */
	public Load() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 * Introduce en la pila el elemento que se encuentra en la posición de memoria this.num.
	 * @throws ArrayException Intento de acceso a posición no válida de la memoria
	 * @throws StackException Pila llena
	 */
	public void execute(CPU cpu) throws ArrayException, StackException{
		int valor=cpu.load(num);
		cpu.push(valor);
	}
	
	/**
	 * {@inheritDoc}
	 * s[0] debe ser "LOAD" y s[1] debe ser un número mayor o igual que 0
	 * @return ByteCode Load, si corresponde, o null, si no
	 */
	public ByteCode parseAux(String[] s){
		if (s[0].equalsIgnoreCase("LOAD") && Integer.parseInt(s[1]) >= 0) {
			try {
				return new Load(Integer.parseInt(s[1]));
			}
			catch(NumberFormatException e) {
				return null;
			}
		}
		else
			return null;
	}
	
	/**
	 * Redefine el metodo toString para la clase Load
	 */
	public String toString(){
		return "LOAD " + num;
	}
}
