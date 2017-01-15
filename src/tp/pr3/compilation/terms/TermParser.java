package tp.pr3.compilation.terms;

public class TermParser{
	private static final Term[] terms = {new Number(), new Variable()};
	
	public static Term parse(String str){
		Term term = null;
		int i=0;
		while(term==null && i<terms.length){
			term = terms[i].parse(str);
			++i;
		}
		return term;
	}
}
