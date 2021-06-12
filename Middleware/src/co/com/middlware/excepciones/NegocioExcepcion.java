package co.com.middlware.excepciones;

/**
 * Manejo de excepciones para logica de negocio
 */

@SuppressWarnings("serial")
public class NegocioExcepcion extends BaseException{

	/**
	 * Constructor por defecto
	 * 
	 */	
	public NegocioExcepcion() {
		super();
	}
	
	/**
	 * Constructor de la clase
	 * 
	 * @param mensaje
	 *            Mensaje arrojado por la excepci�n
	 */	
	public NegocioExcepcion(String mensaje) {
		
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
	public NegocioExcepcion(String codigoError, String mensaje) {
		super(codigoError, mensaje);
	}
	
	/**
	 * Constructor de la clase
	 * 
	 * @param throwable
	 *            Objeto de la excepci�n
	 */	
	public NegocioExcepcion(Throwable throwable) {
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
	public NegocioExcepcion(String codigoError, Throwable throwable) {
		super(codigoError, throwable);
	}
	
}