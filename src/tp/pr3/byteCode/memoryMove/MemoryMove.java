package tp.pr3.byteCode.memoryMove;

import tp.pr3.byteCode.ByteCode;

/**
 * Clase hija de ByteCode.
 * Clase abstracta que engloba los metodos que interactúan con la memoria.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public abstract class MemoryMove implements ByteCode{

	/**
	 * Int que indica la posición de memoria a la que se va a acceder
	 */
	protected int num;
	
	/**
	 * Constructor dada la posición de memoria.
	 * @param num Int al que queremos inicializar this.num
	 */
	public MemoryMove(int num){
		this.num=num;
	}
	
	/**
	 * Constructor sin parámetros.
	 */
	public MemoryMove(){}
	
	/**
	 * Comprueba que la longitud de la instrucción es la adecuada
	 * @param s Array de String que contiene la instrucción
	 * @return ByteCode de la instrucción a realizar, o null si no coincide con ninguna
	 */
	public ByteCode parse(String[] s){
		if(s.length == 2)
			return this.parseAux(s);
		else
			return null;
	}
	
	/**
	 * Método abstracto que devuelve un ByteCode de la instrucción correspondiente al String dado, 
	 * o null si no corresponde a ninguna.
	 * @param s Array de String que contiene la instrucción
	 * @return ByteCode de la instrucción correspondiente, o null si no coincide con ninguna
	 */
	public abstract ByteCode parseAux(String[] s);
}
