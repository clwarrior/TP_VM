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
	 * Posición a la que debe saltar el contador del programa si no se cumple la condición
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
	 * Constructor sin parámetros
	 */
	public ConditionalJumps(){}
	
	/**
	 * Método que extrae los operandos de la pila para evaluar la condición.
	 * @param cpu CPU
	 * @throws StackException Pila vacía, Pila llena
	 * @throws ExecutionError Intento de salto a posición no válida
	 */
	public void execute(CPU cpu) throws StackException, ExecutionError{
		int op1 = 0, op2 = 0;
		op1=cpu.pop();
		op2=cpu.pop();
		executeAux(cpu, op1, op2);
	}
	
	/**
	 * Método que evalúa la condición correspondiente, sustituyendo el contador del programa por this.jump
	 * si no se cumple.
	 * @param cpu CPU
	 * @param op1 Operando 1
	 * @param op2 Operando 2
	 * @throws ExecutionError Intento de salto a posición no válida
	 */
	public abstract void executeAux(CPU cpu, int op1, int op2) throws ExecutionError;
	
	/**
	 * Metodo que comprueba que la longitud de la instrucción es la adecuada (2).
	 * @param s Array de Strings que contiene la instrucción
	 * @return ByteCode de la instrucción a realizar, o null si no coincide con ninguna
	 */
	public ByteCode parse(String[] s){
		if(s.length==2)
			return this.parseAux(s);
		else
			return null;
	}
	
	/**
	 * Método abstracto que devuelve un ByteCode de la condición correspondiente al String dado, 
	 * o null si no corresponde a ninguna.
	 * @param s El Array de String que vamos a interpretar
	 * @return El ByteCode correspondiente, o null si no coincide con ninguno 
	 * de la cpu
	 */
	public abstract ByteCode parseAux(String[] s);
	
	/**
	 * Método que modifica el valor de this.jump.
	 * @param jump El nuevo valor que vamos a asignar a this.jump
	 */
	public void setJump(int jump) {
		this.jump = jump;
	}
}
