package tp.pr3.compilation.instructions;

import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.instructions.assignments.CompoundAssignment;
import tp.pr3.compilation.instructions.assignments.SimpleAssignment;
import tp.pr3.compilation.instructions.jumps.IfThen;
import tp.pr3.compilation.instructions.jumps.While;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;

public class InstructionParser {

	private static final Instruction[] instructions = {new SimpleAssignment(), new CompoundAssignment(), 
												new While(), new IfThen(), new Return(), new Write()};
	
	public static Instruction parse(String inst, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException{
		Instruction instruction = null;
		String subcads[] = inst.trim().split(" ");
		int i=0;
		while(instruction == null && i<instructions.length){
			instruction = instructions[i].lexParse(subcads, lexParser);
			++i;
		}
		return instruction;
	}
}
