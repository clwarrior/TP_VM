package tp.pr3.byteCode.conditionalJumps;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.ExecutionError;
import tp.pr3.exceptions.StackException;
/**
 * Clase hija de ByteCode.
 * Clase abstracta que agrupa las operaciones de saltos condicionales que puede realizar el programa.
 * Tiene dos int que actuan como operandos y un int jump que indica la posicion del
 * programa a la que queremos saltar.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
abstract public class ConditionalJumps implements ByteCode{
	/**
	 * Posicion a la que debe saltar el contador del programa si no se cumple la condicion
	 */
	protected int jump;
	
	/**
	 * Constructor que inicializa this.jump al valor del int jump dado por parametro
	 * @param jump, Un int al cual queremos inicializar this.jump
	 */
	public ConditionalJumps(int jump){
		this.jump=jump;
	}
	/**
	 * Constructor sin parametros
	 */
	public ConditionalJumps(){}
	
	/**
	 * Metodo que dada una cpu, extrae los los operandos de la pila de la cpu siempre que 
	 * ésta no esté vacía
	 * @param cpu, de la cual extraemos los valores de los operandos
	 * @return boolean, true si se han podido extraer, false eoc
	 * @throws StackException 
	 * @throws ExecutionError 
	 * @throws ArrayException 
	 */
	public void execute(CPU cpu) throws StackException, ExecutionError{
		int op1 = 0, op2 = 0;
		op1=cpu.pop();
		op2=cpu.pop();
		executeAux(cpu, op1, op2);
	}
	public abstract void executeAux(CPU cpu, int op1, int op2) throws ExecutionError;
	
	/**
	 * Metodo que comprueba que la longitud de la instrucción es la adecuada (dos)
	 * @param s Un array, es el nombre de la instrucción
	 * @return String, es el nombre de la operación a realizar, o null si la longitud del array de entrada no es dos
	 */
	public ByteCode parse(String[] s){
		if(s.length==2)
			return this.parseAux(s);
		else
			return null;
	}
	
	/**
	 * Metodo abstracto que crea un nuevo objeto de la clase siempre que el el array dado por parametro 
	 * sea el nombre de la instruccion (independiemtemente de mayusculas o minusculas), si no devuelve null
	 * @param s Un array que vamos a interpretar
	 * @return ByteCode
	 */
	public abstract ByteCode parseAux(String[] s);
	
	public void setJump(int jump) {
		this.jump = jump;
	}
}
