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
			throw new ArrayException("(Límite de instrucciones sobrepasado)");
		else{
			pProgram[last] = inst;
			++last;
		}
	}
	public Instruction at(int pos) throws ArrayException{
		if(pos >= 0 && pos < MAX)
			return pProgram[pos];
		else
			throw new ArrayException("(Posición del array no válida)");
	}
	public int length(){
		return last;
	}

}
