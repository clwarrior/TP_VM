package tp.pr3.programs;

import tp.pr3.exceptions.ArrayException;

/**
 * Clase que contiene el programa fuente leído del fichero
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class SourceProgram {
	
	/**
	 * Array de String que contiene el programa fuente
	 */
	private String[] sProgram;
	
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
	public SourceProgram(){
		this.sProgram = new String[MAX];
		this.last = 0;
	}
	
	/**
	 * Introduce una instrucción dada al final del programa fuente
	 * @param inst String que contiene la instrucción que queremos almacenar
	 * @throws ArrayException Array lleno
	 */
	public void write(String inst) throws ArrayException{
		if(last == MAX)
			throw new ArrayException("(Límite de líneas sobrepasado)");
		else{
			sProgram[last] = inst;
			++last;
		}
	}
	
	/**
	 * Devuelve el contenido del programa fuente almacenado en la posición dada
	 * @param pos Int que indica la posición del programa fuente que se quiere consultar
	 * @return String que contiene la línea almacenada en esa posición del programa fuente
	 * @throws ArrayException Acceso a posición no válida del Array
	 */
	public String at(int pos) throws ArrayException{
		if(pos >= 0 && pos < MAX)
			return sProgram[pos];
		else
			throw new ArrayException("(Posición del array no válida)");
	}
	
	/**
	 * Devuelve el número de líneas del programa fuente
	 * @return Int que contiene el número de líneas del programa fuente
	 */
	public int length(){
		return last;
	}
	
	/**
	 * Redefine el método toString para la clase SourceProgram
	 */
	public String toString() {
		String show = "";
		for(int i = 0; i < last; ++i)
			show = show + i + ": " + sProgram[i] + '\n';
		return show;
	}
}
