package tp.pr3.compilation;

import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.compilation.instructions.InstructionParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.programs.ParsedProgram;
import tp.pr3.programs.SourceProgram;

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
			if(instr == null) {
				throw new LexicalAnalysisException("(No se ha detectado fin del programa)");
			}
			else if (instr.trim().equalsIgnoreCase(stopKey)){
				stop = true;
			}
			else {
				Instruction instruction = InstructionParser.parse(instr,this);
				if(instruction == null) {
					throw new LexicalAnalysisException("(La instrucción " + this.programCounter + " no es válida)");
				}
				else {
					pProgram.write(instruction);
					this.increaseProgramCounter();
				}
			}
		}
	}

	public void increaseProgramCounter() {
		++this.programCounter;
	}

}
