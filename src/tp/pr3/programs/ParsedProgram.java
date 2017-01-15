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
	 * Int que contiene el número de líneas del programa fuente
	 */
	private int last;

	/**
	 * Constante que indica el tamaño máximo del programa fuente
	 */
	final private int MAX = 100;

	/**
	 * Constructor sin parámetros
	 */
	public ParsedProgram(){
		this.pProgram = new Instruction[MAX];
		this.last = 0;
	}
	
	/**
	 * Introduce una instrucción dada al final del programa parseado
	 * @param inst String que contiene la instrucción que queremos almacenar
	 * @throws ArrayException Array lleno
	 */
	public void write(Instruction inst) throws ArrayException{
		if(last == MAX)
			throw new ArrayException("(Límite de instrucciones sobrepasado)");
		else{
			pProgram[last] = inst;
			++last;
		}
	}
	
	/**
	 * Devuelve el contenido del programa parseado almacenado en la posición dada
	 * @param pos Int que indica la posición del programa parseado que se quiere consultar
	 * @return Instruction que contiene la instrucción almacenada en esa posición del programa parseado
	 * @throws ArrayException Acceso a posición no válida del Array
	 */
	public Instruction at(int pos) throws ArrayException{
		if(pos >= 0 && pos < MAX)
			return pProgram[pos];
		else
			throw new ArrayException("(Posición del array no válida)");
	}
	/**
	 * Devuelve el número de líneas del programa parseado
	 * @return Int que contiene el número de líneas del programa parseado
	 */
	public int length(){
		return last;
	}

}
