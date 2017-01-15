package tp.pr3.compilation.terms;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.compilation.Compiler;
import tp.pr3.exceptions.CompilationError;

public interface Term {
	
	Term parse(String term);
	
	ByteCode compile(Compiler compiler) throws CompilationError;
	
}
