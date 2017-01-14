package tp.pr3.command;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.FileException;
import tp.pr3.mv.Engine;

public class LoadFich implements Command{
	
	private String fich;

	public LoadFich(){}
	public LoadFich(String fich){
		this.fich = fich;
	}
	
	public void execute(Engine engine) throws ArrayException, FileException {
		engine.loadFich(fich);
	}

	public Command parse(String[] s) {
		if (s.length==2 && s[0].equalsIgnoreCase("LOAD"))
			return new LoadFich(s[1]);
		else
			return null;
	}

	
	public String textHelp() {
		return "LOAD FICH: Carga el fichero FICH como programa fuente" + System.getProperty("line.separator");
	}
	
	public String toString() {
		return "LOAD FICH";
	}
	
}
