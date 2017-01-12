package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.lexicalAnalysis.term.TermParser;

public abstract class Condition {
	protected Term term1;
	protected Term term2;
	protected ConditionalJumps condition;
	
	public Condition parse(String t1, String op, String t2, LexicalParser lexParser) throws LexicalAnalysisException{
		if (!op.equals("<") || !op.equals("<=") || !op.equals("==") || !op.equals("!="))
			return null;
		else{
			Term term1 = TermParser.parse(t1);
			Term term2 = TermParser.parse(t2);
			if(term1 == null || term2 == null)
				throw new LexicalAnalysisException("Instrucción no válida");
			else{
				lexParser.increaseProgramCounter();
				return parseAux(term1, term2, op);
			}
		}
	}
			
	public abstract Condition parseAux(Term term1, Term term2, String op);
			
	public abstract void compile(Compiler compile);
}
