package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.lexicalAnalysis.LexicalParser;

public class Write implements Instruction {

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexparser) {
		Instruction inst = null;
		if(words[0].equalsIgnoreCase("WRITE"))
			inst = new Write();
		return inst;
	}

	@Override
	public void compile(Compiler compiler) {
		// TODO Auto-generated method stub
		
	}

}
