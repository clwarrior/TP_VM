package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.DivisionByZero;
import tp.pr3.exceptions.StackException;

/**
 * Clase hija de ByteCode
 * Clase abstracta que agrupa las operaciones aritméticas que pude realizar el programa.
 * Tiene dos int que actuan como operandos.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
abstract public class Arithmetics implements ByteCode{
	
	/**
	 * Metodo que dada una cpu, extrae los los operandos de la pila de la cpu siempre que 
	 * ésta no esté vacía
	 * @param cpu, de la cual extraemos los valores de los operandos
	 * @return boolean, true si se han podido extraer, false eoc
	 * @throws StackException 
	 * @throws DivisionByZero 
	 */
	public void execute(CPU cpu) throws StackException, DivisionByZero{
		int op1 = 0, op2 = 0;
		op1=cpu.pop();
		op2=cpu.pop();
		executeAux(cpu, op1, op2);
	}
	public abstract void executeAux(CPU cpu, int op1, int op2) throws StackException, DivisionByZero;
	/**
	 * Metodo que comprueba que la longitud de la instrucción es la adecuada
	 * @param s, Un array es el nombre de la instrucción
	 * @return String, es el nombre de la operación a realizar, o null si la longitud del array de entrada no es uno
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
