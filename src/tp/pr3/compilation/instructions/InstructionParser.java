package tp.pr3.compilation.instructions;

import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.instructions.assignments.*;
import tp.pr3.compilation.instructions.jumps.*;
import tp.pr3.exceptions.*;

/**
 * Clase que se encarga de interpretar las instrucciones del programa fuente.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class InstructionParser {

	/**
	 * Array que contiene todos los tipos de instrucciones.
	 */
	private static final Instruction[] instructions = {new SimpleAssignment(), new CompoundAssignment(), 
												new While(), new IfThen(), new Return(), new Write()};
	
	/**
	 * Prueba a interpretar la instruccion dada como todos los tipos de Instruction, devolviendo el que encaje, o null
	 * @param inst String que contiene la instrucción que se desea interpretar
	 * @param lexParser Parseador léxico
	 * @return Instruction correspondiente, si la hay, o null en caso contrario
	 * @throws LexicalAnalysisException Instrucción no válida
	 * @throws ArrayException Array lleno
	 */
	public static Instruction parse(String inst, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException{
		Instruction instruction = null;
		String subcads[] = inst.trim().split(" ");
		int i=0;
		while(instruction == null && i<instructions.length){
			instruction = instructions[i].lexParse(subcads, lexParser);
			++i;
		}
		return instruction;
	}
}
