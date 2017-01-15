package tp.pr3.byteCode;

import tp.pr3.byteCode.arithmetics.*;
import tp.pr3.byteCode.conditionalJumps.*;
import tp.pr3.byteCode.memoryMove.*;

/**
 * Clase que se encarga de interpretar los ByteCode.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class ByteCodeParser {
	
	/**
	 * Array de ByteCodes que contiene un ByteCode de cada tipo
	 */
	private final static ByteCode[] byteCodes = {
		new Add(), new Sub(), new Mul(), new Div(), new IfEq(), new IfNeq(),
		new IfLe(), new IfLeq(), new GoTo(), new Push(), new Store(), new Load(),
		new Halt(), new Out()};
	
	/**
	 * Prueba a parsear la instrucción dada como todos los tipos de ByteCodes, devolviendo el que encaje, o null
	 * @param line String que contiene la instrucción que se quiere interpretar
	 * @return El ByteCode correspondiente a la instrucción dada, o null si no correspondía a ninguno
	 */
	public static ByteCode parse(String line){
		String subcads[] = line.split(" ");
		ByteCode bytecode = null;
		int i=0;
		while(bytecode==null && i<byteCodes.length){
			bytecode= byteCodes[i].parse(subcads);
			++i;
		}
		return bytecode;
	}
}
