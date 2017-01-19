package tp.pr3.compilation.terms;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.Load;
import tp.pr3.compilation.Compiler;
import tp.pr3.exceptions.CompilationError;
/**
 * Clase que hereda de la interfaz term, y representa un t�rmino que es una variable
 * representada con una letra
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Variable implements Term{
	/**
	 * String que almacena el nombre del t�rmino
	 */
	private String letter_name;
	/**
	 * Constructor que dado un string, inicializa letter_name a ese valor
	 * @param term Un string que dar� nombre al t�rmino
	 */
	public Variable(String term) {
		this.letter_name=term;
	}

	/**
	 * Constructor sin par�metros
	 */
	public Variable() {}
	
	/**
	 * {@inheritDoc}
	 * M�todo de Variable, comprueba si term es una letra entre la a y la z.
	 * No diferencia ma�usculas de min�sculas.
	 * @return Term Variable si corresponde, o null, si no
	 */
	public Term parse(String term){
		if(term.length()!=1) return null;
		else{
			char name = term.toLowerCase().charAt(0);
			if ('a' <= name && name <= 'z') 
				return new Variable(term);
			else 
				return null;
		}
	}

	/**
	 * {@inheritDoc}
	 * @return ByteCode Load, Carga del compilador el valor de la posicion donde est� almacenada
	 * la variable
	 */
	public ByteCode compile(Compiler compiler) throws CompilationError{
		int index = compiler.getIndex(letter_name);
		return new Load(index);
	}
}
