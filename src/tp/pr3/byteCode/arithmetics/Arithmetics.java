package tp.pr3.byteCode.arithmetics;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de ByteCode.
 * Clase abstracta que agrupa las operaciones aritméticas que pude realizar el programa.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
abstract public class Arithmetics implements ByteCode{
	
	/**
	 * Método que extrae los dos operandos de la CPU para realizar la operación.
	 * @param cpu CPU
	 * @throws StackException Pila vacía, Pila llena
	 * @throws DivisionByZero División entre 0
	 */
	public void execute(CPU cpu) throws StackException, DivisionByZero{
		int op1 = 0, op2 = 0;
		op1=cpu.pop();
		op2=cpu.pop();
		executeAux(cpu, op1, op2);
	}
	
	 /**
	  * Método abstracto que ejecuta la operación concreta con los dos operandos dados y guarda el resultado en la pila.
	  * @param cpu CPU
	  * @param op1 Operando 1 para la operación
	  * @param op2 Operando 2 para la operación
	  * @throws StackException Pila llena
	  * @throws DivisionByZero División entre 0
	  */
	public abstract void executeAux(CPU cpu, int op1, int op2) throws StackException, DivisionByZero;
	
	/**
	 * Método que comprueba que la longitud de la instrucción es la adecuada (1).
	 * @param s Arraytrings que contiene la instrucción a parsear
	 * @return ByteCode de la operación a realizar, o null si no coincide con ninguna
	 */
	public ByteCode parse(String[] s){
		if(s.length == 1)
			return this.parseAux(s[0]);
		else
			return null;
	}
	
	/**
	 * Método abstracto que devuelve un ByteCode de la operación correspondiente al String dado, 
	 * o null si no corresponde a ninguna.
	 * @param s El String que vamos a interpretar
	 * @return El ByteCode correspondiente, o null si no coincide con ninguno
	 */
	public abstract ByteCode parseAux(String s);
}
