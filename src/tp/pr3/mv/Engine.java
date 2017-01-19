package tp.pr3.mv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import tp.pr3.byteCode.*;
import tp.pr3.command.*;
import tp.pr3.compilation.Compiler;
import tp.pr3.compilation.LexicalParser;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;
import tp.pr3.programs.*;

/**
 * Clase que dirige el funcionamiento de la máquina virtual
 * @author Claudia Guerrero y Rafael Herrera
 * @version 3.0
 */
public class Engine {
	
	/**
	 * Programa fuente leído del fichero
	 */
	private SourceProgram sProgram;
	
	/**
	 * Programa parseado
	 */
	private ParsedProgram pProgram;
	
	/**
	 * Programa de ByteCode almacenado
	 */
	private ByteCodeProgram bytecodeProgram;
	
	/**
	 * Booleano que indica si se ha ordenado que se cierre la máquina virtual
	 */
	private boolean end;
	
	/**
	 * Booleano que indica si el comando ejecutado ha sido HELP
	 */
	private boolean help;
	
	/**
	 * Variable de lectura
	 */
	private static Scanner entrada = new Scanner(System.in);
	
	/**
	 * Constructor sin parámetros
	 */
	public Engine(){
		this.bytecodeProgram = new ByteCodeProgram();
		this.sProgram = new SourceProgram();
		this.pProgram = new ParsedProgram();
		this.end = false;
		this.help = false;
	}

	/**
	 * Guia el funcionamiento de la máquina virtual.
	 * Lee un comando, lo interpreta y lo ejecuta.
	 * Repite este proceso hasta que this.end es true
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
					if (!help) {
						if(sProgram.length() != 0)
							System.out.println("\nPrograma fuente almacenado:\n\n" + sProgram);
						if(bytecodeProgram.size() != 0)
							System.out.println("\nPrograma bytecode almacenado:\n\n" + bytecodeProgram);
					}
				}
				catch(ExecutionError | LexicalAnalysisException | ArrayException | FileException | BadFormatByteCode | DivisionByZero | StackException | CompilationError e){
					System.out.println(e);
				}
				help = false;
			}
		} while(!this.end);
		System.out.println("Cerrando máquina virtual...");
		Engine.entrada.close();
	}
	
	/**
	 * Pone el valor de this.end a true
	 */
	public void quitProgram(){
		this.end = true;
	}
	
	/**
	 * Muestra la ayuda del programa llamando al método ShowHelp() de la clase CommandParser 
	 */
	public void showHelp(){
		CommandParser.showHelp();
		help = true;
	}
	
	/**
	 * Lee un programa fuente de un fichero dado
	 * @param fich String que contiene el nombre del fichero que se quiere leer
	 * @throws ArrayException Array lleno
	 * @throws FileException Fichero no encontrado, Error de lectura
	 */
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
			while(line != null) {
				sProgram.write(line);
				line = flujoEnt.readLine();
			}
			flujoEnt.close();
		}
		catch (IOException e) {
			throw new FileException("(Error de lectura)");
		} 
	}
	
	/**
	 * Compila un programa fuente haciendo primero su análisis léxico y luego la compilación de las instrucciones resultantes
	 * @throws LexicalAnalysisException Instrucción no válida
	 * @throws ArrayException Array lleno
	 * @throws CompilationError Error de compilación
	 */
	public void compile() throws LexicalAnalysisException, ArrayException, CompilationError{
		this.lexicalAnalysis();
		this.generateByteCode();
	}
	
	/**
	 * Analiza léxicamente el programa fuente y lo transforma a programa parseado
	 * @throws LexicalAnalysisException Instrucción no válida
	 * @throws ArrayException Array lleno
	 */
	private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException{
		LexicalParser lexParser = new LexicalParser(sProgram);
		lexParser.lexicalParser(this.pProgram, "END");
	}
	
	/**
	 * Compila el programa parseado para generar un programa de ByteCode
	 * @throws ArrayException Array lleno
	 * @throws CompilationError Error de compilación
	 */
	private void generateByteCode() throws ArrayException, CompilationError{
		Compiler compiler = new Compiler(bytecodeProgram);
		compiler.compile(pProgram);
	}
	
	/**
	 * Ejecuta el programa de Bytecode llamando al método run() de CPU
	 * @throws ExecutionError Error de ejecución
	 */
	public void runProgram() throws ExecutionError{
		CPU cpu = new CPU(this.bytecodeProgram);
		cpu.run();
		System.out.println("El estado de la máquina tras ejecutar el programa ByteCode es:\n");
		System.out.println(cpu.toString());
	}
	
	/**
	 * Si la posición dada es correcta, pide un ByteCode para reemplazar el que se encuentra en dicha posición
	 * @param pos Int que contiene la posición del ByteCode que se quiere sustituir
	 * @throws ArrayException Acceso a posición no válida del Array
	 * @throws BadFormatByteCode El ByteCode introducido no existe
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
