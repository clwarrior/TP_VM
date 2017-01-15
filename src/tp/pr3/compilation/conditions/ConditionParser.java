package tp.pr3.compilation.conditions;

import tp.pr3.compilation.LexicalParser;
import tp.pr3.exceptions.LexicalAnalysisException;

/**
 * Clase que se encarga de interpretar las condiciones.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class ConditionParser{
	
	/**
	 * Array que contiene todos lo tipos de condiciones.
	 */
	private static final Condition[] conditions = { new Equal(), new Less(), new LessEq(), new NotEqual()};

	/**
	 * Prueba a interpretar los par�metros dados como todos los tipos de Condition, devolviendo el que encaje, o null.
	 * @param t1 Primer t�rmino de la condici�n
	 * @param op Operador de la condici�n
	 * @param t2 Segundo t�rmino de la condici�n
	 * @param lexParser Parseador L�xico
	 * @return Condition correspondiente, si la hay, o null en caso contrario
	 * @throws LexicalAnalysisException Instrucci�n no v�lida
	 */
	public static Condition parse(String t1, String op, String t2, LexicalParser lexParser) throws LexicalAnalysisException{
			Condition condition = null;
			int i=0;
				while(condition == null && i<conditions.length){
				condition = conditions[i].parse(t1, op, t2, lexParser);
				++i;
			}
			return condition;
	}
}
