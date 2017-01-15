package tp.pr3.compilation;
/**
 * Clase que se encarga del parseo léxico del programa fuente en un programa parseado
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
import tp.pr3.compilation.instructions.Instruction;
import tp.pr3.compilation.instructions.InstructionParser;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.LexicalAnalysisException;
import tp.pr3.programs.ParsedProgram;
import tp.pr3.programs.SourceProgram;

public class LexicalParser {
	
	/**
	 * SourceProgram sProgram que guarda el programa fuente
	 */
	private SourceProgram sProgram;
	
	/**
	 * Entero que indica la posición de la instrucción del programa fuente a ejecutar
	 */
	private int programCounter;
	
	/**
	 * Constructor dado un programa fuente, inicializa sProgram al programa dado y el programCounter
	 * a 0
	 * @param sProgram Programa fuente
	 */
	public LexicalParser(SourceProgram sProgram) {
		this.sProgram = sProgram;
		this.programCounter = 0;
	}

	/**
	 * Función que dados un ParsedProgram pProgram y un String stopKey parsea el SourceProgram
	 * que tiene la clase como atributo y lo guarda en pProgram hasta que encuentre stopKey
	 * @param pProgram Programa en el cual vamos a guardar las instrucciones parseadas
	 * @param stopKey String que indica en que línea cesa el parseo
	 * @throws ArrayException Acceso a posición no válida del Array
	 * @throws LexicalAnalysisException Error al análizar el código fuente
	 */
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws ArrayException, LexicalAnalysisException {
		boolean stop=false;
		while(!stop && this.programCounter<=sProgram.length()){
			String instr = sProgram.at(this.programCounter);
			if(instr == null) {
				throw new LexicalAnalysisException("(No se ha detectado fin del programa)");
			}
			else if (instr.trim().equalsIgnoreCase(stopKey)){
				stop = true;
			}
			else {
				Instruction instruction = InstructionParser.parse(instr,this);
				if(instruction == null) {
					throw new LexicalAnalysisException("(La instrucción " + this.programCounter + " no es válida)");
				}
				else {
					pProgram.write(instruction);
					this.increaseProgramCounter();
				}
			}
		}
	}

	/**
	 * Método que aumenta programCounter en una unidad
	 */
	public void increaseProgramCounter() {
		++this.programCounter;
	}

}
