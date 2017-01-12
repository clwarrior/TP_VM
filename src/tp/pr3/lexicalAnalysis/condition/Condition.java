package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.term.Term;

public abstract class Condition {
	protected Term term1;
	protected Term term2;
	protected ConditionalJumps condition;
	
	public abstract Condition parse(String t1, String op, String t2, LexicalParser parser) throws LexicalAnalysisException;
	public abstract void compile(Compiler compile);
}
