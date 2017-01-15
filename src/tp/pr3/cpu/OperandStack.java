package tp.pr3.cpu;

import tp.pr3.exceptions.StackException;

/**
 * Clase que contiene los metodos y atributos de la pila. Se trata de un array de tamaño maximo 100
 * que funciona como una pila
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class OperandStack {

	/**
	 * Array de int que contiene los datos de la pila
	 */
	private int[] array;
	/**
	 * Int que indica el numero de elementos que contiene la pila
	 */
	private int size;
	/**
	 * Int constante que indica el tamaño maximo de la pila
	 */
	private final int TAM=100;
	
	/**
	 * Constructor de la clase OperandStack
	 * Inicializa this.array a un array de int de tamaño maximo (100)
	 * Inicializa this.size a 0
	 */
	public OperandStack(){
		array = new int[TAM];
		size = 0;
	}
	/**
	 * Devuelve si esta o no la pila vacia
	 * @return Un boolean que vale true si la pila esta vacia y false si contiene algun elemento
	 */
	private boolean empty(){
		return this.size == 0;
	}
	 /**
	  * Extrae el ultimo elemento almacenado en la pila
	  * @return Un int que contiene el ultimo elemento almacenado en la pila
	 * @throws StackException Pila vacía
	  */
	public int pop() throws StackException{
		if(this.empty())
			throw new StackException("(Pila vacía)");
		else {
			--size;
			return array[size];
		}
	}
	/**
	 * Introduce un elemento en la pila si esta no esta llena. Si lo esta, devuelve error
	 * @param elem Un int que contiene el elemento a introducir en la pila
	 * @throws StackException Pila llena
	 */
	public void push(int elem) throws StackException{
		if (size == TAM)
			throw new StackException("(Pila llena)");
		else {
			array[size] = elem;
			++size;
		}
	}
	/**
	 * Redefine el metodo toString para la clase OperandStack para poder escribir el contenido de la pila
	 */
	public String toString(){
		String show = new String("Pila: ");
		if(this.empty())
			show = show + "<vacia>";
		else {
			for (int i = 0; i < this.size; ++i)
				show = show + array[i] + ' ';
		}
		return show;
	}
}
