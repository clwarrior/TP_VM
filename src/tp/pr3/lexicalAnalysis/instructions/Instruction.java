package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;

public interface Instruction{
	
	Instruction lexParse(String[] words, LexicalParser lexparser) throws LexicalAnalysisException;
	
	void compile(Compiler compiler) throws ArrayException;
	
}
