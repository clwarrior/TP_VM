package tp.pr3.compilation.instructions.jumps;

import tp.pr3.byteCode.GoTo;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.compilation.conditions.Condition;
import tp.pr3.compilation.conditions.ConditionParser;
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.programs.ParsedProgram;
/**
 * Clase hija de Instruction.
 * Realiza el parseo y compilación de las instrucciónes while
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class While implements Instruction {
	/**
	 * Condición que debe cumplirse para entrar en el while
	 */
	private Condition condition;
	
	/**
	 * Programa parseado que almacena el cuerpo del bucle
	 */
	private ParsedProgram whileBody;
	 /**
	  * Constructor dada una condición y un programa parseado
	  * @param cond Condición
	  * @param whileBody Programa parseado que guarda el cuerpo del bucle
	  */
	public While(Condition cond, ParsedProgram whileBody) {
		this.condition = cond;
		this.whileBody = whileBody;
	}
	
	/**
	 * Constructor sin parámetros
	 */
	public While() {}

	/**
	 * {@inheritDoc}
	 * En este caso, la transforma en un while con el cuerpo y la condición correspondientes
	 * @return While, si corresponde, o null, si no
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException{
		if(words[0].equalsIgnoreCase("WHILE")) {
			Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			ParsedProgram wbody = new ParsedProgram();
			lexParser.increaseProgramCounter();
			lexParser.lexicalParser(wbody, "ENDWHILE");
			return new While(cond, wbody);
		}
		else
			return null;
	}
	
	/**
	 * {@inheritDoc}
	 * Concretamente, la transforma en los ByteCode de la condición y del cuerpo del while
	 */
	public void compile(Compiler compiler) throws ArrayException, CompilationError{
		int inicio = compiler.getProgramCounter();
		this.condition.compile(compiler);
		compiler.compile(this.whileBody);
		compiler.addByteCode(new GoTo(inicio));
		this.condition.setJump(compiler.getProgramCounter());
	}

}
