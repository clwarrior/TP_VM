package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.instructions.SimpleAssignment;
import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.lexicalAnalysis.term.TermParser;

public class Equal extends Condition{

	public Equal(Term term1, Term term2, ConditionalJumps condition){
		this.term1 = term1;
		this.term2 = term2;
		this.condition = condition;
	}

	@Override
	public Condition parse(String t1, String op, String t2, LexicalParser lexParser) throws LexicalAnalysisException {
		
		if (!op.equals("<") || !op.equals("<=") || !op.equals("==") || !op.equals("!="))
			return null;
		else{
			Term term1 = TermParser.parse(t1);
			Term term2 = TermParser.parse(t2);
			if(term1 == null || term2 == null)
				throw new LexicalAnalysisException("Instrucción no válida");
			else{
				lexParser.increaseProgramCounter();
				return new Equal(term1, term2, condition);
			}
		}
	}

	@Override
	public void compile(Compiler compile) {
		
	}

}
