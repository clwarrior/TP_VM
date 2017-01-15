package tp.pr3.cpu;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.exceptions.*;
import tp.pr3.programs.ByteCodeProgram;

/**
 * Clase que contiene los metodos y atributos de la CPU. 
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class CPU {
	
	/**
	 * Memory que contiene la memoria
	 */
	private Memory memoria;
	
	/**
	 * OperandStack que contiene la pila
	 */
	private OperandStack stack;
	
	/**
	 * Boolean que indica si la ejecucion del programa ha terminado
	 */
	private boolean end;
	
	/**
	 * ByteCodeProgram que contiene el programa a ejecutar
	 */
	private ByteCodeProgram bcProgram;
	
	/**
	 * Un int que contiene la instruccion del programa que se va a ejecutar a continuacion
	 */
	private int programCounter;
	
	/**
	 * Constructor de la clase CPU dado el ByteCode program
	 * @param program ByteCodeProgram al que se inicializa this.bcProgram
	 */
	public CPU(ByteCodeProgram program){
		memoria = new Memory();
		stack = new OperandStack();
		end = false;
		programCounter = 0;
		bcProgram = program;
	}
	
	/**
	 * Ejecuta el programa de ByteCode almacenado
	 * @throws ExecutionError Error de ejecución
	 */
	public void run() throws ExecutionError{
		int bytecodeEjecutado = 0;
		ByteCode instruccion = null;
		try {
			while(!end && this.programCounter < bcProgram.size()){
				bytecodeEjecutado = this.programCounter;
				instruccion = bcProgram.at(this.programCounter);
				++programCounter;
				instruccion.execute(this);
			}
		}
		catch (StackException | ExecutionError | ArrayException | DivisionByZero e) {
			String mensaje = "";
			mensaje = "Error de ejecución en el bytecode " + bytecodeEjecutado + '\n';
			mensaje = mensaje + "Excepción en el bytecode " + instruccion + ": ";
			throw new ExecutionError(mensaje + e);
		}
	}
	
	/**
	 * Devuelve el estado de this.end
	 * @return Boolean que contiene el estado de this.end
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
	 * Saca el último elemento de la pila y lo devuelve.
	 * @return Int que contiene el último elemento de la pila
	 * @throws StackException Pila vacía
	 */
	public int pop() throws StackException{
		return this.stack.pop();
	}
	
	/**
	 * Introduce un elemento dado en la pila
	 * @param elem Int que queremos introducir en la pila
	 * @throws StackException Pila llena
	 */
	public void push(int elem) throws StackException{
		this.stack.push(elem);
	}
	
	/**
	 * Cambia this.programCounter a al valor dado.
	 * @param jump Int al que queremos cambiar this.programCounter
	 * @throws ExecutionError Intento de salto a posición no válida
	 */
	public void changeCounter(int jump) throws ExecutionError{
		if(jump>=0 && jump < bcProgram.size()){
			this.programCounter=jump;
		}
		else 
			throw new ExecutionError("(Intento de salto a posición no válida)");
	}
	
	/**
	 * Obtiene el almacenado en la posición dada de la memoria
	 * @param num Int que indica la posición de la memoria que queremos consultar
	 * @return Int que contiene lo que hay almacenado en la posición de la memoria correspondiente
	 * @throws ArrayException Acceso a posición inexistente de la memoria
	 */
	public int load(int num) throws ArrayException{
		return this.memoria.at(num);
	}
	
	/**
	 * Almacena un número dado en la posición de la memoria dada
	 * @param num Int que contiene la posición en la que queremos almacenar el elemento
	 * @param elem Int que contiene el elemento que queremos almacenar
	 * @throws ArrayException Acceso a posición inexistente de la memoria
	 */
	public void store(int num, int elem) throws ArrayException{
		this.memoria.insert(num, elem);
	}
	
	/**
	 * Redefine el metodo toString para la clase CPU
	 */
	public String toString(){
		String show = new String("Estado de la CPU: \n\t" + this.memoria.toString() + "\n\t" + this.stack.toString());
		return show;
	}
}
