package tp.pr3.cpu;

import tp.pr3.exceptions.ArrayException;

/**
 * Clase que contiene los metodos y atributos de la memoria. Se trata de un array dinamico
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Memory {
	
	/**
	 * Array de Integer que contiene los datos de la memoria
	 */
	private Integer[] array;
	/**
	 * Int que indica la capacidad maxima de this.array
	 */
	private int capacity;
	
	/**
	 * Constructor de la clase Memory
	 * Inicializa this.array a un array de Integer de tamaño 10 relleno de null
	 * Inicializa this.capacity a 10
	 */
	public Memory(){
		this.array = new Integer[10];
		this.capacity = 10;
		for (int i = 0; i < this.capacity; ++i)
			array[i] = null;
	}
	/**
	 * Redimensiona la memoria al doble del tamaño pedido
	 * Para ello crea un nuevo array del doble del tamaño y copia a el el contenido de this.array
	 * Luego rellena el resto del nuevo array con null y sobreescribe this.array con este nuevo array
	 * Por ultimo guarda en this.capacity el tamaño del nuevo array
	 * @param tam Un int que guarda el tamaño minimo que se necesita para el array
	 */
	private void redimensionar(int tam){
		Integer[] nuevoArray = new Integer[tam * 2];
		for (int i = 0; i < this.capacity; ++i)
			nuevoArray [i] = this.array[i];
		for(int i = this.capacity; i < tam * 2; ++i)
			nuevoArray [i] = null;
		this.array = nuevoArray;
		this.capacity = tam * 2;
	}
	/**
	 * Inserta un elemento dado en una posicion dada
	 * Si la posicion es mayor que el tamaño del array, lo redimensiona
	 * @param pos Un int que indica la posicion en la que se desea almacenar el elemento
	 * @param elem Un int que contiene el nuevo elemento a guardar en la memoria
	 * @throws ArrayException Posición del Array no válida
	 */
	public void insert(int pos, int elem) throws ArrayException{
		if(pos >= 0) {
			if (pos >= this.capacity)
				this.redimensionar(pos);
			this.array[pos] = elem;
		}
		else {
			throw new ArrayException("(Posición del array no válida)");
		}
	}
	/**
	 * Devuelve el contenido de la memoria en una cierta posicion. Si en esa posicion no hay nada,
	 * se intorduce un 0 en ella y se devuelve
	 * @param pos Un int que contiene la posicion de la que se quiere saber el contenido
	 * @return Un Integer con el contenido de la memoria en la posicion requerida
	 * @throws ArrayException Posición del Array no válida
	 */
	public int at(int pos) throws ArrayException{
		if (pos >= 0) {
			if (pos >= this.capacity)
				this.redimensionar(pos);
			if (this.array[pos] == null)
				this.array[pos] = 0;
			return this.array[pos];
		}
		else
			throw new ArrayException("(Posición del array no válida)");
	}
	/**
	 * Redefine el metodo toString para la clase Memory para poder escribir el contenido de la memoria
	 */
	public String toString(){
		String show = new String("Memoria: ");
		for(int i = 0; i < this.capacity; ++i) {
			if (this.array[i] != null){
				show = show + '[' + i + "]:" + this.array[i].toString() + ' ';
			}
		}
		if (show.equals("Memoria: "))
			show = show + "<vacia>";
		return show;
	}
}
