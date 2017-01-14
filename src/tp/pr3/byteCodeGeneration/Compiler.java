package tp.pr3.byteCodeGeneration;

import tp.pr3.analyze.ParsedProgram;
import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.ByteCodeProgram;
import tp.pr3.exceptions.ArrayException;
import tp.pr3.exceptions.CompilationError;
import tp.pr3.lexicalAnalysis.instructions.Instruction;

public class Compiler {
	private ByteCodeProgram byteCode;
	private String[] varTable;
	private int numVars;
	private final int MAX = 100;
	
	public Compiler(ByteCodeProgram byteCode) {
		this.byteCode = byteCode;
		this.varTable = new String[MAX];
		this.numVars = 0;
	}
	
	public void compile(ParsedProgram pProgram) throws ArrayException, CompilationError {
		int i = 0;
		while(i < pProgram.length()) {
			Instruction inst = pProgram.at(i);
			inst.compile(this);
			++i;
		}
	}
	
	public void addByteCode(ByteCode b) throws ArrayException {
		this.byteCode.add(b);
	}
	
	public int getIndex(String varName) throws CompilationError{
		boolean encontrado = false;
		int i = 0;
		while(i < numVars && !encontrado) {
			encontrado = varTable[i].equalsIgnoreCase(varName);
			++i;
		}
		if(!encontrado) {
			throw new CompilationError("(La variable no existe)");
		}
		return i - 1;
	}
	
	public int addVariable(String varName) {
		varTable[numVars] = varName;
		++numVars;
		return numVars - 1;
	}
	
	public int getProgramCounter() {
		return byteCode.size();
	}
}
