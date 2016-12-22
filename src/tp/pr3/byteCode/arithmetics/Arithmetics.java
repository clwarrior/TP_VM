package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;

/**
 * Clase hija de ByteCode
 * Clase abstracta que agrupa las operaciones aritm�ticas que pude realizar el programa.
 * Tiene dos int que actuan como operandos.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
abstract public class Arithmetics implements ByteCode{
	
	/**
	 * Metodo que dada una cpu, extrae los los operandos de la pila de la cpu siempre que 
	 * �sta no est� vac�a
	 * @param cpu, de la cual extraemos los valores de los operandos
	 * @return boolean, true si se han podido extraer, false eoc
	 */
	public boolean execute(CPU cpu){
		int op1 = 0, op2 = 0;
		if(!cpu.empty()){
			op1=cpu.pop();
		}
		if(!cpu.empty()){
			op2=cpu.pop();
			executeAux(cpu, op1, op2);
		}
		else
			return false;
		return true;
	}
	public abstract boolean executeAux(CPU cpu, int op1, int op2);
	/**
	 * Metodo que comprueba que la longitud de la instrucci�n es la adecuada
	 * @param s, Un array es el nombre de la instrucci�n
	 * @return String, es el nombre de la operaci�n a realizar, o null si la longitud del array de entrada no es uno
	 */
	public ByteCode parse(String[] s){
		if(s.length == 1)
			return this.parseAux(s[0]);
		else
			return null;
	}
	/**
	 * Metodo abstracto que crea un nuevo objeto de la clase siempre que el el string dado por parametro 
	 * sea el nombre de la instruccion (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @param s Un array que vamos a interpretar
	 * @return ByteCode
	 */
	public abstract ByteCode parseAux(String s);
}
