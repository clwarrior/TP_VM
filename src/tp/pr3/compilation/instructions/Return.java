package tp.pr3.compilation.instructions;

import tp.pr3.byteCode.Halt;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.exceptions.ArrayException;

public class Return implements Instruction {

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		Instruction inst = null;
		if(words[0].equalsIgnoreCase("RETURN"))
			inst = new Return();
		return inst;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}

}
