package tp.pr3.command;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.BadFormatByteCode;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.exceptions.DivisionByZero;
import tp.pr3.exceptions.ExecutionError;
import tp.pr3.exceptions.FileException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.exceptions.StackException;
import tp.pr3.mv.Engine;

/**
 * Clase abstracta que contiene las operaciones necesarias a realizar sobre los comandos.
 * No tiene atributos.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public interface Command {

	/**
	 * Metodo abstacto con el cual cada comando se ejecutara
	 * @param engine Un Engine sobre el cual ejecutaremos los comandos
	 * @return boolean
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 * @throws FileException 
	 * @throws BadFormatByteCode 
	 * @throws ExecutionError 
	 * @throws StackException 
	 * @throws DivisionByZero 
	 * @throws CompilationError 
	 */
	abstract public void execute(Engine engine) throws LexicalAnalysisException, ArrayException, FileException, 
													   BadFormatByteCode, DivisionByZero, StackException, ExecutionError, CompilationError;
	/**
	 * Metodo abstacto con el cual cada comando se creara si el string dado corresponde con 
	 * el nombre del comando
	 * @param String[] s Un array que contiene el nombre de un comando 
	 * @return Command de la clase correspondiente si ha sido creado, null si no
	 */
	abstract public Command parse(String[] s);
	/**
	 * Metodo abstacto con el cual cada comando mostrará su ayuda asociada
	 * @return String, ayuda asociada
	 */
	abstract public String textHelp();

	/**
	 * Redefine el metodo toString para la clase Command para poder escribir comandos
	 */
	abstract public String toString();
	
}

