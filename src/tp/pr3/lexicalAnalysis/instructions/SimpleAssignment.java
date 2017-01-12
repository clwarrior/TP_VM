package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.lexicalAnalysis.term.TermParser;

public class SimpleAssignment implements Instruction {
	private String var_name;
	private Term rhs;

	public SimpleAssignment(String name, Term rhs){
		this.var_name=name;
		this.rhs=rhs;
	}
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException{
		char name = words[0].charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=3 || !words[1].equals("="))
			return null;
		else{
			Term term = TermParser.parse(words[2]);
			if(term == null)
				throw new LexicalAnalysisException("Instrucción no válida");
			else{
				lexParser.increaseProgramCounter();
				return new SimpleAssignment(words[0], term);
			}
		}
	}
	
	public void compile(Compiler compiler) {
		
	}
}
