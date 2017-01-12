package tp.pr3.lexicalAnalysis.term;

import tp.pr3.byteCode.ByteCode;

public class Variable implements Term{
	private String letter_name;
	
	public Variable(String term) {
		this.letter_name=term;
	}

	public Variable() {}

	public Term parse(String term){
		if(term.length()!=1) return null;
		else{
			char name = term.charAt(0);
			if ('a' <= name && name <= 'z') 
				return new Variable(term);
			else 
				return null;
		}
	}


	public ByteCode compile(Compiler compiler) {
		// TODO Auto-generated method stub
		return null;
	}
}
