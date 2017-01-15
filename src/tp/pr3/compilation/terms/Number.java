package tp.pr3.compilation.terms;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.Push;
import tp.pr3.compilation.Compiler;

public class Number implements Term{
	private int number_name;
	
	public Number(int term) {
		this.number_name=term;
	}

	public Number() {}

	public Term parse(String term) throws NumberFormatException{
		try{
			int num = Integer.parseInt(term);
			return new Number(num);
		}
		catch (NumberFormatException nfe){
			return null;
		}
	}


	public ByteCode compile(Compiler compiler) {
		return new Push(number_name);
	}

}
