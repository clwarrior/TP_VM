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
		int cont=0;
		while(!stop && cont<=sProgram.length()){
			Instruction inst = ParserInstruction.parse(sProgram.at(cont), this);
			pProgram.write(inst);
			if(sProgram.at(cont)==stopKey){
				stop=true;
			}
			++cont;
		}
		
	}

	public void increaseProgramCounter() {
		++this.programCounter;
	}

}
