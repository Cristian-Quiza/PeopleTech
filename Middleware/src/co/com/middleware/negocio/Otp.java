package co.com.middleware.negocio;

import co.com.middleware.broker.OtpBroker;
import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Otp {


	public RespuestaDataService procesarValidarOtp(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = OtpBroker.getInstancia().ValidarOtp(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarGenerarOtp(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = OtpBroker.getInstancia().GenerarOtp(transaccionDTO);

		return respuestaRS;
	}
}
