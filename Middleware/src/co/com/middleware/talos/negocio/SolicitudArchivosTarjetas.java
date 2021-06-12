package co.com.middleware.talos.negocio;

import com.google.gson.Gson;

import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.dto.BaseRespuesta;
import co.com.middleware.log.Log;
import co.com.middleware.talos.broker.MiddlewareBroker;
import co.com.middlware.excepciones.NegocioExcepcion;

public class SolicitudArchivosTarjetas {
	

	public String procesarCrearSolicitud(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().crearSolicitud(tramaRequest);

			return respuestaRS;

		} catch (NegocioExcepcion e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(e.getCodigoError()), e.getMessage());
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}
	
	public String procesarDatosSolicitud(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().datosSolicitud(tramaRequest);

			return respuestaRS;

		} catch (NegocioExcepcion e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(e.getCodigoError()), e.getMessage());
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}
				
	public String procesarArchivoSolicitud(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().archivoSolicitud(tramaRequest);

			return respuestaRS;

		} catch (NegocioExcepcion e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(e.getCodigoError()), e.getMessage());
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}
	
	public String procesarConsultaTerminosYCondiciones() {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {
			
			respuestaRS = MiddlewareBroker.getInstancia().ConsultaTerminosYCondiciones();
			return respuestaRS;

		} catch (Exception e) {
			Log.getInstance().info("ERROR consultaTerminosYCondiciones: " + e , getClass());
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
			
		}
		return gson.toJson(baseRespuesta);
	}		
	
	public String procesarMatiSolicitud(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().matiSolicitud(tramaRequest);

			return respuestaRS;

		} catch (NegocioExcepcion e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(e.getCodigoError()), e.getMessage());
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}

	public String procesarDatosAdicionales(String tramaRequest) {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().datosAdicionales(tramaRequest);

			return respuestaRS;

		} catch (NegocioExcepcion e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(e.getCodigoError()), e.getMessage());
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}
	

	public String procesarFinalizarMati(String tramaRequest) {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().finalizarMati(tramaRequest);

			return respuestaRS;

		} catch (NegocioExcepcion e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(e.getCodigoError()), e.getMessage());
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}
	
	public String procesarSolicitudes(String tramaRequest) {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().Solicitudes(tramaRequest);

			return respuestaRS;

		} catch (NegocioExcepcion e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(e.getCodigoError()), e.getMessage());
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}

					
}
