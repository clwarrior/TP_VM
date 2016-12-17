package tp.pr3.command;

import tp.pr3.mv.Engine;
/**
 * Clase hija de la clase Command.
 * Clase que hace que se ejecute el programa almacenado en un objeto de la clase Engine
 * No tiene atributos
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */

public class Run implements Command{

	/**
	 * Metodo que hace que el engine dado por parametro ejecute el programa que tiene almacenado
	 * @param engine, que queremos que ejecute su programa almacenado
	 */
	public boolean execute(Engine engine){
		return engine.runProgram();
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el el string dado por parametro sea "run" 
	 * (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @return nuevo objeyo de clase Run (si procede) o null
	 */
	public Command parse(String[] s){
		if (s.length==1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else
			return null;
	}
	/**
	 * Muestra por pantalla la ayuda asociada al comando run
	 */
	public String textHelp(){
		return "RUN: Ejecuta el programa almacenado " + System.getProperty("line.separator");
	}
	/**
	 * Redefine el metodo toString para la clase Run
	 */
	public String toString(){
		return "RUN";
	}
}
