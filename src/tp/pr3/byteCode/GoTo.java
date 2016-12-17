package tp.pr3.byteCode;

import tp.pr3.cpu.CPU;
/**
 * Clase hija de ByteCode.
 * Clase que realiza saltos incondicionales en la lectura del programa.
 * Tiene un int jump que indica la posicion del programa a la que queremos saltar.
 * @author Claudia Guerrero y Rafael Herrera
 * @version 2.0
 */
public class GoTo implements ByteCode{
	/** 
	 * Posicion a la que se movera el contador del programa tras ejecutar esta instruccion
	 */
	private int jump;
	/**
	 * Constructor que inicializa this.jump a jump
	 * @param jump, Un int al cual inicializar el atributo de la clase
	 */
	public GoTo(int jump){
		this.jump = jump;
	}
	/**
	 * Constructor sin parametros
	 */
	public GoTo() {}
	/**
	 * Metodo que invoca a changeCounter de cpu para que cambie el contador al valor jump.
	 * @param cpu Una CPU cuyo contador de programa vamos a cambiar
	 * @return  true si se ha podido hacer, false eoc
	 */
	public boolean execute(CPU cpu){
		return cpu.changeCounter(jump);		
	}
	/**
	 * Metodo que comprueba que la longitud del array dado coomo parametro y si se corresponde con el nombre
	 * de la clase y tiene la longitud adecuada construye un nuevo elemento de la clase y lo devuelve, si no
	 * devuelve null.
	 * @param s Un array de String que debe contener el nombre de alguna instruccion de la clase ByteCode
	 * @return Un nuevo elemento de la clase GoTo si el array de entrada es correcto, si no devuelve null.
	 */
	public ByteCode parse(String[] s){
		if (s.length==2 && s[0].equalsIgnoreCase("GOTO"))
			return new GoTo(Integer.parseInt(s[1]));
		else
			return null;
	}
	/**
	 * Redefine el metodo toString para la clase GoTo, para poder mostrar la instruccion por pantalla
	 */
	public String toString(){
		return "GOTO "+jump;
	}
}
