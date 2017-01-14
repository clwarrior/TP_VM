package tp.pr3.analyze;

import tp.pr3.exceptions.ArrayException;

public class SourceProgram {
	
	private String[] sProgram;
	private int last;

	final private int MAX = 100;
	
	public SourceProgram(){
		this.sProgram = new String[MAX];
		this.last = 0;
	}
	
	public void write(String inst) throws ArrayException{
		if(last == MAX)
			throw new ArrayException("(Límite de líneas sobrepasado)");
		else{
			sProgram[last] = inst;
			++last;
		}
	}
	public String at(int pos) throws ArrayException{
		if(pos >= 0 && pos < MAX)
			return sProgram[pos];
		else
			throw new ArrayException("(Posición del array no válida)");
	}
	
	public int length(){
		return last;
	}
	
	public String toString() {
		String show = "";
		for(int i = 0; i < last; ++i)
			show = show + i + ": " + sProgram[i] + '\n';
		return show;
	}
}
