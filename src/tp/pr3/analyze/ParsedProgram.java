package tp.pr3.analyze;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.lexicalAnalysis.instructions.Instruction;

public class ParsedProgram {
	private Instruction[] pProgram;
	private int last;

	final private int MAX = 100;
	
	public ParsedProgram(){
		this.pProgram = new Instruction[MAX];
		this.last = 0;
	}
	
	public void write(Instruction inst) throws ArrayException{
		if(last == MAX)
			throw new ArrayException("Array lleno");
		else{
			pProgram[last] = inst;
			++last;
		}
	}

}
