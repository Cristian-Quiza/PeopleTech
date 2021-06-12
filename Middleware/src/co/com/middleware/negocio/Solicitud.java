package co.com.middleware.negocio;

import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.broker.SolicitudlDSBroker;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Solicitud {

	public RespuestaDataService procesarInvitarPagoTarjeta(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}		

		respuestaRS = SolicitudlDSBroker.getInstancia().InvitarPagoTarjeta(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarPedirTarjetaPropia(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;

		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	

		respuestaRS = SolicitudlDSBroker.getInstancia().PedirTarjetaPropia(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarPedirTarjetaAmparada(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	

		respuestaRS = SolicitudlDSBroker.getInstancia().PedirTarjetaAmparada(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarConsultaMovimientosProducto(TransaccionDTO transaccionDTO)
			throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	

		respuestaRS = SolicitudlDSBroker.getInstancia().ConsultaMovimientosProducto(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarCrearSoporte(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	

		respuestaRS = SolicitudlDSBroker.getInstancia().CrearSoporte(transaccionDTO);

		return respuestaRS;
	}

}
