package tp.pr3.mv;


import java.util.Scanner;

import tp.pr3.byteCode.ByteCode;
import tp.pr3.byteCode.ByteCodeParser;
import tp.pr3.byteCode.ByteCodeProgram;
import tp.pr3.command.Command;
import tp.pr3.command.CommandParser;
import tp.pr3.command.Help;
import tp.pr3.cpu.CPU;


/**
 * Clase que lleva el funcionamiento del programa en sí
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class Engine {
	
	/**
	 * Programa guardado
	 */
	private ByteCodeProgram program;
	/**
	 * Booleano que indica si se ha ordenado que se cierre el programa
	 */
	private boolean end;
	/**
	 * Variable de lectura
	 */
	private static Scanner entrada = new Scanner(System.in);
	
	/**
	 * Constructor de la clase Engine
	 * Inicializa this.program a un nuevo programa con su constructor
	 * Inicializa this.end a false
	 */
	public Engine(){
		this.program = new ByteCodeProgram();
		this.end = false;
	}

	/**
	 * Guia el desarrollo del programa
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
				else if (comando1.getClass() != Help.class)
					System.out.println("\nPrograma almacenado:\n\n" + program);
			}
		} while(!this.end);
		System.out.println("Fin de la ejecucion....");
		Engine.entrada.close();
	}
	
	/**
	 * Pone el valor de this.end a true
	 * @return boolean true
	 */
	public boolean quitProgram(){
		this.end = true;
		return true;
	}
	/**
	 * LLama al metodo showHelp de la clase CommandParser 
	 * @return boolean true
	 */
	public boolean showHelp(){
		CommandParser.showHelp();
		return true;
	}
	/**
	 * Lee las instrucciones del ByteCodeProgram introducidas por pantalla hasta la
	 * instruccion END y comprueba que son correctas
	 * @return boolean true
	 */
	public boolean readByteCodeProgram(){
		String instruc = new String();
		System.out.println("Introduzca el bytecode. Una instrucción por línea:\n");
		instruc=entrada.nextLine();
		while(!instruc.toUpperCase().equals("END")){
			ByteCode ins = ByteCodeParser.parse(instruc);
			if (ins!=null){
				program.add(ins);
			}
			else
				System.out.println("Instrucción incorrecta\n");
			instruc=entrada.nextLine();
		}
		
		return true;
	}
	/**
	 * Ejecuta el programa guardado en this.program instruccion a instruccion hasta que una de las instrucciones no se ejecuta correctamente, hasta que 
	 * program.end es true o hasta que se terminan las instrucciones, y va escribiendo el mensaje correspondiente con la ejecucion de cada instruccion
	 *@return OK Un boolean que es true si todo se ha realizado correctamente y false eoc
	 */
	public boolean runProgram(){
		CPU cpu = new CPU(this.program);
		boolean OK = cpu.run();
		if(OK) {
			System.out.println("El estado de la máquina tras ejecutar el programa es:\n");
			System.out.println(cpu.toString());
		}
		return OK;
	}
	/**
	 * Resetea this.program iniciandolo a uno nuevo utilizando el constructor de ByteCodeProgram
	 * @return true en todo caso
	 */
	public boolean resetProgram(){
		this.program = new ByteCodeProgram();
		return true;
	}
	/**
	 * Si la posicion dada es correcta, pide una instruccion para sustituir la que se encuentra en esa posicion y, si la instruccion que
	 * se introduce es valida, la sustituye
	 * @param pos Un int que contiene la posicion de la instruccion que se quiere sustituir
	 * @return Un booleano que indica si el proceso se ha llevado a cabo correctamente
	 */
	public boolean replaceInstruc(int pos){
		boolean OK = false;
		if (pos < this.program.size() && pos >= 0) {
			System.out.println("Nueva instruccion: ");
			String newInst = Engine.entrada.nextLine();
			ByteCode nuevaInst = ByteCodeParser.parse(newInst);
			if (nuevaInst != null) {
				this.program.emplace(nuevaInst, pos);
				OK = true;
			}
		}
		return OK;
	}
}
