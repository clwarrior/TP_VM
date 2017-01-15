package tp.pr3.programs;

import tp.pr3.exceptions.ArrayException;

/**
 * Clase que contiene el programa fuente le�do del fichero
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class SourceProgram {
	
	/**
	 * Array de String que contiene el programa fuente
	 */
	private String[] sProgram;
	
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
	public SourceProgram(){
		this.sProgram = new String[MAX];
		this.last = 0;
	}
	
	/**
	 * Introduce una instrucci�n dada al final del programa fuente
	 * @param inst String que contiene la instrucci�n que queremos almacenar
	 * @throws ArrayException Array lleno
	 */
	public void write(String inst) throws ArrayException{
		if(last == MAX)
			throw new ArrayException("(L�mite de l�neas sobrepasado)");
		else{
			sProgram[last] = inst;
			++last;
		}
	}
	
	/**
	 * Devuelve el contenido del programa fuente almacenado en la posici�n dada
	 * @param pos Int que indica la posici�n del programa fuente que se quiere consultar
	 * @return String que contiene la l�nea almacenada en esa posici�n del programa fuente
	 * @throws ArrayException Acceso a posici�n no v�lida del Array
	 */
	public String at(int pos) throws ArrayException{
		if(pos >= 0 && pos < MAX)
			return sProgram[pos];
		else
			throw new ArrayException("(Posici�n del array no v�lida)");
	}
	
	/**
	 * Devuelve el n�mero de l�neas del programa fuente
	 * @return Int que contiene el n�mero de l�neas del programa fuente
	 */
	public int length(){
		return last;
	}
	
	/**
	 * Redefine el m�todo toString para la clase SourceProgram
	 */
	public String toString() {
		String show = "";
		for(int i = 0; i < last; ++i)
			show = show + i + ": " + sProgram[i] + '\n';
		return show;
	}
}
