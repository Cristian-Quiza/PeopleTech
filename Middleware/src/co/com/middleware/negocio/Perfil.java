package co.com.middleware.negocio;

import co.com.middleware.broker.MiddlewareDSBroker;
import co.com.middleware.broker.PerfilDSBroker;
import co.com.middleware.broker.ServicioWebDSBroker;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.dto.TransaccionTalosDTO;
import co.com.middleware.log.Log;
import co.com.middleware.talos.negocio.PostArchivo;
import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.constantes.ServicioWebConstantes;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Perfil {

	public RespuestaDataService procesarRegistrarUsuario(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;

		respuestaRS = PerfilDSBroker.getInstancia().RegistrarUsario(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarTerminosCondiciones(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;

		respuestaRS = MiddlewareDSBroker.getInstancia().TerminosCondiciones(transaccionDTO.getCore_id(),
				transaccionDTO.getApp_ingreso());

		return respuestaRS;
	}

	public RespuestaDataService procesarConsultaProductosTH(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().ConsultaProductosTH(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarActualizarContacto(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().ActualizarContacto(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarRecuperarContrasena(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
//
//		respuestaRS = MiddlewareDSBroker.getInstancia().preLogin(transaccionDTO, ServicioWebConstantes.CORE_APOLO,
//				ServicioWebConstantes.PRE_LOGIN);
//
//		if (respuestaRS.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {

			respuestaRS = MiddlewareDSBroker.getInstancia().consultaCorreo(transaccionDTO,
					ServicioWebConstantes.CORE_APOLO, ServicioWebConstantes.CONSULTA_CORREO);

			if (respuestaRS.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {

				respuestaRS = PerfilDSBroker.getInstancia().RecuperarContrasena(transaccionDTO.getApp_ingreso(),
						ServicioWebConstantes.CORE_APOLO, ServicioWebConstantes.RECUPERAR_CONTRASENA,
						transaccionDTO.getTipo_documento(), transaccionDTO.getDocumento(), respuestaRS.getEmail());
				return respuestaRS;
			}

//		}

//		respuestaRS = MiddlewareDSBroker.getInstancia().preLogin(transaccionDTO, ServicioWebConstantes.CORE_ONLINE,
//				ServicioWebConstantes.PRE_LOGIN);
//
//		if (respuestaRS.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
//
//			if (respuestaRS.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
//
//				respuestaRS = PerfilDSBroker.getInstancia().RecuperarContrasena(transaccionDTO.getApp_ingreso(),
//						ServicioWebConstantes.CORE_ONLINE, ServicioWebConstantes.RECUPERAR_CONTRASENA,
//						transaccionDTO.getTipo_documento(), transaccionDTO.getDocumento(), "");
//				return respuestaRS;
//			}
//
//		}

		return respuestaRS;
	}

	public RespuestaDataService procesarCambioContrasena(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().CambioContrasena(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarValidaUsuario(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaLogin = new RespuestaDataService();

		try {

			
			
			respuestaLogin = MiddlewareDSBroker.getInstancia().validaUsuario(transaccionDTO,
					ServicioWebConstantes.CORE_APOLO, ServicioWebConstantes.VALIDAR_USUARIO);

			if (respuestaLogin.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA) || 
					respuestaLogin.getCodigo_respuesta().equals("2")) {
				return respuestaLogin;
			}				
			
//			Esto valida usuario si existe en online1, se comenta porque simpre se debe registrar en apolo
//			respuestaLogin = MiddlewareDSBroker.getInstancia().preLogin(transaccionDTO,
//					ServicioWebConstantes.CORE_ONLINE, ServicioWebConstantes.PRE_LOGIN);
//
//			if (respuestaLogin.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
//				return respuestaLogin;
//			}

			return respuestaLogin;

		} catch (NegocioExcepcion e) {
			
			respuestaLogin.setCodigo_respuesta(e.getCodigoError());
			respuestaLogin.setMensaje_respuesta(e.getMessage());

		} catch (Exception e) {
			
			respuestaLogin.setCodigo_respuesta(MensajesErrorConstantes.CODIGO_ERROR_GENERAL);
			respuestaLogin.setMensaje_respuesta(MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		}

		return respuestaLogin;
	}

	public RespuestaDataService procesarValidarClaveTranx(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().ValidarClaveTranx(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarCrearClaveTranx(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().CrearClaveTranx(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarTarjetasInscritas(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().TarjetasInscritas(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarInscribirTarjeta(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().InscribirTarjetas(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarConsultaNotificaciones(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().ConsultaNotificaciones(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarActualizarNotificacion(TransaccionDTO transaccionDTO) throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().ActualizaNotificacion(transaccionDTO);

		return respuestaRS;
	}

	public RespuestaDataService procesarIconoPerfil(TransaccionDTO transaccionDTO, String imagen)
			throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
//			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

//			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
//				return respuestaDispositivo;
//			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().IconoPerfil(transaccionDTO, imagen);

		return respuestaRS;
	}

	public RespuestaDataService procesarOmitirActualizacion(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if (transaccionDTO.getApp_ingreso().equals(MiddlewareConstantes.APP_INGRESO)) {
			respuestaDispositivo = ServicioWebDSBroker.getInstancia().validaDispositivo(transaccionDTO);

			if (!respuestaDispositivo.getCodigo_respuesta().equals(MiddlewareConstantes.RESPUESTA_EXITOSA)) {
				return respuestaDispositivo;
			}
		}
		respuestaRS = PerfilDSBroker.getInstancia().OmitirActualizacion(transaccionDTO);
		return respuestaRS;
	}

		
}
