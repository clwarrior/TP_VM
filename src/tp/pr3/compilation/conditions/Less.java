package tp.pr3.compilation.conditions;

import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.byteCode.conditionalJumps.IfLe;
import tp.pr3.compilation.terms.Term;

public class Less extends Condition{

	public Less() {}
	
	public Less(Term term1, Term term2, ConditionalJumps condition){
		this.term1 = term1;
		this.term2 = term2;
		this.condition = condition;
	}

	@Override
	public Condition parseAux(Term term1, Term term2, String op){
		if(op.equals("<"))
			return new Less(term1, term2, new IfLe());
		else
			return null;
	}
}
