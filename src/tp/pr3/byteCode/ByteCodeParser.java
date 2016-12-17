package tp.pr3.byteCode;

import tp.pr3.byteCode.arithmetics.Add;
import tp.pr3.byteCode.arithmetics.Div;
import tp.pr3.byteCode.arithmetics.Mul;
import tp.pr3.byteCode.arithmetics.Sub;
import tp.pr3.byteCode.conditionalJumps.IfEq;
import tp.pr3.byteCode.conditionalJumps.IfLe;
import tp.pr3.byteCode.conditionalJumps.IfLeq;
import tp.pr3.byteCode.conditionalJumps.IfNeq;
import tp.pr3.byteCode.memoryMove.Load;
import tp.pr3.byteCode.memoryMove.Store;

/**
 * Clase que se encarga de interpretar los ByteCode
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class ByteCodeParser {
	/**
	 * Array de ByteCodes que contiene un ByteCode de cada tipo que hay
	 */
	private final static ByteCode[] byteCodes = {
		new Add(), new Sub(), new Mul(), new Div(), new IfEq(), new IfNeq(),
		new IfLe(), new IfLeq(), new GoTo(), new Push(), new Store(), new Load(),
		new Halt(), new Out()};
	/**
	 * Dado un String que contiene la instruccion, la interpreta y la convierte en un comando valido si puede
	 * @param line Un String que contiene la instruccion introducida por teclado que se desea interpretar
	 * @return Un comando valido o null si la intruccion dada no era correcta
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
