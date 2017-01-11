package tp.pr3.lexicalAnalysis.term;

import tp.pr3.byteCode.ByteCode;

public interface Term {
	Term parse(String term);
	ByteCode compile(Compiler compiler);
}
