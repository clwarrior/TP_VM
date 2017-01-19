package tp.pr3.compilation.terms;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.Push;
import tp.pr3.compilation.Compiler;
/**
 * Clase que hereda de la interfaz term, y representa un t�rmino que es un numero int
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Number implements Term{
	/**
	 * Entero que almacena el valor del t�rmino
	 */
	private int number_name;
	
	/**
	 * Constructor que dado un entero, inicializa number_name a ese valor
	 * @param term Un entero que dar� valor al t�rmino
	 */
	public Number(int term) {
		this.number_name=term;
	}

	/**
	 * Constructor sin par�metros
	 */
	public Number() {}

	/**
	 * {@inheritDoc}
	 * M�todo de Number, comprueba si term es un int.
	 * @return Term Number si corresponde, o null, si no
	 * @throws NumberFormatException Excepci�n lanzada si el string dado no almacena un numero
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
	 * @return ByteCode Push, Intruduce en la cpu el valor del t�rmino
	 */
	public ByteCode compile(Compiler compiler) {
		return new Push(number_name);
	}

}
