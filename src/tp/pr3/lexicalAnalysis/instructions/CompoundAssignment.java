package tp.pr3.lexicalAnalysis.instructions;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.arithmetics.*;
import tp.pr3.byteCode.memoryMove.Store;
import tp.pr3.byteCodeGeneration.Compiler;
import tp.pr3.exceptions.*;
import tp.pr3.lexicalAnalysis.LexicalParser;
import tp.pr3.lexicalAnalysis.term.*;

public class CompoundAssignment implements Instruction {
	private String var_name;
	private String operator;
	private Term term1;
	private Term term2;
	
	public CompoundAssignment(String name, String operator, Term term1, Term term2){
		this.var_name=name;
		this.operator=operator;
		this.term1=term1;
		this.term2=term2;
	}
	public CompoundAssignment() {}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		char name = words[0].toLowerCase().charAt(0);
		if (!('a' <= name && name <= 'z') || words.length!=5 || !words[1].equals("=") ||
				!words[3].equals("+") || !words[3].equals("-") || !words[3].equals("*") || !words[3].equals("/"))
			return null;
		else{
			Term term1 = TermParser.parse(words[2]);
			Term term2 = TermParser.parse(words[4]);
			if(term1 == null || term2 == null)
				throw new LexicalAnalysisException("(Instrucción no válida)");
			else{
				lexParser.increaseProgramCounter();
				return new CompoundAssignment(words[0], words[3], term1, term2);
			}
		}
	}
	
	public void compile(Compiler compiler) throws CompilationError, ArrayException {
		this.term1.compile(compiler);
		this.term2.compile(compiler);
		ByteCode operacion = null;
		switch(this.operator.charAt(0)) {
		case '+': operacion = new Add(); break;
		case '-': operacion = new Sub(); break;
		case '*': operacion = new Mul(); break;
		case '/': operacion = new Div(); break;
		}
		compiler.addByteCode(operacion);
		int index = 0;
		try {
			index = compiler.getIndex(var_name);
		}
		catch(CompilationError e) {
			index = compiler.addVariable(var_name);
		}
		finally {
			compiler.addByteCode(new Store(index));
		}
		
	}
}
