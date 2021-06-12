package co.com.middleware.cliente.dataservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import co.com.middleware.log.Log;
import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middlware.excepciones.NegocioExcepcion;


public class ClienteServicioCoreParam {
	


	final static List<Integer> codRespuestaExitosos = Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);
	
	String endpoint;
//	NotificacionDTO dataService;
	
	public ClienteServicioCoreParam(String url) {		
		endpoint = url;
//		dataService = parametros;
    }
		
	/**
	 * 
	 * @return
	 */
	public String consumirServicio() throws NegocioExcepcion{
		Log.getInstance().debug("Metodo consumirServicio", getClass());
		
		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";
		
    	try {
   		 
    		EncabezadosHttp encabezadosHttp = new EncabezadosHttp();
			DefaultHttpClient httpClient = new DefaultHttpClient();
    		
    		HttpGet getRequest = new HttpGet(endpoint.toString());
    		getRequest.setHeaders(encabezadosHttp.getEncabezadosHttp());
     
    		HttpResponse response = httpClient.execute(getRequest);
    		
     
    		if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
    			throw new RuntimeException("Fall� : C�digo de Error HTTP: "
    			   + response.getStatusLine().getStatusCode());
    		} else {
    			Log.getInstance().debug("Respuesta Correcta: " + 
    					response.getStatusLine().getStatusCode(), getClass());
    		}
     
    		BufferedReader br = new BufferedReader(
                             new InputStreamReader((response.getEntity().getContent())));
     
    		Log.getInstance().debug("Consumiendo el servicio del Servidor...", getClass());
    		while ((respuestaServicio = br.readLine()) != null) {
    			sbResultadoConsumoServicio.append(respuestaServicio);
    		}
     
    		httpClient.getConnectionManager().shutdown();
     
    	} catch (ClientProtocolException e) {
    		Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio", ClienteServicioCoreParam.class);
			Log.getInstance().error(e, ClienteServicioCoreParam.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (IOException e) {
    		Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio", ClienteServicioCoreParam.class);
			Log.getInstance().error(e, ClienteServicioCoreParam.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (Exception e) {
    		Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio", ClienteServicioCoreParam.class);
			Log.getInstance().error(e, ClienteServicioCoreParam.class);
    		throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	}
		
		return sbResultadoConsumoServicio.toString();
		
	}
	
	
	public String consumirServicioPOST() throws NegocioExcepcion{
		Log.getInstance().debug("M�todo consumirServicio", getClass());
		
		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";
		Gson gson = new Gson();
		
    	try {
   		 
    		EncabezadosHttp encabezadosHttp = new EncabezadosHttp();
			DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPost getRequest = new HttpPost("http://192.168.250.13:8095/Home/getbancos");    		
//    		getRequest.setHeaders(encabezadosHttp.getEncabezadosHttp());
    		StringEntity postingString = new StringEntity(gson.toJson("A000SDF"));
    		getRequest.setEntity(postingString);
    		getRequest.setHeader("Content-type", "application/json");
    		HttpResponse response = httpClient.execute(getRequest);
    		
     
    		if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
    			throw new RuntimeException("Fall� : C�digo de Error HTTP: "
    			   + response.getStatusLine().getStatusCode());
    		} else {
    			Log.getInstance().debug("Respuesta Correcta: " + 
    					response.getStatusLine().getStatusCode(), getClass());
    		}
     
    		BufferedReader br = new BufferedReader(
                             new InputStreamReader((response.getEntity().getContent())));
     
    		Log.getInstance().debug("Consumiendo el servicio del Servidor...", getClass());
    		while ((respuestaServicio = br.readLine()) != null) {
    			sbResultadoConsumoServicio.append(respuestaServicio);
    		}
     
    		httpClient.getConnectionManager().shutdown();
     
    	} catch (ClientProtocolException e) {
    		Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio", ClienteServicioCoreParam.class);
			Log.getInstance().error(e, ClienteServicioCoreParam.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (IOException e) {
    		Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio", ClienteServicioCoreParam.class);
			Log.getInstance().error(e, ClienteServicioCoreParam.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (Exception e) {
    		Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio", ClienteServicioCoreParam.class);
			Log.getInstance().error(e, ClienteServicioCoreParam.class);
    		throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	}
		
		return sbResultadoConsumoServicio.toString();
		
	}
	
}
