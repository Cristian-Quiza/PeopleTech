package co.com.middleware.servicios.implementacion;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.sun.jersey.core.header.FormDataContentDisposition;

import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.dto.BaseRespuesta;
import co.com.middleware.dto.TransaccionTalosDTO;
import co.com.middleware.log.Log;
import co.com.middleware.servicios.IMiddlewareTalosServicio;
import co.com.middleware.talos.negocio.Clientes;
import co.com.middleware.talos.negocio.Login;
import co.com.middleware.talos.negocio.PostArchivo;
import co.com.middleware.talos.negocio.SolicitudArchivosTarjetas;

public class MiddlewareTalosImpl implements IMiddlewareTalosServicio {
	
	
	@Override
	public String realizarechoTestTalos()throws Exception {
	
	String respuesta = "";
	Base64 base64 = new Base64();
	String respuestaStr = null;
	PostArchivo postArchivo= new PostArchivo();;
	
	respuesta = postArchivo.procesarEchoTestTalos();

		respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));
					
		return respuestaStr;	
				
	}
	

	@Override
	public String realizarCrearTarjetaHabiente(String tramaRequest) throws Exception {
		String respuesta = "";
		Base64 base64 = new Base64();
		String respuestaStr = null;
		Clientes cliente = new Clientes();
		Gson gson = new Gson();
		
		if (tramaRequest == null ) {
			BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
					MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);
			
			respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
						
			return respuestaStr;
		}

		Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

		respuesta = cliente.procesarCrearTarjetaHabiente(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

		respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

		return respuestaStr;
	}

	@Override
	public String realizarCiudad(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = clientes.procesarCiudad(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarDepartamentos(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}
			
			
			Log.getInstance().debug("transaccionDTO " + tramaRequest, getClass());

			respuesta = clientes.procesarDepartamentos(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarLogin(String tramaRequest) throws Exception {

			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Login login = new Login();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = login.procesarLogin(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarCrearSolicitud(String tramaRequest) throws Exception {

			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = solicitudArchivosTarjetas.procesarCrearSolicitud(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarIndicadorLogin(String tramaRequest) throws Exception {

			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Login login = new Login();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = login.procesarindicadorLogin(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarArchivoSolicitud(String tramaRequest) throws Exception {

			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = solicitudArchivosTarjetas.procesarArchivoSolicitud(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarMatiSolicitud(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = solicitudArchivosTarjetas.procesarMatiSolicitud(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}
	
	@Override
	public String realizarAdministrador(String tramaRequest, FormDataContentDisposition fileMetaData) throws Exception {
		
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		PostArchivo postArchivo= new PostArchivo();
		TransaccionTalosDTO transaccionTalosDTO = new TransaccionTalosDTO();
		String respuestaStr = null;
		String transaccionJson = null;
		String respuesta = "";
		
		if (tramaRequest == null ) {
			BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
					MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

			respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
						
			return respuestaStr;
		}
		
		transaccionJson = new String(base64.decode(tramaRequest.getBytes()), "iso-8859-1");

		transaccionTalosDTO = gson.fromJson(transaccionJson, TransaccionTalosDTO.class);

		Log.getInstance().debug("TransaccionTalosDTO " + transaccionJson, getClass());

		respuesta =  postArchivo.procesarAdministrador(transaccionTalosDTO, fileMetaData);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultarListas(String tramaRequest) throws Exception {
		String respuesta = "";
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		String respuestaStr = null;
		PostArchivo postArchivo= new PostArchivo();
		TransaccionTalosDTO transaccionTalosDTO = new TransaccionTalosDTO();
		String transaccionJson = null;
		
		if (tramaRequest == null ) {
			BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
					MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

			respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
						
			return respuestaStr;
		}
		
		transaccionJson = new String(base64.decode(tramaRequest.getBytes()), "iso-8859-1");

		transaccionTalosDTO = gson.fromJson(transaccionJson, TransaccionTalosDTO.class);

		Log.getInstance().debug("TransaccionTalosDTO " + transaccionJson, getClass());

		respuesta =  postArchivo.procesarConsultarListas(transaccionTalosDTO, tramaRequest);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarCrearArchivos(String tramaRequest) throws Exception {
		
		String respuesta = "";
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		String respuestaStr = null;
		PostArchivo postArchivo= new PostArchivo();
		TransaccionTalosDTO transaccionTalosDTO = new TransaccionTalosDTO();
		String transaccionJson = null;
		
		if (tramaRequest == null ) {
			BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
					MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

			respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
						
			return respuestaStr;
		}
		
		transaccionJson = new String(base64.decode(tramaRequest.getBytes()), "iso-8859-1");

		transaccionTalosDTO = gson.fromJson(transaccionJson, TransaccionTalosDTO.class);

		Log.getInstance().debug("TransaccionTalosDTO " + transaccionJson, getClass());

		respuesta =  postArchivo.procesarCrearArchivos(transaccionTalosDTO, tramaRequest);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	
	@Override
	public String realizarValidarOtp(String tramaRequest) throws Exception {
	
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = clientes.procesarValidarOtp(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarPais() throws Exception {
	
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			respuesta = clientes.procesarPais();

				respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));
							
				return respuestaStr;
						
			}
	
	@Override
	public String realizarGenerarOtp(String tramaRequest) throws Exception {
	
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

//			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());
			Log.getInstance().debug("transaccionDTO " + tramaRequest , getClass());

			respuesta = clientes.procesarGenerarOtp(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}

	@Override
	public String realizarConsultaTerminosYCondiciones() throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			respuesta = solicitudArchivosTarjetas.procesarConsultaTerminosYCondiciones();

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}
	
	@Override
	public String realizarGenero() throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			respuesta = clientes.procesarGenero();
			
			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

	@Override
	public String realizarDatosSolicitud(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = solicitudArchivosTarjetas.procesarDatosSolicitud(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}
	
	@Override
	public String realizarPreguntasSeguro() throws Exception {
	
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			respuesta = clientes.procesarPreguntasSeguro();

				respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));
							
				return respuestaStr;
						
			}
	
	@Override
	public String realizarTipoDocumento() throws Exception {
	
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			respuesta = clientes.procesarTipoDocumento();

				respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));
							
				return respuestaStr;
						
			}


	@Override
	public String realizarCreaActuaRespuestaSeguro(String tramaRequest) throws Exception {
		
		String respuesta = "";
		Base64 base64 = new Base64();
		String respuestaStr = null;
		Login login = new Login();
		
		if (tramaRequest == null ) {
			Gson gson = new Gson();
			BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
					MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

			respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
						
			return respuestaStr;
	}
	
	Log.getInstance().debug("transaccionDTO " + tramaRequest , getClass());

	respuesta = login.procesarCreaActuaRespuestaSeguro(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

	respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

	return respuestaStr;

	}
	
	@Override
	public String realizarDatosAdicionales(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = solicitudArchivosTarjetas.procesarDatosAdicionales(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}
	
	@Override
	public String realizarConsultarProfesion() throws Exception {

			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			respuesta = clientes.procesarConsultarProfesion();

				respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));
							
				return respuestaStr;
						
			}
	
	@Override
	public String realizarFinalizarMati(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = solicitudArchivosTarjetas.procesarFinalizarMati(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}	
	
	@Override
	public String realizarPreguntasBasicasSolicitud(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			Clientes clientes = new Clientes();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = clientes.procesarPreguntasBasicasSolicitud(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}
	
	@Override
	public String realizarSolicitudes(String tramaRequest) throws Exception {
		
			String respuesta = "";
			Base64 base64 = new Base64();
			String respuestaStr = null;
			SolicitudArchivosTarjetas solicitudArchivosTarjetas = new SolicitudArchivosTarjetas();
			
			if (tramaRequest == null ) {
				Gson gson = new Gson();
				BaseRespuesta baseRespuesta = new BaseRespuesta(MensajesErrorConstantes.CODIGO_ERROR_TOKEN,
						MensajesErrorConstantes.MENSAJE_ERROR_TOKEN);

				respuestaStr = new String(base64.encode(gson.toJson(baseRespuesta).getBytes("iso-8859-1")));
							
				return respuestaStr;
			}

			Log.getInstance().debug("transaccionDTO " + new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))), getClass());

			respuesta = solicitudArchivosTarjetas.procesarSolicitudes(new String(base64.decode(tramaRequest.getBytes("iso-8859-1"))));

			respuestaStr = new String(base64.encode(respuesta.getBytes("iso-8859-1")));

			return respuestaStr;
		}
	
}