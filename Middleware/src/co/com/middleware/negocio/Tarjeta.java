package co.com.middleware.negocio;

import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.broker.TarjetaBroker;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Tarjeta {

	public RespuestaDataService procesarCambiaEstadoTarjetea(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = TarjetaBroker.getInstancia().ActivarTarjeta(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarAsociarTarjetaCorporativa(TransaccionDTO transaccionDTO)
			throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = TarjetaBroker.getInstancia().AsociarTarjetaCorporativa(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarDesasociarTarjetaCorporativa(TransaccionDTO transaccionDTO)
			throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = TarjetaBroker.getInstancia().DesasociarTarjetaCorporativa(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarRecarga(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = TarjetaBroker.getInstancia().Recarga(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarPagarTarjetaWPeople(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
//		RespuestaDataService respuestaDispositivo = null;

//		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
//			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);
//
//			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
//				return respuestaDispositivo;
//			}
//		}
		respuestaRS = TarjetaBroker.getInstancia().PagarTarjetaWPeople(transaccionDTO);

		return respuestaRS;
	}
	
	public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

	public RespuestaDataService procesarGenerarCvv2(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = TarjetaBroker.getInstancia().GenerarCvv2(transaccionDTO);

		return respuestaRS;
	}

}
