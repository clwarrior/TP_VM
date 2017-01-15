package tp.pr3.command;

/**
 * Clase que se encarga de interpretar los comandos introducidos.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class CommandParser {

	/**
	 * Array que contiene un comando de cada tipo
	 */
	private final static Command[] commands = {
		new Help(), new Quit(), new Replace(), new Run(), new LoadFich(), new Compile()};

	/**
	 * Prueba a interpretar el comando dado como todos los tipos de Command, devolviendo el que encaje, o null
	 * @param line String que contiene el comando que se desea interpretar
	 * @return Command correspondiente, si lo hay, o null en caso contrario
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
	 * Muestra la ayuda asociada a cada Command, llamando al textHelp de cada uno
	 */
	public static void showHelp(){
		for(int i = 0; i < commands.length ; ++i){
			System.out.print(commands[i].textHelp());
		}
	}
}
