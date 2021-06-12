package co.com.middleware.broker;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.com.middleware.cliente.dataservice.ClienteServiciosApolo;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middleware.dto.ParametrosDTO;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.ServicioWeb;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middlware.excepciones.NegocioExcepcion;

public class TransferenciaDSBroker {
	
	private static TransferenciaDSBroker instancia;

	private TransferenciaDSBroker() {

	}

	public static TransferenciaDSBroker getInstancia() {
		
		if (instancia == null) {
			instancia = new TransferenciaDSBroker();
		}
		return instancia;
	}
	
	
	public RespuestaDataService TerminosCondiciones(String url, String coreId, String app_ingreso) throws NegocioExcepcion {

		
		String respuestaServicio;
		LinkedList<Object> listaParametros = null;
		RespuestaDataService respuestaDataService = new RespuestaDataService();
		ClienteServiciosApolo clienteServicios = null;
		Gson gson = new Gson();
		List<String> listaNombresParam = new LinkedList<String>();
		try {
			if(url == null || url == "") {
//				servicioWeb = ConfiguracionEnpoint.getServicioById(ServicioWebConstantes.LOGIN, coreId );
//				url = servicioWeb.getURL();
			}
			
			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(app_ingreso);
			
			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			
			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);
			
			respuestaServicio = clienteServicios.consumirServicio();
			
			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());
			
			Type typeWrapperJSON = new TypeToken<WrapperJSON<List<RespuestaDataService>>>() {	}.getType();
			
			WrapperJSON<List<RespuestaDataService>> wrapperJSON = gson
					.fromJson(respuestaServicio.replaceFirst("terminosycondiciones", "wrapperJSON"), typeWrapperJSON);

			List<RespuestaDataService> respuestaRS = wrapperJSON.getWrapperJSON();
			
			Log.getInstance().debug("respuestaRS" + respuestaRS, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio,	RespuestaDataService.class);
			
		} catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
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
			if(transaccionDTO.getUrlService() == null || transaccionDTO.getUrlService() == "") {
//				servicioWeb = ConfiguracionEnpoint.getServicioById(ServicioWebConstantes.LOGIN, coreId );
//				url = servicioWeb.getURL();
			}
			
			Log.getInstance().debug("URL: " + transaccionDTO.getUrlService(), getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			
			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			
			clienteServicios = new ClienteServiciosApolo(transaccionDTO.getUrlService(), listaParametros, listaNombresParam);
			
			respuestaServicio = clienteServicios.consumirServicio();
			
			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());
			
			Type typeWrapperJSON = new TypeToken<WrapperJSON<List<RespuestaDataService>>>() {	}.getType();
			
			WrapperJSON<List<RespuestaDataService>> wrapperJSON = gson
					.fromJson(respuestaServicio.replaceFirst("terminosycondiciones", "wrapperJSON"), typeWrapperJSON);

			List<RespuestaDataService> respuestaRS = wrapperJSON.getWrapperJSON();
			
			Log.getInstance().debug("respuestaRS" + respuestaRS, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio,	RespuestaDataService.class);
			
		} catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return respuestaDataService;
	}
	
	public RespuestaDataService EliminarCuentaTranf(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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
			listaParametros.add(transaccionDTO.getCodigo_tarjeta());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}
	
	public RespuestaDataService Transferencia(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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
			listaParametros.add(transaccionDTO.getCodigo_tarjeta_origen());
			listaParametros.add(transaccionDTO.getCodigo_tarjeta_destino());
			listaParametros.add(transaccionDTO.getMonto());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA_ORIGEN);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA_DESTINO);
			listaNombresParam.add(ParametrosDTO.MONTO);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}
	
	public RespuestaDataService ConfiguracionEcommerce(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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
			listaParametros.add(transaccionDTO.getCodigo_tarjeta_zeus());
			listaParametros.add(transaccionDTO.getMonto());
			listaParametros.add(transaccionDTO.getFecha_inicio());
			listaParametros.add(transaccionDTO.getFecha_fin());
			listaParametros.add(transaccionDTO.getCodigo_producto());
			listaParametros.add(transaccionDTO.getCantidad_compras());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);
			listaNombresParam.add(ParametrosDTO.ID_TARJETA_ZEUS);
			listaNombresParam.add(ParametrosDTO.MONTO);
			listaNombresParam.add(ParametrosDTO.FECHA_INICIO);
			listaNombresParam.add(ParametrosDTO.FECHA_FIN);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);
			listaNombresParam.add(ParametrosDTO.CANTIDAD_COMPRAS);
			

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService ActivarEcommerce(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
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
		
			listaParametros.add(transaccionDTO.getEstado_ecommerce());
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getCodigo_tarjeta());
			listaParametros.add(transaccionDTO.getCodigo_tarjeta_zeus());
			listaParametros.add(transaccionDTO.getMonto());
			listaParametros.add(transaccionDTO.getCodigo_producto());
			listaParametros.add(transaccionDTO.getCantidad_compras());
			
			listaNombresParam.add(ParametrosDTO.ESTADO_ECOMMERCE);
			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);
			listaNombresParam.add(ParametrosDTO.ID_TARJETA_ZEUS);
			listaNombresParam.add(ParametrosDTO.MONTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);
			listaNombresParam.add(ParametrosDTO.CANTIDAD_COMPRAS);
			
			

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			Log.getInstance().error("NegocioExcepcion : " + e, getClass());
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}
}