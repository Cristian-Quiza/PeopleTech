package co.com.middlware.utilidades;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.dto.ServicioWeb;
import co.com.middlware.excepciones.NegocioExcepcion;


public class ConfiguracionEnpoint {

	static ConcurrentHashMap<Integer, ServicioWeb> mapServicios = new ConcurrentHashMap<Integer, ServicioWeb>();

	public static List<ServicioWeb> getServicioById(int coreId) throws NegocioExcepcion {

		ServicioWebDSBroker broker;
		List<ServicioWeb> servicioWeb;

		try {

			broker = ServicioWebDSBroker.getInstancia();
//			if (mapServicios.containsKey(coreId)) {
//				servicioWeb = mapServicios.get(coreId);
//			} else {				
				servicioWeb = broker.getServicioWebById( coreId);
//				mapServicios.put(servicioWeb.getServicioWebId(), servicioWeb);
//			}
		} catch (Exception e) {
			throw new NegocioExcepcion(e);
		}

		return servicioWeb;
	}

}