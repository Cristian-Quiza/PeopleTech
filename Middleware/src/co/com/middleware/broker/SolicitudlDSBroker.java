package co.com.middleware.broker;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import co.com.middleware.cliente.dataservice.ClienteServiciosApolo;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middleware.dto.ParametrosDTO;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.ServicioWeb;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middlware.excepciones.NegocioExcepcion;

public class SolicitudlDSBroker {

	private static SolicitudlDSBroker instancia;

	private SolicitudlDSBroker() {

	}

	public static SolicitudlDSBroker getInstancia() {

		if (instancia == null) {
			instancia = new SolicitudlDSBroker();
		}
		return instancia;
	}

	public RespuestaDataService InvitarPagoTarjeta(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		ServicioWeb servicioWeb;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			servicioWeb = ServicioWebDSBroker.getInstancia().getServicioWebByIdByCore(transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

			url = servicioWeb.getURL();

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getPrimer_apellido());
			listaParametros.add(transaccionDTO.getPrimer_nombre());
			listaParametros.add(transaccionDTO.getDireccion_invitado());
			listaParametros.add(transaccionDTO.getCorreo_invitado());
			listaParametros.add(transaccionDTO.getNumero_celular());
			listaParametros.add(transaccionDTO.getCodigo_producto());
			listaParametros.add(transaccionDTO.getTipo_documento_invitado());
			listaParametros.add(transaccionDTO.getDocumento_invitado());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.PRIMER_APELLIDO);
			listaNombresParam.add(ParametrosDTO.PRIMER_NOMBRE);
			listaNombresParam.add(ParametrosDTO.DIRECCION_INVITADO);
			listaNombresParam.add(ParametrosDTO.CORREO_INVITADO);
			listaNombresParam.add(ParametrosDTO.CELULAR_INVITADO);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO_INVITADO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO_INVITADO);
			
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

	public RespuestaDataService ConsultaMovimientosProducto(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
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
			listaParametros.add(transaccionDTO.getCodigo_tarjeta());
			listaParametros.add(transaccionDTO.getTipo_transaccion_id());
			listaParametros.add(transaccionDTO.getFecha_inicio());
			listaParametros.add(transaccionDTO.getFecha_fin());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);
			listaNombresParam.add(ParametrosDTO.TIPO_TRANSACCION);
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

	public RespuestaDataService PedirTarjetaPropia(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
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
			listaParametros.add(transaccionDTO.getCodigo_producto());
			listaParametros.add(transaccionDTO.getTipo_pago());
			

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);
			listaNombresParam.add(ParametrosDTO.TIPO_PAGO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService PedirTarjetaAmparada(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
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
			listaParametros.add(transaccionDTO.getCodigo_producto());
			listaParametros.add(transaccionDTO.getFecha_nacimiento());
			listaParametros.add(transaccionDTO.getFecha_expedicion());
			listaParametros.add(transaccionDTO.getParentesco_id());
			listaParametros.add(transaccionDTO.getPrimer_apellido());
			listaParametros.add(transaccionDTO.getPrimer_nombre());
			listaParametros.add(transaccionDTO.getTipo_documento_amp());
			listaParametros.add(transaccionDTO.getDocumento_amp());
			listaParametros.add(transaccionDTO.getCiudad_id());
			listaParametros.add(transaccionDTO.getCorreo_electronico());
			listaParametros.add(transaccionDTO.getNumero_celular());
			listaParametros.add(transaccionDTO.getDireccion());
			listaParametros.add(transaccionDTO.getTipo_pago());
			

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);
			listaNombresParam.add(ParametrosDTO.FECHA_NACIMIENTO);
			listaNombresParam.add(ParametrosDTO.FECHA_EXPEDICION);
			listaNombresParam.add(ParametrosDTO.PARENTESCO);
			listaNombresParam.add(ParametrosDTO.PRIMER_APELLIDO);
			listaNombresParam.add(ParametrosDTO.PRIMER_NOMBRE);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO_AMP);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO_AMP);
			listaNombresParam.add(ParametrosDTO.ID_CIUDAD);
			listaNombresParam.add(ParametrosDTO.CORREO_ELECTRONICO);
			listaNombresParam.add(ParametrosDTO.NUMERO_CELULAR);
			listaNombresParam.add(ParametrosDTO.DIRECCION);
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


	public RespuestaDataService CrearSoporte(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		String respuestaServicio;
		String url;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
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
			listaParametros.add(transaccionDTO.getNumero_celular());
			listaParametros.add(transaccionDTO.getCorreo_electronico());
			listaParametros.add(transaccionDTO.getAsunto());
			listaParametros.add(transaccionDTO.getMensaje());
			listaParametros.add(transaccionDTO.getSoporte());
			
			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.NUMERO_CELULAR);
			listaNombresParam.add(ParametrosDTO.CORREO_ELECTRONICO);
			listaNombresParam.add(ParametrosDTO.ASUNTO);
			listaNombresParam.add(ParametrosDTO.MENSAJE);
			listaNombresParam.add(ParametrosDTO.SOPORTE);
			
			
						
			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicioPOST(url);

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}


}