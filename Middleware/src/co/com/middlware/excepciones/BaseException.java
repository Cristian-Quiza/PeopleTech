package co.com.middlware.excepciones;

/**
 * Excepcion Base para la aplicacion
 * 
 * ----
 * @date 2014/02/03
 * 
 */
@SuppressWarnings("serial")
public class BaseException extends Exception{

	private String codigoError;
	
	/**
	 * Constructor por defecto
	 * 
	 */	
	public BaseException() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param mensaje
	 *            Mensaje arrojado por la excepci�n
	 */	
	public BaseException(String mensaje) {
		
		super(mensaje);
	}
	
	/**
	 * Constructor de la clase
	 * 
	 * @param codigoError
	 *            C�digo del error que se genera
	 * @param mensaje
	 *            Mensaje arrojado por la excepci�n
	 */	
	public BaseException(String codigoError, String mensaje) {
		
		super(mensaje);
		this.setCodigoError(codigoError);		
	}
	
	/**
	 * Constructor de la clase
	 * 
	 * @param throwable
	 *            Objeto de la excepci�n
	 */	
	public BaseException(Throwable throwable) {
		super(throwable);
	}
	
	/**
	 * Constructor de la clase
	 * 
	 * @param codigoError
	 *            C�digo del error que se genera
	 * @param throwable
	 *            Objeto de la excepci�n
	 */	
	public BaseException(String codigoError, Throwable throwable) {
		super(codigoError, throwable);
		this.setCodigoError(codigoError);
	}

	/**
	 * M�todo encargado de retornar el valor del atributo codigoError
	 * 
	 * @return codigoError Valor del atributo
	 */
	public String getCodigoError() {
		return codigoError;
	}

	/**
	 * M�todo encargado de asignar el valor del atributo codigoError
	 * 
	 * @param codigoError
	 *            Valor a asignar al atributo codigoError
	 */
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	
}
