package tp.pr3.lexicalAnalysis;

import tp.pr3.analyze.ParsedProgram;
import tp.pr3.analyze.SourceProgram;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.instructions.Instruction;
import tp.pr3.lexicalAnalysis.instructions.InstructionParser;

public class LexicalParser {
	private SourceProgram sProgram;
	private int programCounter;
	
	public LexicalParser(SourceProgram sProgram) {
		this.sProgram = sProgram;
		this.programCounter = 0;
	}

	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws ArrayException, LexicalAnalysisException {
		boolean stop=false;
		while(!stop && this.programCounter<=sProgram.length()){
			String instr = sProgram.at(this.programCounter);
			if (instr.trim().equalsIgnoreCase(stopKey)){
					stop = true;
			}
			else {
				Instruction instruction = InstructionParser.parse(instr,this);
				pProgram.write(instruction);
				this.increaseProgramCounter();
			}
		}
	}

	public void increaseProgramCounter() {
		++this.programCounter;
	}

}
