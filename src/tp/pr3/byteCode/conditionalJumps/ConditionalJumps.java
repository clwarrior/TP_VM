package tp.pr3.byteCode.conditionalJumps;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
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
	 * Operando 1 de la condicion
	 */
	protected int op1;
	/**
	 * Operando 2 de la condicion
	 */
	protected int op2;
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
	 * �sta no est� vac�a
	 * @param cpu, de la cual extraemos los valores de los operandos
	 * @return boolean, true si se han podido extraer, false eoc
	 */
	public boolean execute(CPU cpu){
		if(!cpu.empty()){
			op1=cpu.pop();
		}
		if(!cpu.empty()){
			op2=cpu.pop();
			executeAux(cpu);
		}
		else
			return false;
		return true;
	}
	public abstract boolean executeAux(CPU cpu);
	
	/**
	 * Metodo que comprueba que la longitud de la instrucci�n es la adecuada (dos)
	 * @param s Un array, es el nombre de la instrucci�n
	 * @return String, es el nombre de la operaci�n a realizar, o null si la longitud del array de entrada no es dos
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
}
