package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.exceptions.LexicalAnalysisException;
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
	public CompoundAssignment() {}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		char name = words[0].charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=5 || !words[1].equals("=") ||
				!words[3].equals("+") || !words[3].equals("-") || !words[3].equals("*") ||
				!words[3].equals("/") || !words[3].equals("//") || !words[3].equals("%"))
			return null;
		else{
			Term term1 = TermParser.parse(words[2]);
			Term term2 = TermParser.parse(words[4]);
			if(term1 == null || term2 == null)
				throw new LexicalAnalysisException("Instrucción no válida");
			else{
				lexParser.increaseProgramCounter();
				return new CompoundAssignment(words[0], words[3], term1, term2);
			}
		}
	}
	
	public void compile(Compiler compiler) {
		
	}
}
