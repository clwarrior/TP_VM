package tp.pr3.command;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.BadFormatByteCode;
import tp.pr3.mv.Engine;

/**
 * Clase hija de la clase Command.
 * Clase que nos permite sustutuir una instruccion del programa de Bytecode por otra que intrucimos por
 * pantalla. Tiene un int que indica el numero de la instruccion a a sustituir
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Replace implements Command{

	/**
	 * Int que indica el numero de la instruccion a a sustituir
	 */
	private int replace;
	/**
	 * Constructor sin parametros
	 */
	public Replace(){}
	
	/**
	 * Constructor que inicializa this.replace a replace
	 * @param replace, int al que inicializamos this.replace
	 */
	public Replace(int replace){
		this.replace = replace;
	}
	/**
	 * Metodo que hace que el engine dado por parametro reemplace la instruccion de la posicion 
	 * replace del programa que tiene almacenado
	 * @param engine, que queremos que reemplace una instruccion de su programa almacenado
	 * @throws BadFormatByteCode 
	 * @throws ArrayException 
	 */
	public void execute(Engine engine) throws ArrayException, BadFormatByteCode{
		engine.replaceInstruc(replace);
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "replace" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeyo de clase Replace (si procede) o null
	 */
	public Command parse(String[] s){
		if (s.length==2 && s[0].equalsIgnoreCase("REPLACE"))
			return new Replace(Integer.parseInt(s[1]));
		else
			return null;
	}
	/**
	 * Muestra por pantalla la ayuda asociada al comando replace
	 */
	public String textHelp(){
		return "REPLACE: Reemplaza la instruccion de una posición dada " + System.getProperty("line.separator");
	}
	/**
	 * Redefine el metodo toString para la clase Replace, para poder mostrar el comando por pantalla
	 */
	public String toString(){
		return "REPLACE " + replace;
	}
}
