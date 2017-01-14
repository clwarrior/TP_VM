package tp.pr3.mv;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import tp.pr3.byteCodeGeneration.Compiler;
import tp.pr3.analyze.*;
import tp.pr3.byteCode.*;
import tp.pr3.command.*;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;
import tp.pr3.lexicalAnalysis.LexicalParser;


/**
 * Clase que lleva el funcionamiento del bytecodePrograma en sí
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Engine {
	
	private SourceProgram sProgram;
	private ParsedProgram pProgram;
	/**
	 * bytecodePrograma guardado
	 */
	private ByteCodeProgram bytecodeProgram;
	/**
	 * Booleano que indica si se ha ordenado que se cierre el bytecodePrograma
	 */
	private boolean end;
	/**
	 * Variable de lectura
	 */
	private static Scanner entrada = new Scanner(System.in);
	
	/**
	 * Constructor de la clase Engine
	 * Inicializa this.bytecodeProgram a un nuevo bytecodePrograma con su constructor
	 * Inicializa this.end a false
	 */
	public Engine(){
		this.bytecodeProgram = new ByteCodeProgram();
		this.sProgram = new SourceProgram();
		this.pProgram = new ParsedProgram();
		this.end = false;
	}

	/**
	 * Guia el desarrollo del bytecodePrograma
	 * Lee el comando, lo interpreta y luego comprueba si es valido y lo ejecuta
	 * Repite este proceso hasta que se lee this.end es true
	 */
	public void start(){
		do{
			System.out.println();
			String instruc = Engine.entrada.nextLine();
			Command comando1 = CommandParser.parse(instruc);
			if (comando1 == null)
				System.out.println("Comando incorrecto");
			else {
				System.out.println("Comienza la ejecución de " + comando1.toString());
				try {
					comando1.execute(this);
					if (comando1.getClass() != Help.class) {
						System.out.println("\nPrograma fuente almacenado:\n\n" + sProgram);
						if(bytecodeProgram.size() != 0)
							System.out.println("\nPrograma bytecode almacenado:\n\n" + bytecodeProgram);
					}
				}
				catch(ExecutionError | LexicalAnalysisException | ArrayException | FileException | BadFormatByteCode | DivisionByZero | StackException | CompilationError e){
					System.out.println(e);
				}
			}
		} while(!this.end);
		System.out.println("Cerrando máquina virtual...");
		Engine.entrada.close();
	}
	
	/**
	 * Pone el valor de this.end a true
	 * @return boolean true
	 */
	public void quitProgram(){
		this.end = true;
	}
	/**
	 * LLama al metodo showHelp de la clase CommandParser 
	 * @return boolean true
	 */
	public void showHelp(){
		CommandParser.showHelp();
	}
	
	public void loadFich(String fich) throws ArrayException, FileException{
		sProgram = new SourceProgram();
		pProgram = new ParsedProgram();
		bytecodeProgram = new ByteCodeProgram();
		BufferedReader flujoEnt = null;
		try {
			flujoEnt = new BufferedReader(new FileReader(fich));
		} 
		catch (FileNotFoundException e) {
			throw new FileException("(Fichero no encontrado)");
		}
		try {
			String line = flujoEnt.readLine();
			while(!line.equalsIgnoreCase("END")) {
				sProgram.write(line);
				line = flujoEnt.readLine();
			}
			sProgram.write(line);
			flujoEnt.close();
		}
		catch (IOException e) {
			throw new FileException("(Error de lectura)");
		} 
	}
	
	public void compile() throws LexicalAnalysisException, ArrayException, CompilationError{
		this.lexicalAnalysis();
		this.generateByteCode();
	}
	
	private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException{
		LexicalParser lexParser = new LexicalParser(sProgram);
		lexParser.lexicalParser(this.pProgram, "END");
	}
	
	private void generateByteCode() throws ArrayException, CompilationError{
		Compiler compiler = new Compiler(bytecodeProgram);
		compiler.compile(pProgram);
	}
	
	/**
	 * Ejecuta el bytecodePrograma guardado en this.bytecodeProgram instruccion a instruccion hasta que una de las instrucciones no se ejecuta correctamente, hasta que 
	 * bytecodeProgram.end es true o hasta que se terminan las instrucciones, y va escribiendo el mensaje correspondiente con la ejecucion de cada instruccion
	 *@return OK Un boolean que es true si todo se ha realizado correctamente y false eoc
	 */
	public void runProgram() throws ExecutionError{
		CPU cpu = new CPU(this.bytecodeProgram);
		cpu.run();
		System.out.println("El estado de la máquina tras ejecutar el bytecodePrograma es:\n");
		System.out.println(cpu.toString());
	}
	/**
	 * Si la posicion dada es correcta, pide una instruccion para sustituir la que se encuentra en esa posicion y, si la instruccion que
	 * se introduce es valida, la sustituye
	 * @param pos Un int que contiene la posicion de la instruccion que se quiere sustituir
	 * @return Un booleano que indica si el proceso se ha llevado a cabo correctamente
	 */
	public void replaceInstruc(int pos) throws ArrayException, BadFormatByteCode{
		if (pos < this.bytecodeProgram.size() && pos >= 0) {
			System.out.println("Nueva instruccion: ");
			String newInst = Engine.entrada.nextLine();
			ByteCode nuevaInst = ByteCodeParser.parse(newInst);
			if (nuevaInst != null) {
				this.bytecodeProgram.emplace(nuevaInst, pos);
			}
			else {
				throw new BadFormatByteCode("(El bytecode introducido no es correcto)");
			}
		}
		else
			throw new ArrayException("(El bytecode elegido no existe)");
	}
}
