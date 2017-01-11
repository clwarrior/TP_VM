package tp.pr3.lexicalAnalysis.instructions;

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
	public Instruction lexParse(String[] words, LexicalParser lexparser) {//para que le pasamos lexparser?
		char name = words[0].charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=3 || words[1]!= "=")
			return null;
		else{
			return new SimpleAssignment(words[0], TermParser.parse(words[2]));
		}
	}
	
	public void compile(Compiler compiler) {
		// TODO Auto-generated method stub
		
	}
}
