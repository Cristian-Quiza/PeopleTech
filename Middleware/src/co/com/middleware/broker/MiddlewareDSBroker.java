package co.com.middleware.broker;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.com.middleware.cliente.dataservice.ClienteServiciosApolo;
import co.com.middleware.cliente.dataservice.ClienteServiciosDataservice;
import co.com.middleware.dto.ParametrosDTO;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.ServicioWeb;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.constantes.NombresPropertiesConstantes;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.PropiedadesManager;

public class MiddlewareDSBroker {

	private static MiddlewareDSBroker instancia;

	private MiddlewareDSBroker() {

	}

	public static MiddlewareDSBroker getInstancia() {

		if (instancia == null) {
			instancia = new MiddlewareDSBroker();
		}
		return instancia;
	}

	public RespuestaDataService echoTest() throws NegocioExcepcion {

		String endpoint = "";
		String URL = "";
		String respuestaServicio;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();

		try {
			endpoint = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT);

			URL = endpoint + ServicioWebConstantes.ECHO_TEST;
			Log.getInstance().debug("Respuesta : " + URL, getClass());
			clienteServicios = new ClienteServiciosApolo(URL);

			respuestaServicio = clienteServicios.consumirServicioGet();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			Type typeWrapperJSON = new TypeToken<WrapperJSON<RespuestaDataService>>() {
			}.getType();

			WrapperJSON<RespuestaDataService> wrapperJSON = gson
					.fromJson(respuestaServicio.replaceFirst("echoTest", "wrapperJSON"), typeWrapperJSON);

			respuestaDataService = wrapperJSON.getWrapperJSON();

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public List<ServicioWeb> getAllServices(String coreId) throws NegocioExcepcion {

		String endpoint = null;
		String nombreServicio = null;
		String URL = null;
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		List<ServicioWeb> servicioWebs;
		ClienteServiciosDataservice clienteServicios = null;

		try {
			Log.getInstance().info("getAllServices:::", getClass());
			endpoint = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT);

			nombreServicio = ServicioWebConstantes.SERVICIO_WEB_ID;

			URL = endpoint + nombreServicio;

			listaParametros = new LinkedList<Object>();

			listaParametros.add(coreId);

			clienteServicios = new ClienteServiciosDataservice(URL, listaParametros);

			respuestaServicio = clienteServicios.consumirServicio();

			Type typeWrapperJSON = new TypeToken<List<ServicioWeb>>() {
			}.getType();

			servicioWebs = new Gson().fromJson(respuestaServicio.substring(32, respuestaServicio.length() - 2),
					typeWrapperJSON);

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return servicioWebs;
	}

	public RespuestaDataService Login(TransaccionDTO transaccionDTO, String coreId, String serviceId)
			throws NegocioExcepcion {

		String url;
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(coreId, serviceId);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getContrasena());
			listaParametros.add(transaccionDTO.getApp_ingreso());

			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CONTRASENA);
			listaNombresParam.add(ParametrosDTO.APP_INGRESO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			Type typeWrapperJSON = new TypeToken<RespuestaDataService>() {
			}.getType();

			respuestaDataService = gson.fromJson(respuestaServicio, typeWrapperJSON);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService preLogin(TransaccionDTO transaccionDTO, String coreId, String serviceId)
			throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {

			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(coreId, serviceId);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL_Prelogin: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());

			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService TerminosCondiciones(String coreId, String app_ingreso) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		ServicioWeb servicioWeb;
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(coreId,
					ServicioWebConstantes.TERMINOS_CONDICIONES);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(app_ingreso);

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService InvitarPagoTarjeta(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			if (transaccionDTO.getUrlService() == null || transaccionDTO.getUrlService() == "") {
//				servicioWeb = ConfiguracionEnpoint.getServicioById(ServicioWebConstantes.LOGIN, coreId );
//				url = servicioWeb.getURL();
			}

			Log.getInstance().debug("URL: " + transaccionDTO.getUrlService(), getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);

			clienteServicios = new ClienteServiciosApolo(transaccionDTO.getUrlService(), listaParametros,
					listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			Type typeWrapperJSON = new TypeToken<WrapperJSON<List<RespuestaDataService>>>() {
			}.getType();

			WrapperJSON<List<RespuestaDataService>> wrapperJSON = gson
					.fromJson(respuestaServicio.replaceFirst("terminosycondiciones", "wrapperJSON"), typeWrapperJSON);

			List<RespuestaDataService> respuestaRS = wrapperJSON.getWrapperJSON();

			Log.getInstance().debug("respuestaRS" + respuestaRS, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

			Log.getInstance().debug("respuestaRS:::::" + respuestaDataService.getCodigo_respuesta(), getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService consultaCorreo(TransaccionDTO transaccionDTO, String coreOnline, String preLogin)
			throws NegocioExcepcion {
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(coreOnline, preLogin);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());

			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService validaUsuario(TransaccionDTO transaccionDTO, String coreApolo, String validaUsuarioId)
			throws NegocioExcepcion {
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(coreApolo, validaUsuarioId);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(MiddlewareConstantes.APP_INGRESO);

			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.APP_INGRESO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;

	}

}
