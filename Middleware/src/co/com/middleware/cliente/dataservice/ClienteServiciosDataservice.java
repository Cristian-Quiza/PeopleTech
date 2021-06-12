package co.com.middleware.cliente.dataservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.log.Log;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.ConfiguracionEnpoint;


public class ClienteServiciosDataservice {
	
	final String SEPARADOR_VALORES_RESTSERVICE = "/";
	final String ENCODE_ESPACIO = "%20";
	final static List<Integer> codRespuestaExitosos = Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);
	
	StringBuilder endpoint;
	
	
	public ClienteServiciosDataservice(String url,
            LinkedList<?> listaParametros) {
		
		listaParametros = escaparCaracteres(listaParametros);
		
		endpoint = new StringBuilder();
		endpoint.append(url).append(SEPARADOR_VALORES_RESTSERVICE);
		
		int ind = 1;
		for(Object object : listaParametros) {	
			endpoint.append(object);
			if (ind < listaParametros.size()) {
				endpoint.append(SEPARADOR_VALORES_RESTSERVICE);
			}
			ind++;
		}
    }

	/**
	 * 
	 * @param urlEndPoint
	 * @param parametrosEndPoint
	 */
	public ClienteServiciosDataservice(String urlEndPoint,
            String... parametrosEndPoint) {


		Log.getInstance().debug("Constructor ClienteServiciosDataservice", getClass());
		
        if (parametrosEndPoint.length > 0) {
        	endpoint = new StringBuilder(urlEndPoint).append("/");
            int ind = 1;
            for (String parametro : parametrosEndPoint) {
            	
            	endpoint.append(parametro);
                if (ind < parametrosEndPoint.length) {
                	endpoint.append(SEPARADOR_VALORES_RESTSERVICE);
                }
                ind++;
            }
        } else {
        	endpoint = new StringBuilder(urlEndPoint);
        }
	}
	
	/**
	 * 
	 * @return
	 */
	public String consumirServicio() throws NegocioExcepcion {
		Log.getInstance().debug("Metodo consumirServicio", getClass());
		
		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";
		
    	try {
   		 
    		EncabezadosHttp encabezadosHttp = new EncabezadosHttp();
			DefaultHttpClient httpClient = new DefaultHttpClient();
			Log.getInstance().info("endpoint::: " + 
					endpoint, getClass());
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
    		Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio", ConfiguracionEnpoint.class);
			Log.getInstance().error(e, ConfiguracionEnpoint.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (IOException e) {
    		Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio", ConfiguracionEnpoint.class);
			Log.getInstance().error(e, ConfiguracionEnpoint.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (Exception e) {
    		Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio", ConfiguracionEnpoint.class);
			Log.getInstance().error(e, ConfiguracionEnpoint.class);
    		throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	}
		
		return sbResultadoConsumoServicio.toString();
		
	}
	
	
	public String consumirServicioPOST() throws NegocioExcepcion{
		Log.getInstance().debug("M�todo consumirServicio", getClass());
		
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
    		Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio", ConfiguracionEnpoint.class);
			Log.getInstance().error(e, ConfiguracionEnpoint.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (IOException e) {
    		Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio", ConfiguracionEnpoint.class);
			Log.getInstance().error(e, ConfiguracionEnpoint.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	} catch (Exception e) {
    		Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio", ConfiguracionEnpoint.class);
			Log.getInstance().error(e, ConfiguracionEnpoint.class);
    		throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST, 
    				MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
    	}
		
		return sbResultadoConsumoServicio.toString();
		
	}
	
	private LinkedList<Object> escaparCaracteres(LinkedList<?> listaParametros){
		
	    LinkedList<Object> nuevaListaParametros = new LinkedList();
	    
	    for (Object object : listaParametros){
	    	if(object != null){	    		
				  object = object.toString().replace("%", "%25");
				  object = object.toString().replace(" ", "%20");
				  object = object.toString().replace("<", "%3C");
				  object = object.toString().replace(">", "%3E");
				  object = object.toString().replaceAll("#", "%23");
				  object = object.toString().replace("{", "%7B");
				  object = object.toString().replace("}", "%7D");
				  object = object.toString().replace("|", "%7C");
				  object = object.toString().replace("\\", "%5C");
				  object = object.toString().replace("^", "%5E");
				  object = object.toString().replace("~", "%7E");
				  object = object.toString().replace("[", "%5B");
				  object = object.toString().replace("]", "%5D");
				  object = object.toString().replace("`", "%60");
				  object = object.toString().replace(";", "%3B");
				  object = object.toString().replace("/", "-");
				  object = object.toString().replace("?", "-");
				  object = object.toString().replace(":", "%3A");
				  object = object.toString().replace("@", "%40");
				  object = object.toString().replace("=", "%3D");
				  object = object.toString().replace("&", "%26");
				  object = object.toString().replace("$", "%24");
				  object = object.toString().replace("<", "%3C");
				  object = object.toString().replace("\"", "%20");
				  object = object.toString().replace("'", "%20");
				  
				  nuevaListaParametros.add(object);
	    		
	    	}
	      
	    }
	    return nuevaListaParametros;
	  }
	
}
