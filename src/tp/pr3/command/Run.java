package tp.pr3.command;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.DivisionByZero;
import tp.pr3.exceptions.ExecutionError;
import tp.pr3.exceptions.StackException;
import tp.pr3.mv.Engine;
/**
 * Clase hija de la clase Command.
 * Clase que hace que se ejecute el programa almacenado en un objeto de la clase Engine
 * No tiene atributos
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */

public class Run implements Command{

	/**
	 * Metodo que hace que el engine dado por parametro ejecute el programa que tiene almacenado
	 * @param engine, que queremos que ejecute su programa almacenado
	 * @throws ExecutionError Lanza la excepcion BadFormatByteCode cuando el bytecode introducido no 
	 * tiene un formato válido
	 * @throws StackException Lanza la excepcion BadFormatByteCode cuando se produce un error en la pila
	 * @throws ArrayException Lanza la excepcion BadFormatByteCode cuando intentamos acceder a posiciones
	 * no válidas de un array
	 * @throws DivisionByZero Lanza la excepcion BadFormatByteCode cuando intentamos dividir entre cero
	 */
	public void execute(Engine engine) throws DivisionByZero, ArrayException, StackException, ExecutionError{
		engine.runProgram();
	}
	/**
	 * {@inheritDoc}
	 * s debe tener longitud 1, s[0] debe ser "RUN" 
	 * @return Command Run, si corresponde, o null, si no
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
