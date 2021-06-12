package co.com.middleware.broker;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import co.com.middleware.cliente.dataservice.ClienteServiciosApolo;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.ParametrosDTO;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.ServicioWeb;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middlware.excepciones.NegocioExcepcion;

public class ConsultaBroker {

	private static ConsultaBroker instancia;

	private ConsultaBroker() {

	}

	public static ConsultaBroker getInstancia() {

		if (instancia == null) {
			instancia = new ConsultaBroker();
		}
		return instancia;
	}

	public RespuestaDataService ConsultaPaises(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		ServicioWeb servicioWeb;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					ServicioWebConstantes.PAIS);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			if (transaccionDTO.getCore_id().equals(ServicioWebConstantes.CORE_APOLO)) {
				listaParametros.add(MiddlewareConstantes.APP_INGRESO);
				listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			}

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ConsultaDepartamentos(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		ServicioWeb servicioWeb;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					ServicioWebConstantes.DEPARTAMENTO);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getPais_id());

			listaNombresParam.add(ParametrosDTO.PAIS_ID);

			if (transaccionDTO.getCore_id().equals(ServicioWebConstantes.CORE_APOLO)) {
				listaParametros.add(MiddlewareConstantes.APP_INGRESO);
				listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			}

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ConsultaCiudades(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		ServicioWeb servicioWeb;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					ServicioWebConstantes.CIUDAD);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getDepartamento_id());

			listaNombresParam.add(ParametrosDTO.DEPARTAMENTO_ID);

			if (transaccionDTO.getCore_id().equals(ServicioWebConstantes.CORE_APOLO)) {
				listaParametros.add(MiddlewareConstantes.APP_INGRESO);
				listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			}

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ConsultaPublicidad(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		ServicioWeb servicioWeb;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicioHttps(url);

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);
			
			respuestaDataService.setMensaje_respuesta("Consumo correcto");
			respuestaDataService.setCodigo_respuesta("1");

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ConsultaAgregadoMovimientos(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(), transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getCodigo_tarjeta());
			listaParametros.add(transaccionDTO.getFecha_inicio());
			listaParametros.add(transaccionDTO.getFecha_fin());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);
			listaNombresParam.add(ParametrosDTO.FECHA_INICIO);
			listaNombresParam.add(ParametrosDTO.FECHA_FIN);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);
			

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}
	
	public RespuestaDataService ConsultaAmparadas(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(), transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
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
	
	public RespuestaDataService ConsultaVersion(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO, ServicioWebConstantes.CONSULTA_VERSION_ID);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(MiddlewareConstantes.APP_INGRESO);
			listaParametros.add(transaccionDTO.getCodigo_app());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.CODIGO_APP);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);
			

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ConsultaCostos(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO, transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
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

	public RespuestaDataService PagarTarjetaInvitado(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO, transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getPrimer_apellido());
			listaParametros.add(transaccionDTO.getPrimer_nombre());
			listaParametros.add(transaccionDTO.getCorreo_invitado());
			listaParametros.add(transaccionDTO.getNumero_celular());
			listaParametros.add(transaccionDTO.getCodigo_producto());
			listaParametros.add(transaccionDTO.getTipo_documento_invitado());
			listaParametros.add(transaccionDTO.getDocumento_invitado());
			listaParametros.add(transaccionDTO.getDireccion_invitado());
			listaParametros.add(transaccionDTO.getTipo_pago());
			
			

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.PRIMER_APELLIDO);
			listaNombresParam.add(ParametrosDTO.PRIMER_NOMBRE);
			listaNombresParam.add(ParametrosDTO.CORREO_INVITADO);
			listaNombresParam.add(ParametrosDTO.CELULAR_INVITADO);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO_INVITADO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO_INVITADO);
			listaNombresParam.add(ParametrosDTO.DIRECCION_INVITADO);
			listaNombresParam.add(ParametrosDTO.TIPO_PAGO);
			
			
			if(transaccionDTO.getSegundo_apellido() != null) {
				listaParametros.add(transaccionDTO.getSegundo_apellido());
				listaNombresParam.add(ParametrosDTO.SEGUNDO_APELLIDO);
				
			}
			if(transaccionDTO.getSegundo_nombre() !=null) {
				listaParametros.add(transaccionDTO.getSegundo_nombre());
				listaNombresParam.add(ParametrosDTO.SEGUNDO_NOMBRE);	
			}
			

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