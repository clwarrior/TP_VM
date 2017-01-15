package tp.pr3.compilation.terms;

/**
 * Clase que se encarga de interpretar los t�rminos
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class TermParser{
	
	/**
	 * Array de Term que contiene un t�rmino de cada tipo
	 */
	private static final Term[] terms = {new Number(), new Variable()};
	
	/**
	 * Prueba a interpretar el t�rmino dado como todos los tipos de Term, devolviendo el que encaje, o null.
	 * @param str String que contiene el t�rmino que se desea interpretar
	 * @return Term correspondiente, si la hay, o null en caso contrario
	 */
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
