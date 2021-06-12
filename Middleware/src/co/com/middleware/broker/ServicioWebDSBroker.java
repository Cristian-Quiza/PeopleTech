package co.com.middleware.broker;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.com.middleware.cliente.dataservice.ClienteServiciosDataservice;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.ServicioWeb;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middleware.constantes.NombresPropertiesConstantes;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.PropiedadesManager;

public class ServicioWebDSBroker {

	private static ServicioWebDSBroker instancia;

	private ServicioWebDSBroker() {

	}

	public static ServicioWebDSBroker getInstancia() {
		if (instancia == null) {
			instancia = new ServicioWebDSBroker();
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

	public ServicioWeb getServicioWebByIdByCore(String coreId, String idService) throws NegocioExcepcion {

		String endpoint = null;
		String nombreServicio = null;
		String URL = null;
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		ServicioWeb servicioWeb;
		ClienteServiciosDataservice clienteServicios = null;
		Gson gson = new Gson();

		try {
			endpoint = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT);
			Log.getInstance().debug("endpoint: " + endpoint, getClass());
			nombreServicio = ServicioWebConstantes.SERVICIO_WEB_ID_SERVICE;
			Log.getInstance().debug("nombreServicio: " + nombreServicio, getClass());
			URL = endpoint + nombreServicio;

			listaParametros = new LinkedList<Object>();

			listaParametros.add(coreId);
			listaParametros.add(idService);

			clienteServicios = new ClienteServiciosDataservice(URL, listaParametros);

			respuestaServicio = clienteServicios.consumirServicio();

			Type typeWrapperJSON = new TypeToken<WrapperJSON<ServicioWeb>>() {}.getType();
			
			WrapperJSON<ServicioWeb> wrapperJSON = gson
					.fromJson(respuestaServicio.replaceFirst("servicioWeb", "wrapperJSON"), typeWrapperJSON);

			servicioWeb = wrapperJSON.getWrapperJSON();

		}catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return servicioWeb;
	}

	
	public RespuestaDataService creaDispositivo(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String endpoint = null;
		String nombreServicio = null;
		String URL = null;
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = null;
		ClienteServiciosDataservice clienteServicios = null;
		Gson gson = new Gson();

		try {
			endpoint = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT);
			
			nombreServicio = ServicioWebConstantes.CREA_DISPOSITIVO;
			
			URL = endpoint + nombreServicio;

			listaParametros = new LinkedList<Object>();

			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getGuid());
			listaParametros.add(transaccionDTO.getPlataforma());
			listaParametros.add(transaccionDTO.getModelo());
			
			clienteServicios = new ClienteServiciosDataservice(URL, listaParametros);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			Type typeWrapperJSON = new TypeToken<WrapperJSON<RespuestaDataService>>() {
			}.getType();

			WrapperJSON<RespuestaDataService> wrapperJSON = gson
					.fromJson(respuestaServicio.replaceFirst("creaDispositivo", "wrapperJSON"), typeWrapperJSON);

			respuestaDataService = wrapperJSON.getWrapperJSON();
			
			Log.getInstance().debug("::::::Respuesta:::: " + respuestaDataService.getCodigo_respuesta(), getClass());

		}catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return respuestaDataService;
	}
	
	public RespuestaDataService validaDispositivo(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String endpoint = null;
		String nombreServicio = null;
		String URL = null;
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = null;
		ClienteServiciosDataservice clienteServicios = null;
		Gson gson = new Gson();

		try {
			endpoint = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT);
			
			nombreServicio = ServicioWebConstantes.VALIDA_DISPOSITIVO;
			
			URL = endpoint + nombreServicio;

			listaParametros = new LinkedList<Object>();

			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getGuid());
			
			clienteServicios = new ClienteServiciosDataservice(URL, listaParametros);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			Type typeWrapperJSON = new TypeToken<WrapperJSON<RespuestaDataService>>() {
			}.getType();

			WrapperJSON<RespuestaDataService> wrapperJSON = gson
					.fromJson(respuestaServicio.replaceFirst("dispositivo", "wrapperJSON"), typeWrapperJSON);

			respuestaDataService = wrapperJSON.getWrapperJSON();
			
			
		}catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return respuestaDataService;
	}
}