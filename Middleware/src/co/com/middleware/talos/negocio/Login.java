package co.com.middleware.talos.negocio;

import com.google.gson.Gson;

import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.dto.BaseRespuesta;
import co.com.middleware.talos.broker.MiddlewareBroker;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Login {
	
	public String procesarLogin(String tramaRequest) {

		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().login(tramaRequest);

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
	
	public String procesarindicadorLogin(String tramaRequest) {
			String respuestaRS = "";
			BaseRespuesta baseRespuesta = null;
			Gson gson = null;

			try {

				respuestaRS = MiddlewareBroker.getInstancia().indicadorLogin(tramaRequest);

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

	public String procesarCreaActuaRespuestaSeguro(String tramaRequest) {
		String respuestaRS = "";
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;

		try {

			respuestaRS = MiddlewareBroker.getInstancia().creaActuaRespuestaSeguro(tramaRequest);

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

