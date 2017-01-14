package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.analyze.ParsedProgram;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.condition.Condition;
import tp.pr3.lexicalAnalysis.condition.ConditionParser;

public class IfThen implements Instruction {

	private Condition condition;
	private ParsedProgram ifBody;
	
	public IfThen(Condition cond, ParsedProgram ibody) {
		this.condition = cond;
		this.ifBody = ibody;
	}

	public IfThen() {}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
		ParsedProgram ibody = new ParsedProgram();
		lexParser.lexicalParser(ibody, "ENDIF");
		lexParser.increaseProgramCounter();
		return new IfThen(cond, ibody);
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException{
		// TODO Auto-generated method stub
		
	}

}
