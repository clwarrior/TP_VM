package tp.pr3.compilation.instructions.jumps;

import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.programs.ParsedProgram;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.conditions.Condition;
import tp.pr3.compilation.conditions.ConditionParser;
import tp.pr3.compilation.instructions.Instruction;

public class IfThen implements Instruction {

	private Condition condition;
	private ParsedProgram ifBody;
	
	public IfThen(Condition cond, ParsedProgram ibody) {
		this.condition = cond;
		this.ifBody = ibody;
	}

	public IfThen() {}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException{
		if(words[0].equalsIgnoreCase("IF")) {
			Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			lexParser.increaseProgramCounter();
			ParsedProgram ibody = new ParsedProgram();
			lexParser.lexicalParser(ibody, "ENDIF");
			return new IfThen(cond, ibody);
		}
		else
			return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException, CompilationError{
		this.condition.compile(compiler);
		compiler.compile(this.ifBody);
		this.condition.setJump(compiler.getProgramCounter());
	}
}
