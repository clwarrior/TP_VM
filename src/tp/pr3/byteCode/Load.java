package tp.pr3.byteCode;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de la MemoryMove (hija de ByteCode).
 * Introduce el elemento de la posición de memoria num en la pila
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Load implements ByteCode{
	
	/**
	 * Int que indica la posición de memoria a la que se va a acceder
	 */
	protected int num;
	
	/**
	 * Constructor dada la posición de memoria.
	 * @param num Int al que queremos inicializar this.num
	 */
	public Load(int num){
		this.num=num;
	}
	
	/**
	 * Constructor sin parámetros.
	 */
	public Load(){}
	
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
	 * Método abstracto que devuelve un ByteCode LOAD si el string dado corresponde o null si no
	 * @param s Array de String que contiene la instrucción
	 * @return Load si corresponde o null si no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD") && Integer.parseInt(s[1]) >= 0) {
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
