package tp.pr3.byteCode.memoryMove;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.cpu.CPU;
/**
 * Clase hija de la clase MemoryMove.
 * Esta clase mueve el ultimo elemento de la memoria a la posicion que indique el atributo num
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Store extends MemoryMove{
	/**
	 * Constructor con un parametro que hereda del constructor de la clase padre
	 * (inicializa this.num a num)
	 * @param num, Un int al que inicializar this.num
	 */
	public Store(int num){
		super(num);
	}
	/**
	 * Constructor sin parametros que hereda del constructor de la clase padre
	 */
	public Store() {
		super();
	}
	/**
	 * Comprueba que la pila contenga algun elemento, entonces carga el ultimo valor de la pila, 
	 * lo quita de la pila e invoca a store de la cpu, que lo guarda en la posicion num de la memoria
	 * @param cpu Una CPU en cuya pila vamos a trabajar
	 * @return boolean, true si ha podido realizarse la modificacion y false eoc
	 */
	public boolean execute(CPU cpu){
		if (!cpu.empty()){
			int elem=cpu.pop();
			if (this.num>=0)
				cpu.store(num, elem);
			return true;
		}
		return false;
	}
	/**
	 * Crea un nuevo objeto de la clase siempre que el array dado por parametro sea "store" 
	 * (independiemtemente de mayusculas o minusculas) seguido de un numero mayor o igual que 
	 * cero, si no devuelve null
	 * @return nuevo objeto de clase Store (si procede) o null
	 */
	public ByteCode parseAux(String[] s){
		if (s[0].equalsIgnoreCase("STORE") && Integer.parseInt(s[1]) >= 0)
			return new Store(Integer.parseInt(s[1]));
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase Store para poder la instruccion
	 */
	public String toString(){
		return "STORE "+num;
	}
}
