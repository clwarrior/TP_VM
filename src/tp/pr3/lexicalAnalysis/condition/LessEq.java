package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.byteCode.conditionalJumps.IfLeq;
import tp.pr3.byteCodeGeneration.Compiler;

public class LessEq extends Condition{
	
	public LessEq() {}

	public LessEq(Term term1, Term term2){
		this.term1 = term1;
		this.term2 = term2;
		this.condition = null;
	}

	@Override
	public Condition parseAux(Term term1, Term term2, String op){
		if(op.equals("<="))
			return new LessEq(term1, term2);
		else
			return null;
	}
	
	@Override
	public void compileAux(Compiler compile) {
		compile.addByteCode(new IfLeq());
	}


}
