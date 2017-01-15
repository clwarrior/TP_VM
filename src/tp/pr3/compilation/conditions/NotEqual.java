package tp.pr3.compilation.conditions;

import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.byteCode.conditionalJumps.IfNeq;
import tp.pr3.compilation.terms.Term;

/**
 * Clase hija de Condition.
 * Parsea la condici�n "Distinto a".
 * @author Claudia Guerrero y Rafael Herrero
 * @version 3.0
 */
public class NotEqual extends Condition{
	/**
	 * Constructor vac�o
	 */
	public NotEqual() {}
	/**
	 * Constructor dados los t�rminos de la condici�n y el salto condicional
	 * @param term1 T�rmino al que se inicializar� this.term1
	 * @param term2 T�rmino al que se inicializar� this.term2
	 * @param condition Salto condicional al que se inicializar� this.condition
	 */
	public NotEqual(Term term1, Term term2, ConditionalJumps condition){
		this.term1 = term1;
		this.term2 = term2;
		this.condition = condition;
	}
	/**
	 * {@inheritDoc}
	 * Concretamente, de la clase NotEqual.
	 * @return Objeto de la clase NotEqual, si corresponde, o null en caso contrario
	 */
	public Condition parseAux(Term term1, Term term2, String op){
		if(op.equals("!="))
			return new Equal(term1, term2, new IfNeq());
		else
			return null;
	}
}
