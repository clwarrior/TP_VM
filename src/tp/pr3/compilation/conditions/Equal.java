package tp.pr3.compilation.conditions;

import tp.pr3.byteCode.conditionalJumps.*;
import tp.pr3.compilation.terms.Term;

/**
 * Clase hija de Condition.
 * Parsea la condici�n "Igual a".
 * @author Claudia Guerrero y Rafael Herrero
 * @version 3.0
 */
public class Equal extends Condition{
	
	/**
	 * Constructor vac�o
	 */
	public Equal() {}

	/**
	 * Constructor dados los t�rminos de la condici�n y el salto condicional
	 * @param term1 T�rmino al que se inicializar� this.term1
	 * @param term2 T�rmino al que se inicializar� this.term2
	 * @param condition Salto condicional al que se inicializar� this.condition
	 */
	public Equal(Term term1, Term term2, ConditionalJumps condition){
		this.term1 = term1;
		this.term2 = term2;
		this.condition = condition;
	}

	/**
	 * {@inheritDoc}
	 * Concretamente, de la clase Equal.
	 * @return Objeto de la clase Equal, si corresponde, o null en caso contrario
	 */
	public Condition parseAux(Term term1, Term term2, String op){
		if(op.equals("="))
			return new Equal(term1, term2, new IfEq());
		else
			return null;
	}
}
