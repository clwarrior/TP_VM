package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.lexicalAnalysis.LexicalParser;

public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexparser);
	void compile(Compiler compiler); //throws...;
}
