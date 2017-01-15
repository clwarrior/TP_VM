package tp.pr3.compilation.instructions.assignments;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.memoryMove.Store;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.compilation.terms.Term;
import tp.pr3.compilation.terms.TermParser;

public class SimpleAssignment implements Instruction {
	private String var_name;
	private Term rhs;

	public SimpleAssignment(String name, Term rhs){
		this.var_name=name;
		this.rhs=rhs;
	}
	public SimpleAssignment() {}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException{
		char name = words[0].charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=3 || !words[1].equals("="))
			return null;
		else{
			Term term = TermParser.parse(words[2]);
			if(term == null)
				throw new LexicalAnalysisException("Instrucción no válida");
			else{
				return new SimpleAssignment(words[0], term);
			}
		}
	}
	
	public void compile(Compiler compiler) throws CompilationError, ArrayException {
		ByteCode b = this.rhs.compile(compiler);
		compiler.addByteCode(b);
		int index = 0;
		try {
			index = compiler.getIndex(var_name);
		}
		catch(CompilationError e) {
			index = compiler.addVariable(var_name);
		}
		finally {
			compiler.addByteCode(new Store(index));
		}
	}
}
