package tp.pr3.programs;

import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.exceptions.ArrayException;

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
			throw new ArrayException("(L�mite de instrucciones sobrepasado)");
		else{
			pProgram[last] = inst;
			++last;
		}
	}
	public Instruction at(int pos) throws ArrayException{
		if(pos >= 0 && pos < MAX)
			return pProgram[pos];
		else
			throw new ArrayException("(Posici�n del array no v�lida)");
	}
	public int length(){
		return last;
	}

}
