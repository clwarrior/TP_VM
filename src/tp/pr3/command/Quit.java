package tp.pr3.command;

import tp.pr3.mv.Engine;

/**
 * Clase hija de la clase Command.
 * Clase que nos permite acabar el programa de Bytecode. No tiene atributos
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Quit implements Command{

	/**
	 * Llama al metodo quitProgram de la clase Engine sobre engine, dado por parametro indicando 
	 * que acaba el programa de byteCodes
	 * @return true
	 */
	public boolean execute(Engine engine){
		return engine.quitProgram();
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "quit" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeyo de clase Quit (si procede) o null
	 */
	public Command parse(String[] s){
		if (s.length==1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else
			return null;
	}
	/**
	 * Muestra por pantalla la ayuda asociada al comando quit
	 */
	public String textHelp(){
		return "QUIT: Cierra la maquina virtual " + System.getProperty("line.separator");
	}
	/**
	 * Redefine el metodo toString para la clase Quit, para poder mostrar el comando por pantalla
	 */
	public String toString(){
		return "QUIT";
	}
}
