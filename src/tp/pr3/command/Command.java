package tp.pr3.command;

import tp.pr3.exceptions.*;
import tp.pr3.mv.Engine;

/**
 * Interfaz que engloba todos los comandos.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public interface Command {

	/**
	 * M�todo que ejecuta el comando.
	 * @param engine Engine sobre el que se ejecutan los comandos
	 * @throws ArrayException Intento de acceso a posici�n no v�lida, Array lleno
	 * @throws LexicalAnalysisException Instrucci�n incorrecta introducida, Falta fin del programa
	 * @throws FileException No se encuentra el fichero, Error de lectura
	 * @throws BadFormatByteCode ByteCode incorrecto introducido
	 * @throws ExecutionError Intento de salto a posici�n no v�lida
	 * @throws StackException Pila llena, pila vac�a
	 * @throws DivisionByZero Divisi�n entre 0
	 * @throws CompilationError Error al compilar el programa
	 */
	abstract public void execute(Engine engine) throws LexicalAnalysisException, ArrayException, FileException, 
													   BadFormatByteCode, DivisionByZero, StackException, 
													   ExecutionError, CompilationError;
	
	/**
	 * M�todo que crea el comando correspondiente a s, si existe.
	 * @param s Array de String que contiene el comando 
	 * @return Command correspondiente, si lo hay, o null en caso contrario
	 */
	abstract public Command parse(String[] s);
	
	/**
	 * M�todo que muestra la ayuda asociada a un comando.
	 * @return String que contiene el texto de ayuda del comando
	 */
	abstract public String textHelp();

	/**
	 * Redefine el metodo toString para la clase Command.
	 */
	abstract public String toString();
	
}

