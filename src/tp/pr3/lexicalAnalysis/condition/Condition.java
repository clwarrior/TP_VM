package tp.pr3.lexicalAnalysis.condition;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.byteCodeGeneration.Compiler;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.lexicalAnalysis.term.TermParser;

public abstract class Condition {
	protected Term term1;
	protected Term term2;
	protected ConditionalJumps condition;
	
	public Condition parse(String t1, String op, String t2, LexicalParser lexParser) throws LexicalAnalysisException{
		if (!op.equals("<") && !op.equals("<=") && !op.equals("=") && !op.equals("!="))
			return null;
		else{
			Term term1 = TermParser.parse(t1);
			Term term2 = TermParser.parse(t2);
			if(term1 == null || term2 == null)
				throw new LexicalAnalysisException("(Instrucción no válida)");
			else{
				return parseAux(term1, term2, op);
			}
		}
	}
			
	public abstract Condition parseAux(Term term1, Term term2, String op);
			
	public void compile(Compiler compiler) throws CompilationError, ArrayException {
		ByteCode b1 = term1.compile(compiler);
		compiler.addByteCode(b1);
		ByteCode b2 = term2.compile(compiler);
		compiler.addByteCode(b2);
		compiler.addByteCode(condition);
	}

	public void setJump(int jump) {
		this.condition.setJump(jump);
	}
}
