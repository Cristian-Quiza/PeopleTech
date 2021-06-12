package co.com.middleware.negocio;

import co.com.middleware.broker.ConsultaBroker;
import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Consulta {

	public RespuestaDataService procesarPais(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;

		respuestaRS = ConsultaBroker.getInstancia().ConsultaPaises(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarConsultaDepartamentos(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;

		respuestaRS = ConsultaBroker.getInstancia().ConsultaDepartamentos(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarConsultaCiudades(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;

		respuestaRS = ConsultaBroker.getInstancia().ConsultaCiudades(transaccionDTO);

		return respuestaRS;
	}
	
	public RespuestaDataService procesarConsultaPublicidad(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;

		respuestaRS = ConsultaBroker.getInstancia().ConsultaPublicidad(transaccionDTO);

		return respuestaRS;
	}
	
	public RespuestaDataService procesarAgregadoMovimientos(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = ConsultaBroker.getInstancia().ConsultaAgregadoMovimientos(transaccionDTO);

		return respuestaRS;
	}
	
	public RespuestaDataService procesarConsultaAmparadas(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = ConsultaBroker.getInstancia().ConsultaAmparadas(transaccionDTO);

		return respuestaRS;
	}
	
	public RespuestaDataService procesaConsultaVersion(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;

		respuestaRS = ConsultaBroker.getInstancia().ConsultaVersion(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesaConsultaCostos(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;

		respuestaRS = ConsultaBroker.getInstancia().ConsultaCostos(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesaPagarTarjetaInvitado(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = ConsultaBroker.getInstancia().PagarTarjetaInvitado(transaccionDTO);

		return respuestaRS;
	}
}
