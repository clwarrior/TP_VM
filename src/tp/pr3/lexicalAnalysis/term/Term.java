package tp.pr3.lexicalAnalysis.term;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCodeGeneration.Compiler;
import tp.pr3.exceptions.CompilationError;

public interface Term {
	
	Term parse(String term);
	
	ByteCode compile(Compiler compiler) throws CompilationError;
	
}
