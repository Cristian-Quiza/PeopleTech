package co.com.middleware.negocio;

import co.com.middleware.broker.LlaveMaestraDSBroker;
import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middlware.excepciones.NegocioExcepcion;

public class LlaveMaestra {
	
	public RespuestaDataService procesarConsultaEstadoLlaveM(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	
		respuestaRS =  LlaveMaestraDSBroker.getInstancia().ConsultaEstadoLlaveM(transaccionDTO);

		return respuestaRS;
	}
	
	public RespuestaDataService procesarConsultaAbonosLlaveMaestra(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	
		respuestaRS =  LlaveMaestraDSBroker.getInstancia().ConsultaAbonosLlaveMaestra(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarLegalizarAbono(TransaccionDTO transaccionDTO, String img) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	
		respuestaRS =  LlaveMaestraDSBroker.getInstancia().LegalizarAbono(transaccionDTO, img);

		return respuestaRS;
	}

	public RespuestaDataService procesarMovimientosTarjetaLlaveMaestra(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	
		respuestaRS =  LlaveMaestraDSBroker.getInstancia().MovimientosTarjetaLlaveMaestra(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarrReversoLLaveMaestra(TransaccionDTO transaccionDTO)  throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}	
		respuestaRS =  LlaveMaestraDSBroker.getInstancia().ReversoLLaveMaestra(transaccionDTO);

		return respuestaRS;
	}

}
