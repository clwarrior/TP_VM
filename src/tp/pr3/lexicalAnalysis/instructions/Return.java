package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.lexicalAnalysis.LexicalParser;

public class Return implements Instruction {

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		Instruction inst = null;
		if(words[0].equalsIgnoreCase("RETURN"))
			inst = new Return();
		return inst;
	}

	@Override
	public void compile(Compiler compiler) {
		// TODO Auto-generated method stub
		
	}

}
