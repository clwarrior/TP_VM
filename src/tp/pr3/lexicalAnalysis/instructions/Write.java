package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.byteCode.Out;
import tp.pr3.byteCode.memoryMove.Load;
import tp.pr3.byteCodeGeneration.Compiler;
import tp.pr3.exceptions.ArrayException;

public class Write implements Instruction {
	
	private String varName;
	
	public Write() {}

	public Write(String string) {
		this.varName = string;
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		Instruction inst = null;
		if(words[0].equalsIgnoreCase("WRITE"))
			inst = new Write(words[1]);
		return inst;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException{
		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(new Load(index));
		compiler.addByteCode(new Out());
	}
}
