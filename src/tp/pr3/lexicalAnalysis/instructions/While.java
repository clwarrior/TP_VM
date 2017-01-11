package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.analyze.ParsedProgram;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.condition.Condition;
import tp.pr3.lexicalAnalysis.condition.ConditionParser;

public class While implements Instruction {
	private Condition condition;
	private ParsedProgram whileBody;
	
	public Instruction lexParse(String[] words, LexicalParser lexical) {
		Condition cond = ConditionParser.parse(words[0], words[1], words[2], lexical);
		ParsedProgram wbody = new ParsedProgram();
		lexical.lexicalParser(wbody, "ENDWHILE");
		lexical.increaseProgramCounter();
		return null;
	}
	
	public void compile(Compiler compiler) {
		// TODO Auto-generated method stub
		
	}

}
