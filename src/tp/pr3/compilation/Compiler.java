package tp.pr3.compilation;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.exceptions.*;
import tp.pr3.programs.*;

/**
 * Clase que se encarga de compilar el programa parseado y convertirlo en un programa de ByteCode
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Compiler {
	
	/**
	 * Programa de ByteCode que se construye al parsear.
	 */
	private ByteCodeProgram byteCode;
	
	/**
	 * Tabla con todas las variables utilizadas en el programa.
	 */
	private String[] varTable;
	
	/**
	 * Número de variables almacenadas.
	 */
	private int numVars;
	
	/**
	 * Constante que indica el máximo de variables que se pueden almacenar.
	 */
	private final int MAX = 100;
	
	/**
	 * Constructor dado el programa ByteCode.
	 * @param byteCode ByteCodeProgram al que se inicializa this.byteCode
	 */
	public Compiler(ByteCodeProgram byteCode) {
		this.byteCode = byteCode;
		this.varTable = new String[MAX];
		this.numVars = 0;
	}
	
	/**
	 * Compila un programa parseado transformándolo en ByteCode que añade al programa de ByteCode.
	 * @param pProgram ParsedProgram que se desea compilar
	 * @throws ArrayException Array lleno
	 * @throws CompilationError Error de compilación
	 */
	public void compile(ParsedProgram pProgram) throws ArrayException, CompilationError {
		int i = 0;
		while(i < pProgram.length()) {
			Instruction inst = pProgram.at(i);
			inst.compile(this);
			++i;
		}
	}
	
	/**
	 * Añade un ByteCode dado al final del programa de ByteCode
	 * @param b ByteCode que se desea añadir
	 * @throws ArrayException Array lleno
	 */
	public void addByteCode(ByteCode b) throws ArrayException {
		this.byteCode.add(b);
	}
	
	/**
	 * Obtiene el índice de la tabla de variables en el que se encuentra una variable dada
	 * @param varName String que contiene el nombre de la variable que se desea buscar
	 * @return Int que indica la posición de la tabla de variables en la que se encuentra la variable
	 * @throws CompilationError Variable no declarada
	 */
	public int getIndex(String varName) throws CompilationError{
		boolean encontrado = false;
		int i = 0;
		while(i < numVars && !encontrado) {
			encontrado = varTable[i].equalsIgnoreCase(varName);
			++i;
		}
		if(!encontrado) {
			throw new CompilationError("(La variable no declarada)");
		}
		return i - 1;
	}
	
	/**
	 * Añade una variable al final de la tabla de variables
	 * @param varName String que contiene el nombre de la variable que se desea añadir
	 * @return Int inidicando la posición en la que se ha añadido
	 */
	public int addVariable(String varName) {
		varTable[numVars] = varName;
		++numVars;
		return numVars - 1;
	}
	
	/**
	 * Devuelve el valor del tamaño del programa de ByteCode
	 * @return Int que contiene el tamaño del programa de ByteCode
	 */
	public int getProgramCounter() {
		return byteCode.size();
	}
}
