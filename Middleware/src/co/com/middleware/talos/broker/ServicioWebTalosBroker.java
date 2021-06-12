package co.com.middleware.talos.broker;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import co.com.middleware.cliente.dataservice.ClienteServiciosDataservice;
import co.com.middleware.constantes.NombresPropertiesConstantes;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middleware.dto.ServicioWeb;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.PropiedadesManager;

public class ServicioWebTalosBroker {
	private static ServicioWebTalosBroker instancia;

	private ServicioWebTalosBroker() {

	}

	public static ServicioWebTalosBroker getInstancia() {
		if (instancia == null) {
			instancia = new ServicioWebTalosBroker();
		}
		return instancia;
	}

	public List<ServicioWeb> getServicioWebById(int coreId) throws NegocioExcepcion {

		String endpoint = null;
		String nombreServicio = null;
		String URL = null;
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		List<ServicioWeb> servicioWebs;
		ClienteServiciosDataservice clienteServicios = null;

		try {
			endpoint = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT);

			nombreServicio = ServicioWebConstantes.SERVICIO_WEB_ID_SERVICE;

			URL = endpoint + nombreServicio;

			listaParametros = new LinkedList<Object>();

			listaParametros.add(coreId);

			clienteServicios = new ClienteServiciosDataservice(URL, listaParametros);

			respuestaServicio = clienteServicios.consumirServicio();

			Type typeWrapperJSON = new TypeToken<List<ServicioWeb>>() {
			}.getType();

			servicioWebs = new Gson().fromJson(respuestaServicio.substring(31, respuestaServicio.length() - 2),
					typeWrapperJSON);

		} catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return servicioWebs;
	}
	
	

}
