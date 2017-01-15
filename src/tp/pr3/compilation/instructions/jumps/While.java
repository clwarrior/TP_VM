package tp.pr3.compilation.instructions.jumps;

import tp.pr3.byteCode.GoTo;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.conditions.Condition;
import tp.pr3.compilation.conditions.ConditionParser;
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.programs.ParsedProgram;

public class While implements Instruction {
	private Condition condition;
	private ParsedProgram whileBody;
	
	public While(Condition cond, ParsedProgram whileBody) {
		this.condition = cond;
		this.whileBody = whileBody;
	}
	
	public While() {}

	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException{
		if(words[0].equalsIgnoreCase("WHILE")) {
			Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			ParsedProgram wbody = new ParsedProgram();
			lexParser.increaseProgramCounter();
			lexParser.lexicalParser(wbody, "ENDWHILE");
			return new While(cond, wbody);
		}
		else
			return null;
	}
	
	public void compile(Compiler compiler) throws ArrayException, CompilationError{
		int inicio = compiler.getProgramCounter();
		this.condition.compile(compiler);
		compiler.compile(this.whileBody);
		compiler.addByteCode(new GoTo(inicio));
		this.condition.setJump(compiler.getProgramCounter());
	}

}
