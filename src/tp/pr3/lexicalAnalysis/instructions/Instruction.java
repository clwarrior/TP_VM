package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.byteCodeGeneration.Compiler;

public interface Instruction{
	
	Instruction lexParse(String[] words, LexicalParser lexparser) throws LexicalAnalysisException, ArrayException;
	
	void compile(Compiler compiler) throws ArrayException, CompilationError;
	
}
