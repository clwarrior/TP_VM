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
	 * Prueba a interpretar los parámetros dados como todos los tipos de Condition, devolviendo el que encaje, o null.
	 * @param t1 Primer término de la condición
	 * @param op Operador de la condición
	 * @param t2 Segundo término de la condición
	 * @param lexParser Parseador Léxico
	 * @return Condition correspondiente, si la hay, o null en caso contrario
	 * @throws LexicalAnalysisException Instrucción no válida
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
