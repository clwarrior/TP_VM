package tp.pr3.mv;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.lexicalAnalysis.term.Term;
import tp.pr3.lexicalAnalysis.term.Variable;

public class Number implements Term{
	private int number_name;
	
	public Number(int term) {
		this.number_name=term;
	}

	public Term parse(String term){
		if(term.length()!=1) return null;
		else{
			try{
				Integer.parseInt(term);
				return new Variable(term);
			}
			catch (NumberFormatException nfe){//ESTO ESTA BIEN, ESTE TIPO DE EXCEPCION?
				return null;
			}
		}
	}


	public ByteCode compile(Compiler compiler) {
		// TODO Auto-generated method stub
		return null;
	}

}
