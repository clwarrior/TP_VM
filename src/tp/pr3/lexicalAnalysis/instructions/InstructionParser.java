package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.instructions.Instruction;

public class InstructionParser {

	private static final Instruction[] instructions = {new SimpleAssignment(), new CompoundAssignment(), 
												new While(), new IfThen(), new Return(), new Write()};
	
	public static Instruction parse(String inst, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException{
		Instruction instruction = null;
		String subcads[] = inst.trim().split(" ");//--------------------------------------------------------------------quita tabulador
		int i=0;
		while(instruction == null && i<instructions.length){
			instruction = instructions[i].lexParse(subcads, lexParser);
			++i;
		}
		return instruction;
	}
}
