package tp.pr3.command;

import tp.pr3.mv.Engine;

public class Compile implements Command {

	public void execute(Engine engine) {
		engine.compile();
	}

	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else
			return null;
	}

	public String textHelp() {
		return "COMPILE: Compila el programa fuente almacenado " + System.getProperty("line.separator");
	}

}
