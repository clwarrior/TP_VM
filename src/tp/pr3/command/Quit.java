package tp.pr3.command;

import tp.pr3.mv.Engine;

/**
 * Clase hija de la clase Command.
 * Clase que nos permite acabar el programa de Bytecode. No tiene atributos
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Quit implements Command{

	/**
	 * Llama al metodo quitProgram de la clase Engine sobre engine, dado por parametro indicando 
	 * que acaba el programa de byteCodes
	 * @return true
	 */
	public void execute(Engine engine){
		engine.quitProgram();
	}
	/**
	 * {@inheritDoc}
	 * s debe tener longitud 1, s[0] debe ser "QUIT" 
	 * @return Command Quit, si corresponde, o null, si no
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
