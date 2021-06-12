package co.com.middleware.talos.broker;

import java.util.LinkedList;
import java.util.List;
import com.sun.jersey.core.header.FormDataContentDisposition;
import co.com.middleware.constantes.NombresPropertiesConstantes;
import co.com.middleware.dto.ParametrosTalosDTO;
import co.com.middleware.dto.TransaccionTalosDTO;
import co.com.middleware.log.Log;
import co.com.middleware.talos.cliente.ClienteServiciosPost;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.PropiedadesManager;
import co.com.middlware.utilidades.UtilidadUrlServicio;

public class MiddlewareBroker {
	private static MiddlewareBroker instancia;

	private MiddlewareBroker() {
	}

	public static MiddlewareBroker getInstancia() {

		if (instancia == null) {
			instancia = new MiddlewareBroker();
		}
		return instancia;
	}
		
	public String crearTarjetaHabiente(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {
			System.out.println();
			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.CREAR_TARJETA_HABIENTE));

			Log.getInstance().info("URLServicio: " + url, getClass());
			

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}

	public String ciudad(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia()
					.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.CIUDAD));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String departamentos(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.DEPARTAMENTOS));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}

	public String login(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia()
					.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.LOGIN));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}

	public String crearSolicitud(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.CREAR_SOLICITUD));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}

	public String indicadorLogin(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.INDICADOR_LOGIN));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String archivoSolicitud(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.ARCHIVO_SOLICITUD));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String matiSolicitud(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.MATI_SOLICITUD));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String validarOtp(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia()
					.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.VALIDAR_OTP));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String pais() throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		
		url = UtilidadUrlServicio.getInstancia()
				.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.PAIS));

		Log.getInstance().info("URL: " + url, getClass());

		clienteServicios = new ClienteServiciosPost();

		respuestaServicio = clienteServicios.consumirServiceGet(url);

		Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		return respuestaServicio;

	}

	public String generarOtp(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia()
					.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.GENERAR_OTP));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String ConsultaTerminosYCondiciones() throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		
		url = UtilidadUrlServicio.getInstancia().urlServicio(PropiedadesManager.getInstance()
				.getProperty(NombresPropertiesConstantes.CONSULTA_TERMINOS_Y_CONDICIONES));
		
		
		Log.getInstance().info("URL: " + url, getClass());

		clienteServicios = new ClienteServiciosPost();
		
		respuestaServicio = clienteServicios.consumirServicioPOST(url, "");
		
		
		Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		return respuestaServicio;
	}
	

	public String genero() throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		url = UtilidadUrlServicio.getInstancia()
				.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.GENERO));

		Log.getInstance().info("URL: " + url, getClass());

		clienteServicios = new ClienteServiciosPost();

		respuestaServicio = clienteServicios.consumirServiceGet(url);

		Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		return respuestaServicio;

	}

	public String datosSolicitud(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.DATOS_SOLICITUD));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);
												 	
			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String administrador(TransaccionTalosDTO transaccionDTO, FormDataContentDisposition fileMetaData)
			throws NegocioExcepcion {

		String respuestaServicio;
		List<String> listaParametros = new LinkedList<String>();
		TransaccionTalosDTO transaccionTalosDTO = new TransaccionTalosDTO();
		ClienteServiciosPost clienteServicios = null;

		List<String> listaNombresParam = new LinkedList<String>();
		String url;

		try {

			url = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.ADMINISTRADOR);

			Log.getInstance().debug("URL: " + url, getClass());

			listaParametros.add(transaccionDTO.getExtension());
			listaParametros.add(transaccionDTO.getTarjeta_habiente());
			listaParametros.add(transaccionDTO.getUser());
			listaParametros.add(transaccionDTO.getPwd());
			listaParametros.add(transaccionDTO.getPk_solicitud());
			listaParametros.add(transaccionDTO.getTipo_archivo());
			listaNombresParam.add(ParametrosTalosDTO.EXTENSION);
			listaNombresParam.add(ParametrosTalosDTO.TARJETA_HABIENTE);
			listaNombresParam.add(ParametrosTalosDTO.USER);
			listaNombresParam.add(ParametrosTalosDTO.PWD);
			listaNombresParam.add(ParametrosTalosDTO.PK_SOLICITUD);
			listaNombresParam.add(ParametrosTalosDTO.TIPO_ARCHIVO);

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicePostFile(url, listaParametros, listaNombresParam,
					fileMetaData);

			Log.getInstance().debug("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}
	
	public String consultarListas(TransaccionTalosDTO transaccionDTO, String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio;
		List<String> listaParametros = new LinkedList<String>();
		TransaccionTalosDTO transaccionTalosDTO = new TransaccionTalosDTO();
		ClienteServiciosPost clienteServicios = null;

		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		
		try {

			url = (PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.CONSULTAR_LISTAS));

			Log.getInstance().info("URL: " + url, getClass());
			
			listaParametros.add(transaccionDTO.getIdentificacion());
			listaParametros.add(transaccionDTO.getNombre());
			listaParametros.add(transaccionDTO.getTipoid());
			listaNombresParam.add(ParametrosTalosDTO.IDENTIFICACION);
			listaNombresParam.add(ParametrosTalosDTO.NOMBRE);
			listaNombresParam.add(ParametrosTalosDTO.TIPOID);
			
			
			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioArchivo(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}
		return respuestaServicio;
	}

	public String crearArchivos(TransaccionTalosDTO transaccionDTO, String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio;
		List<String> listaParametros = new LinkedList<String>();
		TransaccionTalosDTO transaccionTalosDTO = new TransaccionTalosDTO();
		ClienteServiciosPost clienteServicios = null;

		List<String> listaNombresParam = new LinkedList<String>();
		String url;
		
		try {

			url = (PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.CREAR_ARCHIVOS));

			Log.getInstance().info("URL: " + url, getClass());
			
			listaParametros.add(transaccionDTO.getSolicitud());
			listaParametros.add(transaccionDTO.getIndicador());
			listaNombresParam.add(ParametrosTalosDTO.SOLICITUD);
			listaNombresParam.add(ParametrosTalosDTO.INDICADOR);
			
			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioArchivo(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}
		return respuestaServicio;
	}
	
	public String preguntasSeguro() throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		
		url = UtilidadUrlServicio.getInstancia()
				.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.PREGUNTAS_SEGURO));

		Log.getInstance().info("URL: " + url, getClass());

		clienteServicios = new ClienteServiciosPost();

		respuestaServicio = clienteServicios.consumirServiceGet(url);

		Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		return respuestaServicio;

	}

	public String tipoDocumento() throws NegocioExcepcion  {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		
		url = UtilidadUrlServicio.getInstancia()
				.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.TIPO_DOCUMENTO));

		Log.getInstance().info("URL: " + url, getClass());

		clienteServicios = new ClienteServiciosPost();

		respuestaServicio = clienteServicios.consumirServicioPOST(url, "");

		Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		return respuestaServicio;
	}

	public String creaActuaRespuestaSeguro(String tramaRequest) throws NegocioExcepcion{
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia()
					.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.CREA_ACTUA_RESPUESTA_SEGURO));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}
		
	public String datosAdicionales(String tramaRequest) throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.DATOS_ADICIONALES));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}

	public String consultarProfesion() throws NegocioExcepcion {
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		
		url = UtilidadUrlServicio.getInstancia()
				.urlServicio(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.CONSULTAR_PROFESION));

		Log.getInstance().info(" URL: " + url, getClass());

		clienteServicios = new ClienteServiciosPost();

		respuestaServicio = clienteServicios.consumirServicioPOST(url, "");

		Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		return respuestaServicio;
	}

	public String finalizarMati(String tramaRequest) throws NegocioExcepcion{
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.FINALIZAR_MATI));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}

	public String preguntasBasicasSolicitud(String tramaRequest) throws NegocioExcepcion{
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.PREGUNTAS_BASICAS_SOLICITUD));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;

	}

	public String Solicitudes(String tramaRequest) throws NegocioExcepcion{
		String respuestaServicio = "";
		ClienteServiciosPost clienteServicios = null;
		String url;
		try {

			url = UtilidadUrlServicio.getInstancia().urlServicio(
					PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SOLICITUDES));

			Log.getInstance().info("URL: " + url, getClass());

			clienteServicios = new ClienteServiciosPost();

			respuestaServicio = clienteServicios.consumirServicioPOST(url, tramaRequest);

			Log.getInstance().info("Respuesta : " + respuestaServicio, getClass());

		} catch (NegocioExcepcion e) {
			throw new NegocioExcepcion(e.getCodigoError(), e.getMessage());
		}

		return respuestaServicio;
	}

}
