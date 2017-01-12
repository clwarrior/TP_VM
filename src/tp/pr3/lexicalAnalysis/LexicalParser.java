package tp.pr3.lexicalAnalysis;

import tp.pr3.analyze.ParsedProgram;
import tp.pr3.analyze.SourceProgram;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.lexicalAnalysis.instructions.Instruction;

public class LexicalParser {
	private SourceProgram sProgram;
	private int programCounter;

	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws ArrayException {
		boolean stop=false;
		while(!stop && this.programCounter<=sProgram.length()){
			String instr = sProgram.at(this.programCounter);
			if (instr.equalsIgnoreCase(stopKey)){
					stop = true;
			}
			else {
				Instruction instruction = InstructionParser.parse(instr,this);
				pProgram.write(instruction);
			}
			this.increaseProgramCounter();
		}
	}

	public void increaseProgramCounter() {
		++this.programCounter;
	}

}
