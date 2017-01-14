package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.analyze.ParsedProgram;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.condition.*;

public class While implements Instruction {
	private Condition condition;
	private ParsedProgram whileBody;
	
	public While(Condition cond, ParsedProgram whileBody) {
		this.condition = cond;
		this.whileBody = whileBody;
	}
	
	public While() {}

	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException{
		Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
		ParsedProgram wbody = new ParsedProgram();
		lexParser.lexicalParser(wbody, "ENDWHILE");
		lexParser.increaseProgramCounter();
		return new While(cond, wbody);
	}
	
	public void compile(Compiler compiler) throws ArrayException{
		// TODO Auto-generated method stub
		
	}

}
