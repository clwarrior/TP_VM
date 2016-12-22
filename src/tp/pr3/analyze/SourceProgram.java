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
			throw new ArrayException("Array lleno");
		else{
			sProgram[last] = inst;
			++last;
		}
	}
}
