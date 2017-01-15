package tp.pr3.compilation.instructions.jumps;

import tp.pr3.exceptions.*;
import tp.pr3.programs.ParsedProgram;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.conditions.*;
import tp.pr3.compilation.instructions.Instruction;

/**
 * Clase hija de Instruction.
 * Realiza el parseo y compilación de las instrucciónes if
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class IfThen implements Instruction {

	/**
	 * Condición de salto
	 */
	private Condition condition;
	
	/**
	 * Cuerpo del if
	 */
	private ParsedProgram ifBody;
	
	/**
	 * Constructor dada la condición y el cuerpo del if
	 * @param cond Condition a la que se inicializará this.cond
	 * @param ibody ParsedProgram al que se inicializará this.ifBody
	 */
	public IfThen(Condition cond, ParsedProgram ibody) {
		this.condition = cond;
		this.ifBody = ibody;
	}

	/**
	 * Constructor sin parámetros
	 */
	public IfThen() {}

	/**
	 * {@inheritDoc}
	 * En este caso, la transforma en un if con el cuerpo y la condición correspondientes
	 * @return IfThen, si corresponde, o null, si no
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException{
		if(words[0].equalsIgnoreCase("IF")) {
			Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			lexParser.increaseProgramCounter();
			ParsedProgram ibody = new ParsedProgram();
			lexParser.lexicalParser(ibody, "ENDIF");
			return new IfThen(cond, ibody);
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * Concretamente, la transforma en los ByteCode de la condición y del cuerpo del if
	 */
	public void compile(Compiler compiler) throws ArrayException, CompilationError{
		this.condition.compile(compiler);
		compiler.compile(this.ifBody);
		this.condition.setJump(compiler.getProgramCounter());
	}
}
