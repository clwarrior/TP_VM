package tp.pr3.cpu;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.ByteCodeProgram;
import tp.pr3.exceptions.*;

/**
 * Clase que contiene los metodos y atributos de la CPU
 * Contiene una memoria, una pila y un booleano que indica si ha terminado la ejecucion del programa
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class CPU {
	
	/**
	 * Un objeto de la clase Memory que contiene la memoria
	 */
	private Memory memoria;
	/**
	 * Un objeto de la clase OperandStack que contiene la pila
	 */
	private OperandStack stack;
	/**
	 * Un boolean que indica si la ejecucion del programa ha terminado
	 */
	private boolean end;
	/**
	 * Un ByteCodeProgram que contiene el programa a ejecutar
	 */
	private ByteCodeProgram bcProgram;
	/**
	 * Un int que contiene la instruccion del programa que se va a ejecutar a continuacion
	 */
	private int programCounter;
	
	/**
	 * Constructor de la clase CPU
	 * Inicializa la memoria utilizando el constructor de la clase Memory
	 * Inicializa la pila utilizando el constructor de la clase OperandStack
	 * Inicializa el valor de this.end a false
	 * @param program Un ByteCodeProgram al que inicializar bcProgram
	 */
	public CPU(ByteCodeProgram program){
		memoria = new Memory();
		stack = new OperandStack();
		end = false;
		programCounter = 0;
		bcProgram = program;
	}
	/**
	 * Ejecuta una programa de byteCodes si es posible. Si no lo es, devuelve false y no hace nada
	 * @return Un boolean que es true si se han podido ejecutar todas las instrucciones
	 * y false si alguna no se ha podido ejecutar
	 * @throws ArrayException 
	 * @throws StackException 
	 */
	public void run() throws ExecutionError, ArrayException, DivisionByZero, StackException{
		while(!end && this.programCounter < bcProgram.size()){
			ByteCode instruccion = bcProgram.at(this.programCounter);
			++programCounter;
			instruccion.execute(this);
		}
	}
	/**
	 * Devuelve el estado de this.end
	 * @return Un boolean que indica el valor de this.end
	 */
	public boolean getEnd(){
		return this.end;
	}
	/**
	 * Cambia el valor de this.end a true
	 */
	public void end(){
		this.end=true;
	}

	/**
	 * Llama al metodo pop de la clase stack, que saca el ultimo elemento de la pila y lo devuelve
	 * @return int que es el ultimo elemento de la pila que acabamos de sacar
	 */
	public int pop() throws StackException{
		return this.stack.pop();
	}
	
	/**
	 * Llama al metodo push de la clase stack  que introduce un elemento dado como parametro en la pila
	 * @param elem, entero que queremos almacenar en la pila
	 * @return Un boolean que es true si se ha podido introducir elem y false si la pila estaba llena
	 */
	public void push(int elem) throws StackException{
		this.stack.push(elem);
	}
	/**
	 * Cambia this.programCounter a al valor del int jump
	 * @param jump, valor al cual queremos poner this.programCounter
	 * @return true si se ha podido cambiar y false si no
	 * @throws ExecutionError 
	 */
	public void changeCounter(int jump) throws ExecutionError{
		if(jump>=0 && jump < ByteCodeProgram.getMax()){
			this.programCounter=jump;
		}
		else 
			throw new ExecutionError("(Intento de salto a posición no válida)");
	}
	/**
	 * Llama al metodo at sobre this.memory para obtener el valor que toma la memoria en la posicion
	 * dada como paramentro num
	 * @param num, int que nos dice que posicion de la memoria queremos consultar
	 * @return int que almacena la memoria en la posicion num
	 */
	public int load(int num) throws ArrayException{
		return this.memoria.at(num);
	}
	/**
	 * Llama al metodo insert sobre this.memoria para almacenar el int elem el la posicion num de memoria
	 * @param num, int de la posicion en la cual queremos guardar el elemento
	 * @param elem, int elemento a guardar en la memoria
	 */
	public void store(int num, int elem) throws ArrayException{
		this.memoria.insert(num, elem);
	}
	/**
	 * Redefine el metodo toString para la clase CPU para poder escribir el estado de la CPU
	 */
	public String toString(){
		String show = new String("Estado de la CPU: \n\t" + this.memoria.toString() + "\n\t" + this.stack.toString());
		return show;
	}
}
