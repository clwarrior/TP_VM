package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.lexicalAnalysis.term.TermParser;

public class CompoundAssignment implements Instruction {
	private String var_name;
	private String operator;
	private Term term1;
	private Term term2;
	
	public CompoundAssignment(String name, String operator, Term term1, Term term2){
		this.var_name=name;
		this.operator=operator;
		this.term1=term1;
		this.term2=term2;
	}
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		char name = words[0].charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=5 || words[1]!= "=" ||
				words[3]!="+"|| words[3]!="-"|| words[3]!="*"|| words[3]!="%"|| words[3]!="/"|| words[3]!="//")
			return null;
		else{
			return new CompoundAssignment(words[0], words[3], TermParser.parse(words[2]), TermParser.parse(words[4]));
		}
	}
	
	public void compile(Compiler compiler) {
		// TODO Auto-generated method stub
		
	}
}
