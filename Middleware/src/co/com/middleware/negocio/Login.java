package co.com.middleware.negocio;

import java.util.List;

import co.com.middleware.broker.MiddlewareDSBroker;
import co.com.middleware.broker.PerfilDSBroker;
import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.ServicioWeb;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Login {

	public RespuestaDataService procesarLogin(TransaccionDTO transaccionDTO) {

		RespuestaDataService respuestaLogin = new RespuestaDataService();
		RespuestaDataService respuestaDispositivo = null;
		List<ServicioWeb> services;
		try {

			if (transaccionDTO.getCore_id() == null || transaccionDTO.getService_id() == null) {
				/* Prelogin Apolo */
				services = MiddlewareDSBroker.getInstancia().getAllServices(ServicioWebConstantes.CORE_APOLO);

//				respuestaLogin = MiddlewareDSBroker.getInstancia().preLogin(transaccionDTO,
//						ServicioWebConstantes.CORE_APOLO, ServicioWebConstantes.PRE_LOGIN);
//
//				if (!respuestaLogin.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {									
//
//					return respuestaLogin;
//
//				}

				respuestaLogin = MiddlewareDSBroker.getInstancia().Login(transaccionDTO,
						ServicioWebConstantes.CORE_APOLO, ServicioWebConstantes.LOGIN);

				if (respuestaLogin.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
					respuestaLogin.setServicios_web(services);
				}

				if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
					respuestaDispositivo = ServicioWebDSBroker.getInstancia().creaDispositivo(transaccionDTO);
					if (respuestaDispositivo != null) {
						respuestaLogin.setActualizaDispositivo(respuestaDispositivo.getCodigo_respuesta());
					}
				}

				return respuestaLogin;
			}

			respuestaLogin = MiddlewareDSBroker.getInstancia().Login(transaccionDTO, transaccionDTO.getCore_id(),
					transaccionDTO.getService_id());

		} catch (NegocioExcepcion e) {
//			Log.getInstance().info("exception:::"+e.getStackTrace()[0].getLineNumber(), getClass());
			Log.getInstance().error("Codigo:::" + e.getCodigoError() + "mensaje:::" + e.getMessage(), getClass());
			respuestaLogin.setCodigo_respuesta(e.getCodigoError());
			respuestaLogin.setMensaje_respuesta(e.getMessage());

		} catch (Exception e) {
			Log.getInstance().info("exception2:::" + e.getStackTrace()[0].getLineNumber(), getClass());
			respuestaLogin.setCodigo_respuesta(MensajesErrorConstantes.CODIGO_ERROR_GENERAL);
			respuestaLogin.setMensaje_respuesta(MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}

		return respuestaLogin;
	}

	public RespuestaDataService procesarValidaTitularidad(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().ValidaTitularidad(transaccionDTO);

		return respuestaRS;
	}


}
