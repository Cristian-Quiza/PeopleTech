package co.com.middlware.utilidades;

import co.com.middleware.constantes.NombresPropertiesConstantes;

public class UtilidadUrlServicio {

	String PROTOCOLO = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_PROTOCOLO);

	String IP = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_IP);

	String PUERTO = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_PUERTO);

	private static UtilidadUrlServicio instancia;

	private UtilidadUrlServicio() {

	}

	public static UtilidadUrlServicio getInstancia() {

		if (instancia == null) {
			instancia = new UtilidadUrlServicio();
		}
		return instancia;
	}

	public String urlServicio(String endPoint) {

		return PROTOCOLO + IP + PUERTO + endPoint;

	}
}
