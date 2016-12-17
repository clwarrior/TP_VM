package tp.pr3.byteCode.memoryMove;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
/**
 * Clase hija de la clase MemoryMove.
 * Esta clase copia el elemento de la posicion que indique el atributo num y lo escribe al final de 
 * la memoria
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Load extends MemoryMove {
	/**
	 * Constructor con un parametro que hereda del constructor de la clase padre
	 * (inicializa this.num a num)
	 * @param num, Un int al que inicializar this.num
	 */
	public Load(int num){
		super(num);
	}
	/**
	 * Constructor sin parametros que hereda del constructor de la clase padre
	 */
	public Load() {
		super();
	}
	/**
	 * Comprueba que la posicion dada en this.num sea valida, entonces carga el valor de esa posicion 
	 * de la cpu y lo añade al final de la memoria
	 * @param cpu Una CPU en cuya pila vamos a trabajar
	 * @return boolean, true si ha podido realizarse la modificacion y false eoc
	 */
	public boolean execute(CPU cpu){
		if (this.num>=0){
			int valor=cpu.load(num);
			if (cpu.push(valor))
				return true;
		}
		return false;
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el array dado por parametro sea "load" 
	 * (independiemtemente de mayusculas o minusculas) seguido de un numero mayor que cero,
	 *  si no devuelve null
	 * @return nuevo objeto de clase Load (si procede) o null
	 */
	public ByteCode parseAux(String[] s){
		if (s[0].equalsIgnoreCase("LOAD") && Integer.parseInt(s[1]) >= 0)
			return new Load(Integer.parseInt(s[1]));
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Load para poder la instruccion
	 */
	public String toString(){
		return "LOAD "+num;
	}
}
