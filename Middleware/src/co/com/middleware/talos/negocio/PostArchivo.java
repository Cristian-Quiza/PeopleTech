package co.com.middleware.talos.negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.sun.jersey.core.header.FormDataContentDisposition;

import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.dto.BaseRespuesta;
import co.com.middleware.dto.TransaccionTalosDTO;
import co.com.middleware.talos.broker.MiddlewareBroker;
import co.com.middlware.excepciones.NegocioExcepcion;

public class PostArchivo {

	public String procesarEchoTestTalos() {
		String respuestaRS = "";
		String respuestaStr = null;
		Base64 base64 = new Base64();
		BaseRespuesta baseRespuesta = null;
		Gson gson = null;
		
		LocalDateTime current = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		String currentDate = current.format(formatter);
		
		try {
					
			respuestaStr = new String(base64.encode(currentDate.getBytes("iso-8859-1")));
			
			return respuestaRS;
			
			
		} catch (Exception e) {
			gson = new Gson();
			baseRespuesta = new BaseRespuesta(Integer.parseInt(MensajesErrorConstantes.CODIGO_ERROR_GENERAL),
					MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
		
		}
		return gson.toJson(baseRespuesta);
	}	
	
	public String procesarAdministrador(TransaccionTalosDTO transaccionTalosDTO, FormDataContentDisposition fileMetaData)
			throws NegocioExcepcion {
		
		String respuestaRS = null;
		
		respuestaRS = MiddlewareBroker.getInstancia().administrador(transaccionTalosDTO, fileMetaData);

		return respuestaRS;
		
		}

	public String procesarCrearArchivos(TransaccionTalosDTO transaccionTalosDTO, String tramaRequest) throws NegocioExcepcion{
		
		String respuestaRS = "";

			respuestaRS = MiddlewareBroker.getInstancia().crearArchivos(transaccionTalosDTO, tramaRequest);

			return respuestaRS;

	}

	public String procesarConsultarListas(TransaccionTalosDTO transaccionTalosDTO, String tramaRequest) throws NegocioExcepcion{
		String respuestaRS = "";

		respuestaRS = MiddlewareBroker.getInstancia().consultarListas(transaccionTalosDTO, tramaRequest);

		return respuestaRS;
	}

}
