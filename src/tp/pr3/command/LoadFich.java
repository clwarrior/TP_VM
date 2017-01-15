package tp.pr3.command;

import tp.pr3.exceptions.*;
import tp.pr3.mv.Engine;

/**
 * Clase hija de Command.
 * Ejecuta la orden de leer un programa de fichero
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class LoadFich implements Command{
	
	/**
	 * String que contiene el nombre del fichero que se quiere leer.
	 */
	private String fich;

	/**
	 * Constructor sin parámetros.
	 */
	public LoadFich(){}
	
	/**
	 * Constructor dado el nombre del fichero.
	 * @param fich String al que se inicializa this.fich
	 */
	public LoadFich(String fich){
		this.fich = fich;
	}
	
	/**
	 * {@inheritDoc}
	 * Ejecuta Load fich llamando a engine.loadfich().
	 * @throws ArrayException Array lleno
	 * @throws FileException Fichero no encontrado, Error de lectura
	 */
	public void execute(Engine engine) throws ArrayException, FileException {
		engine.loadFich(fich);
	}

	/**
	 * {@inheritDoc}
	 * s debe tener longitud 2, s[0] debe ser "LOAD" y s[1] debe ser un número mayor o igual que 0.
	 * @return Command LoadFich, si corresponde, o null, si no
	 */
	public Command parse(String[] s) {
		if (s.length==2 && s[0].equalsIgnoreCase("LOAD"))
			return new LoadFich(s[1]);
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * (LoadFich).
	 */
	public String textHelp() {
		return "LOAD FICH: Carga el fichero FICH como programa fuente" + System.getProperty("line.separator");
	}
	
	/**
	 * Redefine el método toString para la clase LoadFich.
	 */
	public String toString() {
		return "LOAD " + fich;
	}
	
}
