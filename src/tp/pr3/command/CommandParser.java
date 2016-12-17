package tp.pr3.command;


/**
 * Clase que se encarga de interpretar los comandos introducidos por teclado
 * @author Claudia Guerrero y Rafael Herrera
 * @version 1.0 12-11-2016
 */

public class CommandParser {

	/**
	 * Array que contiene un comando de cada uno de los tipos existentes
	 */
	private final static Command[] commands = {
		new Help(), new Quit(), new Replace(), new Run()};

	/**
	 * Dado un String que contiene la instruccion, la interpreta y la convierte en un comando valido si puede
	 * @param line Un String que contiene la instruccion introducida por teclado que se desea interpretar
	 * @return Un comando valido o null si la intruccion dada no era correcta
	 */
	public static Command parse(String line){
		String subcads[] = line.split(" ");
		Command comando = null;
		int i=0;
		while(comando==null && i<commands.length){
			comando= commands[i].parse(subcads);
			++i;
		}
		return comando;
	}
	/**
	 * Muestra la ayuda asociada a cada uno de los 6 comandos que hay, llamando para cada uno
	 * al metodo textHelp de cada clase
	 */
	public static void showHelp(){
		for(int i = 0; i < commands.length ; ++i){
			System.out.print(commands[i].textHelp());
		}
	}
}
