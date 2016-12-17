package tp.pr3.byteCode.memoryMove;

import tp.pr3.byteCode.ByteCode;

/**
 * Clase abstracta que engloba los metodos que mueven elementos de la memoria
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public abstract class MemoryMove implements ByteCode{

	/**
	 * Un int num que indica una posicion de la memoria
	 */
	protected int num;
	/**
	 * Constructor con parametros. Inicializa this.num a num.
	 * @param num Un int dado como parametro.
	 */
	public MemoryMove(int num){
		this.num=num;
	}
	/**
	 * Constructor de MemoryMove sin parametros.
	 */
	public MemoryMove(){}
	
	/**
	 * Comprueba que la longitud del array es dos y llama al metodo abstracto parseAux 
	 * pasandole el array como parametro
	 * @param s Un array de String que debe tener el numbre de una instruccion
	 * @return Un ByteCode devuelto por parseAux o null
	 */
	public ByteCode parse(String[] s){
		if(s.length == 2)
			return this.parseAux(s);
		else
			return null;
	}
	/**
	 * Metodo abstracto que comprobara que el array s dado por parametro es el nombre de la
	 * instruccion correspondiente a la clase y crea y devuelve un ByteCode de esa clase o null
	 * si s no es correcto
	 * @param s Un array de Strings
	 * @return Un ByteCode si s es correcto, null eoc
	 */
	public abstract ByteCode parseAux(String[] s);
}
