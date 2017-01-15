package tp.pr3.programs;

import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.exceptions.ArrayException;
/**
 * Clase que contiene el programa parseado del programa fuente
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class ParsedProgram {
	/**
	 * Array de String que contiene el programa fuente
	 */
	private Instruction[] pProgram;

	/**
	 * Int que contiene el n�mero de l�neas del programa fuente
	 */
	private int last;

	/**
	 * Constante que indica el tama�o m�ximo del programa fuente
	 */
	final private int MAX = 100;

	/**
	 * Constructor sin par�metros
	 */
	public ParsedProgram(){
		this.pProgram = new Instruction[MAX];
		this.last = 0;
	}
	
	/**
	 * Introduce una instrucci�n dada al final del programa parseado
	 * @param inst String que contiene la instrucci�n que queremos almacenar
	 * @throws ArrayException Array lleno
	 */
	public void write(Instruction inst) throws ArrayException{
		if(last == MAX)
			throw new ArrayException("(L�mite de instrucciones sobrepasado)");
		else{
			pProgram[last] = inst;
			++last;
		}
	}
	
	/**
	 * Devuelve el contenido del programa parseado almacenado en la posici�n dada
	 * @param pos Int que indica la posici�n del programa parseado que se quiere consultar
	 * @return Instruction que contiene la instrucci�n almacenada en esa posici�n del programa parseado
	 * @throws ArrayException Acceso a posici�n no v�lida del Array
	 */
	public Instruction at(int pos) throws ArrayException{
		if(pos >= 0 && pos < MAX)
			return pProgram[pos];
		else
			throw new ArrayException("(Posici�n del array no v�lida)");
	}
	/**
	 * Devuelve el n�mero de l�neas del programa parseado
	 * @return Int que contiene el n�mero de l�neas del programa parseado
	 */
	public int length(){
		return last;
	}

}
