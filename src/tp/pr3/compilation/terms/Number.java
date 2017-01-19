package tp.pr3.compilation.terms;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.Push;
import tp.pr3.compilation.Compiler;
/**
 * Clase que hereda de la interfaz term, y representa un término que es un numero int
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Number implements Term{
	/**
	 * Entero que almacena el valor del término
	 */
	private int number_name;
	
	/**
	 * Constructor que dado un entero, inicializa number_name a ese valor
	 * @param term Un entero que dará valor al término
	 */
	public Number(int term) {
		this.number_name=term;
	}

	/**
	 * Constructor sin parámetros
	 */
	public Number() {}

	/**
	 * {@inheritDoc}
	 * Método de Number, comprueba si term es un int.
	 * @return Term Number si corresponde, o null, si no
	 * @throws NumberFormatException Excepción lanzada si el string dado no almacena un numero
	 */
	public Term parse(String term){
		try{
			int num = Integer.parseInt(term);
			return new Number(num);
		}
		catch (NumberFormatException nfe){
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 * @return ByteCode Push, Intruduce en la cpu el valor del término
	 */
	public ByteCode compile(Compiler compiler) {
		return new Push(number_name);
	}

}
