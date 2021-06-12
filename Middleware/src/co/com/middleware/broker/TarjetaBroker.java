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

public class TarjetaBroker {

	private static TarjetaBroker instancia;

	private TarjetaBroker() {

	}

	public static TarjetaBroker getInstancia() {

		if (instancia == null) {
			instancia = new TarjetaBroker();
		}
		return instancia;
	}

	public RespuestaDataService ActivarTarjeta(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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

			Log.getInstance().debug("URL: " + url + ParametrosDTO.ESTADO_TARJETA, getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getCodigo_tarjeta_zeus());
			listaParametros.add(transaccionDTO.getEstado_tarjeta());
			listaParametros.add(transaccionDTO.getCodigo_tarjeta());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.ID_TARJETA_ZEUS);
			listaNombresParam.add(ParametrosDTO.ESTADO_TARJETA);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService DesasociarTarjetaCorporativa(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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

			Log.getInstance().debug("URL: " + url , getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getCodigo_tarjeta());
			listaParametros.add(transaccionDTO.getIdentificador());
			listaParametros.add(transaccionDTO.getUltimos_digitos());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);
			listaNombresParam.add(ParametrosDTO.IDENTIFICADOR);
			listaNombresParam.add(ParametrosDTO.ULTIMOS_DIGITOS);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return respuestaDataService;
	}
	
	public RespuestaDataService AsociarTarjetaCorporativa(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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

			Log.getInstance().debug("URL: " + url , getClass());

			listaParametros = new LinkedList<Object>();
			listaParametros.add(transaccionDTO.getApp_ingreso());
			listaParametros.add(transaccionDTO.getTipo_documento());
			listaParametros.add(transaccionDTO.getDocumento());
			listaParametros.add(transaccionDTO.getNit_empresa());
			listaParametros.add(transaccionDTO.getIdentificador());
			listaParametros.add(transaccionDTO.getUltimos_digitos());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.NIT_EMPRESA);
			listaNombresParam.add(ParametrosDTO.IDENTIFICADOR);
			listaNombresParam.add(ParametrosDTO.ULTIMOS_DIGITOS);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicio();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch(NegocioExcepcion e) {			
			throw new NegocioExcepcion(e.getCodigoError(),e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService Recarga(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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
			listaParametros.add(transaccionDTO.getMonto());
			listaParametros.add(transaccionDTO.getTipo_pago());
			

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_PRODUCTO);
			listaNombresParam.add(ParametrosDTO.MONTO);
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
	
	public RespuestaDataService PagarTarjetaWPeople(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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
			listaParametros.add(transaccionDTO.getNumero_referencia());

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.TIPO_DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.DOCUMENTO);
			listaNombresParam.add(ParametrosDTO.CODIGO_TARJETA);
			listaNombresParam.add(ParametrosDTO.NUMERO_REFERENCIA);

			clienteServicios = new ClienteServiciosApolo(url, listaParametros, listaNombresParam);

			respuestaServicio = clienteServicios.consumirServicioCobrar();

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

			respuestaDataService = gson.fromJson(respuestaServicio, RespuestaDataService.class);

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaDataService;
	}

	public RespuestaDataService GenerarCvv2(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

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
			listaParametros.add(transaccionDTO.getCodigo_tarjeta_zeus());
			

			listaNombresParam.add(ParametrosDTO.APP_INGRESO);
			listaNombresParam.add(ParametrosDTO.ID_TARJETA_ZEUS);

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
