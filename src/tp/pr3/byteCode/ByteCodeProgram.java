package tp.pr3.byteCode;

/**
 * Clase que contiene los metodos y atributos del programa de ByteCodes. Se trata de un array normal de tamaño maximo 100
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class ByteCodeProgram {

	/**
	 * Array de ByteCode que contiene el programa
	 */
	private ByteCode[] program;
	/**
	 * Int que indica el numero de elementos almacenados en el programa
	 */
	private int last;
	/**
	 * Int constante que indica el tamaño maximo del programa
	 */
	final private static int MAX = 100;
	
	/**
	 * Constructor de la clase ByteCodeProgram
	 * Inicializa this.program a un array de ByteCode de tamaño maximo (100)
	 * Inicializa this.last a 0
	 */
	public ByteCodeProgram(){
		this.program = new ByteCode[MAX];
		this.last = 0;
	}
	/**
	 * Devuelve el numero de elementos del programa
	 * @return Un int que indica el numero de elementos del programa, this.last
	 */
	public int size(){
		return this.last;
	}
	/**
	 * Devuelve el ByteCode almacenado en una cierta posicion del programa
	 * @param pos Un int que indica la posicion del elemento que se desea consultar
	 * @return Un ByteCode que contiene el la instuccion almacenada en el programa en la posicion requerida
	 */
	public ByteCode at(int pos){
		return this.program[pos];
	}
	/**
	 * Añade al programa una instruccion dada
	 * @param code Un ByteCode que contiene la instruccion que se desea añadir al programa
	 */
	public void add(ByteCode code){
		if(this.last!=MAX){
			this.program[last] = code;
			++this.last;
		}
	}
	/**
	 * Sustituye la instruccion del programa ubicada en una posicion concreta por una dada
	 * @param code Un ByteCode que contiene la instruccion que se desea introducir en el programa
	 * @param pos Un int que contiene la posicion en la que se desea introducir la instruccion dada
	 */
	public void emplace(ByteCode code, int pos){
		this.program[pos] = code;
	}
	/**
	 * Redefine el metodo toString para la clase ByteCodeProgram para poder escribir los programas almacenados
	 */
	public String toString(){
		String show = new String();
		for(int i = 0; i < this.last - 1; ++i)
			show = show + i + ": " + this.program[i] + '\n';
		if (this.last > 0)
			show = show + (this.last - 1) + ": " + this.program[this.last - 1];
		return show;
	}
	/**
	 * Devuelve el atributo estatico MAX
	 * @return int constante
	 */
	public static int getMax() {
		return MAX;
	}
	
}
