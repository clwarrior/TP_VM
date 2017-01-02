package tp.pr3.command;

import tp.pr3.mv.Engine;

/**
 * Clase hija de la clase Command.
 * Clase que nos permite mostrar la ayuda asociada a un programa de Bytecode.
 * No tiene argumentos.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Help implements Command{

	/**
	 * Metodo que hace que el engine dado por parametro muestra la ayuda asociada a
	 * su programa de byteCodes
	 * @param engine, que queremos que muestre la ayuda
	 */
	public void execute(Engine engine){
		engine.showHelp();
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "help" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeyo de clase Help (si procede) o null
	 */
	public Command parse(String[] s){
		if (s.length==1 && s[0].equalsIgnoreCase("HELP"))
			return new Help();
		else
			return null;
	}
	/**
	 * Muestra por pantalla la ayuda asociada al comando Help
	 */
	public String textHelp(){
		return "HELP: Muestra menu de ayuda " + System.getProperty("line.separator");
	}
	/**
	 * Redefine el metodo toString para la clase Help, para poder mostrar el comando por pantalla
	 */
	public String toString(){
		return "HELP";
	}
}
