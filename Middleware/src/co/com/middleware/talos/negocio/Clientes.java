package co.com.middleware.talos.negocio;

import com.google.gson.Gson;

import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.dto.BaseRespuesta;
import co.com.middleware.talos.broker.MiddlewareBroker;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Clientes {
		
		public String procesarCrearTarjetaHabiente(String tramaRequest) {
			
			String respuestaRS = "";
			BaseRespuesta baseRespuesta = null;
			Gson gson = null;

			try {

				respuestaRS = MiddlewareBroker.getInstancia().crearTarjetaHabiente(tramaRequest);

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
	
	
	public String procesarCiudad(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().ciudad(tramaRequest);

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
	
	public String procesarDepartamentos(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().departamentos(tramaRequest);

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
	
	public String procesarPais() {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().pais();

			return respuestaRS;

		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}
	
	public String procesarGenero() {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().genero();

			return respuestaRS;

		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}


	public String procesarValidarOtp(String tramaRequest) {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().validarOtp(tramaRequest);

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


	public String procesarGenerarOtp(String tramaRequest) {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().generarOtp(tramaRequest);

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


	public String procesarPreguntasSeguro() {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().preguntasSeguro();

			return respuestaRS;

		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}


	public String procesarTipoDocumento() {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().tipoDocumento();

			return respuestaRS;

		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}


	public String procesarConsultarProfesion() {
		
		
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().consultarProfesion();

			return respuestaRS;

		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}
		return gson.toJson(baseRespuesta);
	}
	
	
	public String procesarPreguntasBasicasSolicitud(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().preguntasBasicasSolicitud(tramaRequest);

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