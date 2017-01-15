package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de ByteCode.
 * Clase abstracta que agrupa las operaciones aritm�ticas que pude realizar el programa.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
abstract public class Arithmetics implements ByteCode{
	
	/**
	 * M�todo que extrae los dos operandos de la CPU para realizar la operaci�n.
	 * @param cpu CPU
	 * @throws StackException Pila vac�a, Pila llena
	 * @throws DivisionByZero Divisi�n entre 0
	 */
	public void execute(CPU cpu) throws StackException, DivisionByZero{
		int op1 = 0, op2 = 0;
		op1=cpu.pop();
		op2=cpu.pop();
		executeAux(cpu, op1, op2);
	}
	
	 /**
	  * M�todo abstracto que ejecuta la operaci�n concreta con los dos operandos dados y guarda el resultado en la pila.
	  * @param cpu CPU
	  * @param op1 Operando 1 para la operaci�n
	  * @param op2 Operando 2 para la operaci�n
	  * @throws StackException Pila llena
	  * @throws DivisionByZero Divisi�n entre 0
	  */
	public abstract void executeAux(CPU cpu, int op1, int op2) throws StackException, DivisionByZero;
	
	/**
	 * M�todo que comprueba que la longitud de la instrucci�n es la adecuada (1).
	 * @param s Arraytrings que contiene la instrucci�n a parsear
	 * @return ByteCode de la operaci�n a realizar, o null si no coincide con ninguna
	 */
	public ByteCode parse(String[] s){
		if(s.length == 1)
			return this.parseAux(s[0]);
		else
			return null;
	}
	
	/**
	 * M�todo abstracto que devuelve un ByteCode de la operaci�n correspondiente al String dado, 
	 * o null si no corresponde a ninguna.
	 * @param s El String que vamos a interpretar
	 * @return El ByteCode correspondiente, o null si no coincide con ninguno
	 */
	public abstract ByteCode parseAux(String s);
}
