 /**
 * 
 */
package co.com.middlware.utilidades;

/**
 * Clase: EnumManejoErrores.java 
 * enumerado para el manejo de codigo de excepciones 
 * @version 1.0, 21/01/2020
 * @author Juan Camilo Fonseca
 */

public enum EnumManejoErrores {

	CONSUMO_CORRECTO(1,"Consumo correcto"),
	
	ERROR_PARAMETROS(98, "Parámetros incorrectos"),
	
	ERROR_SERVICIO_REST(91,"Error general al tratar de consumir el servicio REST."),
	
	ERROR_PROCESO_TRANSACCION(99,"Error general al procesar la transaccion.");	
	

	/**
	 * Variable de acceso al codigo de error del enumerado
	 */
	private final int key;
	/**
	 * Variable de acceso al mensaje de error del enumerado
	 */
	private final String value;
	/**
	 * Constructor del enumerado
	 * 
	 * @param key
	 * @param value
	 */
	private EnumManejoErrores(int key, String value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * Metodo de acceso del codigo de error del enumerado
	 * 
	 * @return codigo de error del enumerado
	 */
	public int getKey() {
		return key;
	}
	/**
	 * Metodo de acceso del mensaje de error del enumerado
	 * 
	 * @return Menesaje de error del enumerado
	 */
	public String getValue() {
		return value;
	}
	/**
	 * Metodo de acceso del codigo de error concatenado con su respectivo mensaje
	 * del enumerado
	 * 
	 * @return codigo concatenado con su mensaje de error
	 */
	public String getMessage() {
		StringBuilder message = new StringBuilder();
		message.append(key).append(":").append(value);
		return message.toString();
	}
}
