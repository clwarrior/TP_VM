package tp.pr3.compilation.conditions;

import tp.pr3.byteCode.conditionalJumps.ConditionalJumps;
import tp.pr3.byteCode.conditionalJumps.IfLeq;
import tp.pr3.compilation.terms.Term;

/**
 * Clase hija de Condition.
 * Parsea la condición "Menor o igual que".
 * @author Claudia Guerrero y Rafael Herrero
 * @version 3.0
 */
public class LessEq extends Condition{
	/**
	 * Constructor vacío
	 */
	public LessEq() {}
	/**
	 * Constructor dados los términos de la condición y el salto condicional
	 * @param term1 Término al que se inicializará this.term1
	 * @param term2 Término al que se inicializará this.term2
	 * @param condition Salto condicional al que se inicializará this.condition
	 */
	public LessEq(Term term1, Term term2, ConditionalJumps condition){
		this.term1 = term1;
		this.term2 = term2;
		this.condition = condition;
	}
	/**
	 * {@inheritDoc}
	 * Concretamente, de la clase LessEq.
	 * @return Objeto de la clase LessEq, si corresponde, o null en caso contrario
	 */
	public Condition parseAux(Term term1, Term term2, String op){
		if(op.equals("<="))
			return new LessEq(term1, term2, new IfLeq());
		else
			return null;
	}
}
