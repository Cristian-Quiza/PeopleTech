package co.com.middleware.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import co.com.middlware.excepciones.BaseException;



public class Log {
	
	
	/** Define la ubicacion del archivo de propiedades para el log. */
	public static final String RUTA_PROPIEDADES_LOG = "/var/lib/tomcat/bin/configuracion/log4j.properties";
	
	/** Instancia de la clase */ 
	private static Log instance ;  
	
	/** Objeto que referencia el Logger */
	Logger logger;
	
	private Log(){
		PropertyConfigurator.configure(RUTA_PROPIEDADES_LOG);
	}
	/**
	 * Metodo para obtener la instancia del objeto
	 * @return
	 */
	public static Log getInstance() { 
		
		if(instance==null) 
			instance = new Log(); 
		
		return instance;  
	}
	
	/**
	 * Metodo encargado de guardar un mensaje en el 
	 * log en nivel DEBUG.
	 * 
	 * @param mensaje
	 * @param clase
	 */
	public void debug(String mensaje, Class<?> clase){
		logger = Logger.getLogger(clase);
		logger.debug(mensaje);
	}
	
	/**
	 * Metodo encargado de guardar un mensaje en el 
	 * log en nivel DEBUG.
	 * 
	 * @param mensaje
	 * @param nombreClase
	 */
	public void debug(String mensaje, String nombreClase){
		logger = Logger.getLogger(nombreClase);
		logger.debug(mensaje);
	}
	
	/**
	 * Metodo encargado de guardar un mensaje en el 
	 * log en nivel INFO.
	 * 
	 * @param mensaje
	 * @param clase
	 */
	
	public void info(String mensaje, Class<?> clase){
		logger = Logger.getLogger(clase);
		logger.info(mensaje);
	}
	
	/**
	 * Metodo encargado de guardar un mensaje en el 
	 * log en nivel WARNING.
	 * 
	 * @param mensaje
	 * @param clase
	 */
	public void warn(String mensaje, Class<?> clase){
		logger = Logger.getLogger(clase);
		logger.warn(mensaje);
	}
	
	/**
	 * Metodo encargado de guardar un mensaje en el 
	 * log en nivel ERROR.
	 * 
	 * @param mensaje
	 * @param clase
	 */
	public void error(String mensaje, Class<?> clase){
		logger = Logger.getLogger(clase);
		logger.error(mensaje);
	}
	
	/**
	 * Metodo encargado de guardar la traza de un error
	 * en el archivo log.
	 * 
	 * @param aThrowable
	 * @param clase
	 */
	public void error(Throwable aThrowable, Class<?> clase){
		logger = Logger.getLogger(clase);
		logger.error(getStackTrace(aThrowable));
	}
	
	
	
	
	/**
	 * Recibe una excepci�n y retorna un String con la traza que se gener� por
	 * su causa.
	 * 
	 * @param aThrowable
	 * @return
	 */
	public static String getStackTrace(Throwable aThrowable) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}
	@SuppressWarnings("serial")
	public class NegocioExcepcion extends BaseException{

		/**
		 * Constructor por defecto
		 * 
		 */	
		public NegocioExcepcion() {
			super();
		}
}
	public void info(String string) {
		// TODO Auto-generated method stub
		
	}
}
