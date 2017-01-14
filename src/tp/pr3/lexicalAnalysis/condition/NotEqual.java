package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.byteCode.conditionalJumps.IfNeq;

public class NotEqual extends Condition{
	
	public NotEqual() {}

	public NotEqual(Term term1, Term term2, ConditionalJumps condition){
		this.term1 = term1;
		this.term2 = term2;
		this.condition = condition;
	}

	@Override
	public Condition parseAux(Term term1, Term term2, String op){
		if(op.equals("!="))
			return new Equal(term1, term2, new IfNeq());
		else
			return null;
	}
}
