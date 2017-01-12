package tp.pr3.mv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import tp.pr3.analyze.SourceProgram;
import tp.pr3.byteCode.*;
import tp.pr3.command.*;
import tp.pr3.cpu.CPU;
import tp.pr3.exceptions.*;


/**
 * Clase que lleva el funcionamiento del bytecodePrograma en sí
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Engine {
	
	private SourceProgram sProgram;
	private ParsedProgram parsedProgam;
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
				if (!comando1.execute(this))
					System.out.println("Error: Ejecución incorrecta del comando");
				else if (comando1.getClass() != Help.class) {
					System.out.println("\nPrograma fuente almacenado:\n\n" + sProgram);
					System.out.println("\nPrograma bytecode almacenado:\n\n" + bytecodeProgram);
				}
			}
		} while(!this.end);
		System.out.println("Fin de la ejecucion....");
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
	
	public void loadFich(String fich){
		BufferedReader flujoEnt = new BufferedReader(new FileReader(fich));
		String line;
		try {
			while((line = flujoEnt.readLine()) != null)
				sProgram.write(line);
		}
		catch (ArrayException e){
			System.out.println(e);
		}
	}
	
	public void compile() throws LexicalAnalysisException, ArrayException{
		try{
			this.lexicalAnalysis();
			this.generateByteCode();
		}
		catch ___
	}
	
	private void lexicalAnalysis() throws LexicalAnalysisException{
		try {
			
		}
	}
	
	private void generateByteCode() throws ArrayException{
		
	}
	
	/**
	 * Ejecuta el bytecodePrograma guardado en this.bytecodeProgram instruccion a instruccion hasta que una de las instrucciones no se ejecuta correctamente, hasta que 
	 * bytecodeProgram.end es true o hasta que se terminan las instrucciones, y va escribiendo el mensaje correspondiente con la ejecucion de cada instruccion
	 *@return OK Un boolean que es true si todo se ha realizado correctamente y false eoc
	 */
	public void runProgram(){
		CPU cpu = new CPU(this.bytecodeProgram);
		try{
			cpu.run();
			System.out.println("El estado de la máquina tras ejecutar el bytecodePrograma es:\n");
			System.out.println(cpu.toString());
		}
		catch (ExecutionError e){
			System.out.println(e);
		}
	}
	/**
	 * Si la posicion dada es correcta, pide una instruccion para sustituir la que se encuentra en esa posicion y, si la instruccion que
	 * se introduce es valida, la sustituye
	 * @param pos Un int que contiene la posicion de la instruccion que se quiere sustituir
	 * @return Un booleano que indica si el proceso se ha llevado a cabo correctamente
	 */
	public boolean replaceInstruc(int pos){
		boolean OK = false;
		if (pos < this.bytecodeProgram.size() && pos >= 0) {
			System.out.println("Nueva instruccion: ");
			String newInst = Engine.entrada.nextLine();
			ByteCode nuevaInst = ByteCodeParser.parse(newInst);
			if (nuevaInst != null) {
				this.bytecodeProgram.emplace(nuevaInst, pos);
				OK = true;
			}
		}
		return OK;
	}
}
