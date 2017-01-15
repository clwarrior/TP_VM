package tp.pr3.byteCode.conditionalJumps;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;

/**
 * Clase hija de ByteCode.
 * Clase abstracta que agrupa las operaciones de saltos condicionales que puede realizar el programa.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
abstract public class ConditionalJumps implements ByteCode{
	
	/**
	 * Posici�n a la que debe saltar el contador del programa si no se cumple la condici�n
	 */
	protected int jump;
	
	/**
	 * Constructor dado el salto
	 * @param jump Int con el que queremos inicializar this.jump
	 */
	public ConditionalJumps(int jump){
		this.jump=jump;
	}
	
	/**
	 * Constructor sin par�metros
	 */
	public ConditionalJumps(){}
	
	/**
	 * M�todo que extrae los operandos de la pila para evaluar la condici�n.
	 * @param cpu CPU
	 * @throws StackException Pila vac�a, Pila llena
	 * @throws ExecutionError Intento de salto a posici�n no v�lida
	 */
	public void execute(CPU cpu) throws StackException, ExecutionError{
		int op1 = 0, op2 = 0;
		op1=cpu.pop();
		op2=cpu.pop();
		executeAux(cpu, op1, op2);
	}
	
	/**
	 * M�todo que eval�a la condici�n correspondiente, sustituyendo el contador del programa por this.jump
	 * si no se cumple.
	 * @param cpu CPU
	 * @param op1 Operando 1
	 * @param op2 Operando 2
	 * @throws ExecutionError Intento de salto a posici�n no v�lida
	 */
	public abstract void executeAux(CPU cpu, int op1, int op2) throws ExecutionError;
	
	/**
	 * Metodo que comprueba que la longitud de la instrucci�n es la adecuada (2).
	 * @param s Array de Strings que contiene la instrucci�n
	 * @return ByteCode de la instrucci�n a realizar, o null si no coincide con ninguna
	 */
	public ByteCode parse(String[] s){
		if(s.length==2)
			return this.parseAux(s);
		else
			return null;
	}
	
	/**
	 * M�todo abstracto que devuelve un ByteCode de la condici�n correspondiente al String dado, 
	 * o null si no corresponde a ninguna.
	 * @param s El Array de String que vamos a interpretar
	 * @return El ByteCode correspondiente, o null si no coincide con ninguno 
	 * de la cpu
	 */
	public abstract ByteCode parseAux(String[] s);
	
	/**
	 * M�todo que modifica el valor de this.jump.
	 * @param jump El nuevo valor que vamos a asignar a this.jump
	 */
	public void setJump(int jump) {
		this.jump = jump;
	}
}
