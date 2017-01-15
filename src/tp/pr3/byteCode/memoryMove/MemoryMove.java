package tp.pr3.byteCode.memoryMove;

import tp.pr3.byteCode.ByteCode;

/**
 * Clase hija de ByteCode.
 * Clase abstracta que engloba los metodos que interact�an con la memoria.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public abstract class MemoryMove implements ByteCode{

	/**
	 * Int que indica la posici�n de memoria a la que se va a acceder
	 */
	protected int num;
	
	/**
	 * Constructor dada la posici�n de memoria.
	 * @param num Int al que queremos inicializar this.num
	 */
	public MemoryMove(int num){
		this.num=num;
	}
	
	/**
	 * Constructor sin par�metros.
	 */
	public MemoryMove(){}
	
	/**
	 * Comprueba que la longitud de la instrucci�n es la adecuada
	 * @param s Array de String que contiene la instrucci�n
	 * @return ByteCode de la instrucci�n a realizar, o null si no coincide con ninguna
	 */
	public ByteCode parse(String[] s){
		if(s.length == 2)
			return this.parseAux(s);
		else
			return null;
	}
	
	/**
	 * M�todo abstracto que devuelve un ByteCode de la instrucci�n correspondiente al String dado, 
	 * o null si no corresponde a ninguna.
	 * @param s Array de String que contiene la instrucci�n
	 * @return ByteCode de la instrucci�n correspondiente, o null si no coincide con ninguna
	 */
	public abstract ByteCode parseAux(String[] s);
}
