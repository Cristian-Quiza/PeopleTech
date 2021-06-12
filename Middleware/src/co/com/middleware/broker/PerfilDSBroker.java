package co.com.middleware.broker;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.google.gson.Gson;

import co.com.middleware.cliente.dataservice.ClienteServiciosApolo;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middleware.dto.ParametrosDTO;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.ServicioWeb;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middlware.excepciones.NegocioExcepcion;

public class PerfilDSBroker {
	private static PerfilDSBroker instancia;

	private PerfilDSBroker() {

	}

	public static PerfilDSBroker getInstancia() {

		if (instancia == null) {
			instancia = new PerfilDSBroker();
		}
		return instancia;
	}

	public RespuestaDataService ConsultaProductosTH(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

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

	public RespuestaDataService ActualizarContacto(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getCelular_anterior());
			listaParametros.add(transaccionDTO.getCelular_nuevo());
			listaParametros.add(transaccionDTO.getCiudad_id());
			listaParametros.add(transaccionDTO.getDireccion_anterior());
			listaParametros.add(transaccionDTO.getDireccion_nueva());
//			listaParametros.add(transaccionDTO.getActualizaPortal());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CELULAR_ANTERIOR);
			listaNombresParam.add(ParametrosDTO.CELULAR_NUEVO);
			listaNombresParam.add(ParametrosDTO.ID_CIUDAD);
			listaNombresParam.add(ParametrosDTO.DIRECCION_ANTERIOR);
			listaNombresParam.add(ParametrosDTO.DIRECCION_NUEVA);
//			listaNombresParam.add(ParametrosDTO.ACTUALIZA_PORTAL);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService RecuperarContrasena(String app_ingreso, String core_id, String service_id,
			String tipo_documento, String documento, String email) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(core_id, service_id);

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(app_ingreso);
			listaParametros.add(tipo_documento);
			listaParametros.add(documento);
			listaParametros.add(core_id);

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CORE_ID);

			if (email != null || email != "") {
				listaParametros.add(email);
				listaNombresParam.add(ParametrosDTO.EMAIL);
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

	public RespuestaDataService CambioContrasena(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getNueva_contrasena());
			listaParametros.add(transaccionDTO.getConfirmar_contrasena());
			listaParametros.add(transaccionDTO.getContrasena_actual());
			listaParametros.add(transaccionDTO.getIp_actualizacion());
			listaParametros.add(transaccionDTO.getActualizar_portal());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.NUEVA_CONTRASENA);
			listaNombresParam.add(ParametrosDTO.CONFIRMAR_CONTRASENA);
			listaNombresParam.add(ParametrosDTO.CONTRASENA_ACTUAL);
			listaNombresParam.add(ParametrosDTO.IP_ACTUALIZACION);
			listaNombresParam.add(ParametrosDTO.ACTUALIZA_PORTAL);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService RegistrarUsario(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getPrimer_nombre());
			listaParametros.add(transaccionDTO.getPrimer_apellido());
			listaParametros.add(transaccionDTO.getFecha_expedicion());
			listaParametros.add(transaccionDTO.getFecha_nacimiento());
			listaParametros.add(transaccionDTO.getNumero_celular());
			listaParametros.add(transaccionDTO.getCorreo_electronico());
			listaParametros.add(transaccionDTO.getCiudad_id());
			listaParametros.add(transaccionDTO.getDireccion());
			listaParametros.add(transaccionDTO.getContrasena());
			listaParametros.add(transaccionDTO.getTerminos());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.PRIMER_NOMBRE);
			listaNombresParam.add(ParametrosDTO.PRIMER_APELLIDO);
			listaNombresParam.add(ParametrosDTO.FECHA_EXPEDICION);
			listaNombresParam.add(ParametrosDTO.FECHA_NACIMIENTO);
			listaNombresParam.add(ParametrosDTO.NUMERO_CELULAR);
			listaNombresParam.add(ParametrosDTO.CORREO_ELECTRONICO);
			listaNombresParam.add(ParametrosDTO.ID_CIUDAD);
			listaNombresParam.add(ParametrosDTO.DIRECCION);
			listaNombresParam.add(ParametrosDTO.CONTRASENA);
			listaNombresParam.add(ParametrosDTO.TERMINOS);

			if (transaccionDTO.getActualizar_portal() != null) {
				listaParametros.add(transaccionDTO.getActualizar_portal());
				listaNombresParam.add(ParametrosDTO.ACTUALIZA_PORTAL);
			}
			if (transaccionDTO.getSegundo_apellido() != null) {
				listaParametros.add(transaccionDTO.getSegundo_apellido());
				listaNombresParam.add(ParametrosDTO.SEGUNDO_APELLIDO);

			}
			if (transaccionDTO.getSegundo_nombre() != null) {
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

	public RespuestaDataService ValidarClaveTranx(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getClave());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CLAVE);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService CrearClaveTranx(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getContrasena());
			listaParametros.add(transaccionDTO.getClave());
			listaParametros.add(transaccionDTO.getConfirmar_clave());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CONTRASENA);
			listaNombresParam.add(ParametrosDTO.CLAVE);
			listaNombresParam.add(ParametrosDTO.CONFIRMAR_CLAVE);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService TarjetasInscritas(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

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

	public RespuestaDataService InscribirTarjetas(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url + transaccionDTO.getDocumento_inscrito(), getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getUltimos_digitos());
			listaParametros.add(transaccionDTO.getNombre_completo());
			listaParametros.add(transaccionDTO.getTipo_documento_inscrito());
			listaParametros.add(transaccionDTO.getDocumento_inscrito());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.ULTIMOS_DIGITOS);
			listaNombresParam.add(ParametrosDTO.NOMBRE_COMPLETO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO_INSCRITO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO_INSCRITO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ConsultaNotificaciones(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

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

	public RespuestaDataService ActualizaNotificacion(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getNotificacion_numero());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.NUMERO_NOTIFICACION);

			if (transaccionDTO.getEliminar() != "") {
				listaParametros.add(transaccionDTO.getEliminar());
				listaNombresParam.add(ParametrosDTO.ELIMINAR);
			}

			if (transaccionDTO.getVisto() != "") {
				listaParametros.add(transaccionDTO.getVisto());
				listaNombresParam.add(ParametrosDTO.VISTO);
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

	public RespuestaDataService IconoPerfil(TransaccionDTO transaccionDTO, String imagen) throws NegocioExcepcion {

		String respuestaServicio;
		List<String> listaParametros = new LinkedList<String>();
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;

		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(ServicioWebConstantes.CORE_APOLO,
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(URLEncoder.encode(imagen));
			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.IMAGEN);

			clienteServicios = new ClienteServiciosApolo(listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicioPOST(url);

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ValidaTitularidad(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getUltimos_digitos());
			listaParametros.add(transaccionDTO.getCodigo_producto());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.ULTIMOS_DIGITOS);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);

			if (transaccionDTO.getEliminar() != "") {
				listaParametros.add(transaccionDTO.getEliminar());
				listaNombresParam.add(ParametrosDTO.ELIMINAR);
			}

			if (transaccionDTO.getVisto() != "") {
				listaParametros.add(transaccionDTO.getVisto());
				listaNombresParam.add(ParametrosDTO.VISTO);
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

	public RespuestaDataService OmitirActualizacion(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		ServicioWeb servicioWeb;
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

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

}