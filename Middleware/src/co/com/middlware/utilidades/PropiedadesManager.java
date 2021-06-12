package co.com.middlware.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropiedadesManager {

	private static PropiedadesManager INSTANCE = null;
	private Properties properties;
	
	private static final String ARCHIVO_PROPIEDADES = "/var/lib/tomcat/bin/configuracion/propiedadesMiddleware.properties";
	
	private PropiedadesManager(){
		
		cargarArchivo(ARCHIVO_PROPIEDADES);
	}
	
	private static void createInstance() {
        synchronized(PropiedadesManager.class) {
            if (INSTANCE == null) { 
                INSTANCE = new PropiedadesManager();
            }
        }
    }
	
	public static PropiedadesManager getInstance() {
        if (INSTANCE == null) {
        	createInstance();
        }
        return INSTANCE;
    }

	public String getProperty(String key){

		return properties.getProperty(key);
	}
	
	private void cargarArchivo(String archivo){
		File file;
		InputStream inputStream = null;
		try {
			properties = new Properties();
			file = new File(archivo);
			inputStream = new FileInputStream(file);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					
				}
			}
		}
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo properties
	 * 
	 * @return properties Valor del atributo
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * Metodo encargado de asignar el valor del atributo properties
	 * 
	 * @param properties
	 *            Valor a asignar al atributo properties
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
}
