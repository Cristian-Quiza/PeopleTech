package co.com.middleware.cliente.dataservice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import co.com.middleware.broker.MiddlewareDSBroker;
import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.constantes.NombresPropertiesConstantes;
import co.com.middleware.log.Log;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.PropiedadesManager;

public class ClienteServiciosApolo {

	final String SEPARADOR_VALORES_RESTSERVICE = "&";
	final String VALOR_VALORES_RESTSERVICE = "=";
	final String ENCODE_ESPACIO = "%20";
	final static List<Integer> codRespuestaExitosos = Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);
	final int timeOutDataService = Integer
			.parseInt(PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_TIMEOUT));
	StringBuilder endpoint;
	StringBuilder endpointPost;

	public ClienteServiciosApolo(String url, LinkedList<?> listaParametros, List<String> listaNombreParam) {

		listaParametros = escaparCaracteres(listaParametros);
		endpoint = new StringBuilder();
		endpoint.append(url);
		int ind = 1;
		for (int i = 0; i < listaParametros.size(); i++) {
			endpoint.append(listaNombreParam.get(i));
			endpoint.append(VALOR_VALORES_RESTSERVICE);
			endpoint.append(listaParametros.get(i));
			if (ind < listaParametros.size()) {
				endpoint.append(SEPARADOR_VALORES_RESTSERVICE);
			}
			ind++;
		}
	}

	public ClienteServiciosApolo(List<String> listaParametros, List<String> listaNombreParam) {

		endpointPost = new StringBuilder();
		int ind = 1;
		for (int i = 0; i < listaParametros.size(); i++) {
			endpointPost.append(listaNombreParam.get(i));
			endpointPost.append(VALOR_VALORES_RESTSERVICE);
			endpointPost.append(listaParametros.get(i));
			if (ind < listaParametros.size()) {
				endpointPost.append(SEPARADOR_VALORES_RESTSERVICE);
				Log.getInstance().debug("endpointPost: " + endpointPost, getClass());
			}
			ind++;
		}
	}

	public ClienteServiciosApolo(LinkedList<?> listaParametros, List<String> listaNombreParam) {

		listaParametros = escaparCaracteres(listaParametros);
		endpointPost = new StringBuilder();
		int ind = 1;
		for (int i = 0; i < listaParametros.size(); i++) {
			endpointPost.append(listaNombreParam.get(i));
			endpointPost.append(VALOR_VALORES_RESTSERVICE);
			endpointPost.append(listaParametros.get(i));
			if (ind < listaParametros.size()) {
				endpointPost.append(SEPARADOR_VALORES_RESTSERVICE);
				Log.getInstance().debug("endpointPost: " + endpointPost, getClass());
			}
			ind++;
		}
	}

	/**
	 * 
	 * @param urlEndPoint
	 * @param parametrosEndPoint
	 */
	public ClienteServiciosApolo(String urlEndPoint, String... parametrosEndPoint) {

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

	public String consumirServicioCobrar() throws NegocioExcepcion {

		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";

		try {
			// Creating default HttpClient
			HttpClient httpClient = new DefaultHttpClient();
			final HttpParams httpParams = httpClient.getParams();

			// Setting timeouts
			HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
			HttpConnectionParams.setSoTimeout(httpParams, 30000);

			// Rest of your code
			final HttpPost httppost = new HttpPost(endpoint.toString());
			httppost.setHeader("Accept", "text/xml");
			httppost.setHeader("Content-type", "application/xml; charset=UTF-8");

			final HttpResponse response = httpClient.execute(httppost);

			final HttpEntity entity = response.getEntity();

			if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
				throw new RuntimeException(
						"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
			} else {
				Log.getInstance().debug("Respuesta Correcta: " + response.getStatusLine().getStatusCode(), getClass());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((entity.getContent())));

			Log.getInstance().debug("Consumiendo el servicio del Servidor...", getClass());
			while ((respuestaServicio = br.readLine()) != null) {
				sbResultadoConsumoServicio.append(respuestaServicio);
			}

			br.close();

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		}

		return sbResultadoConsumoServicio.toString();

	}

	public String consumirServicio() throws NegocioExcepcion {

		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";

		try {
			final HttpParams httpParams = new BasicHttpParams();

			HttpConnectionParams.setConnectionTimeout(httpParams, timeOutDataService);

			EncabezadosHttp encabezadosHttp = new EncabezadosHttp();

			DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);

			HttpPost getRequest = new HttpPost(endpoint.toString());

			getRequest.setHeaders(encabezadosHttp.getEncabezadosHttp());

			HttpResponse response = httpClient.execute(getRequest);

			if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
				throw new RuntimeException(
						"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
			} else {
				Log.getInstance().debug("Respuesta Correcta: " + response.getStatusLine().getStatusCode(), getClass());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			Log.getInstance().debug("Consumiendo el servicio del Servidor...", getClass());
			while ((respuestaServicio = br.readLine()) != null) {
				sbResultadoConsumoServicio.append(respuestaServicio);
			}

			br.close();

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		}

		return sbResultadoConsumoServicio.toString();

	}

	public String consumirServicioPOST(String url) throws NegocioExcepcion {
		StringBuilder sbResultadoConsumoServicio = new StringBuilder();

		try {
			final HttpParams httpParams = new BasicHttpParams();

			HttpConnectionParams.setConnectionTimeout(httpParams, timeOutDataService);

			HttpURLConnection con = null;

			byte[] postData = endpointPost.toString().getBytes(StandardCharsets.UTF_8);

			URL apoloUrl = new URL(url);
			con = (HttpURLConnection) apoloUrl.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Java client");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {

				wr.write(postData);
			}

			Log.getInstance().debug("Consumiendo el servicio del Servidor...", getClass());

			if (!codRespuestaExitosos.contains(con.getResponseCode())) {
				throw new RuntimeException("Fall� : C�digo de Error HTTP: " + con.getResponseCode());
			} else {
				Log.getInstance().debug("Respuesta Correcta: " + con.getResponseCode(), getClass());
			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String line;
				content = new StringBuilder();

				while ((line = br.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
				}
			}

			Log.getInstance().info("respuesta PHP:::" + content.toString(), getClass());

			sbResultadoConsumoServicio.append(content.toString());

			con.disconnect();

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		}

		return sbResultadoConsumoServicio.toString();

	}

	public String consumirServicioGet() throws NegocioExcepcion {

		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";

		try {
			final HttpParams httpParams = new BasicHttpParams();

			Log.getInstance().debug("timeOutDataService:::" + timeOutDataService, getClass());

			HttpConnectionParams.setConnectionTimeout(httpParams, timeOutDataService);

			EncabezadosHttp encabezadosHttp = new EncabezadosHttp();

			DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);

			HttpGet getRequest = new HttpGet(endpoint.toString());

			getRequest.setHeaders(encabezadosHttp.getEncabezadosHttp());

			HttpResponse response = httpClient.execute(getRequest);

			if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
				throw new RuntimeException(
						"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
			} else {
				Log.getInstance().debug("Respuesta Correcta: " + response.getStatusLine().getStatusCode(), getClass());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			Log.getInstance().debug("Consumiendo el servicio del Servidor...", getClass());
			while ((respuestaServicio = br.readLine()) != null) {
				sbResultadoConsumoServicio.append(respuestaServicio);
			}

			httpClient.getConnectionManager().shutdown();
		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		}

		return sbResultadoConsumoServicio.toString();

	}

	private LinkedList<Object> escaparCaracteres(LinkedList<?> listaParametros) {

		LinkedList<Object> nuevaListaParametros = new LinkedList();

		for (Object object : listaParametros) {
			if (object != null) {
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

	public String consumirServicioHttps(String url) throws NegocioExcepcion {

		StringBuilder sbResultadoConsumoServicio = new StringBuilder();

		int responseCode = HttpURLConnection.HTTP_OK;
		InputStream in;
		URL requestUrl = null;

		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			// Install the all-trusting trust manager
			HttpsURLConnection urlConnection;
			requestUrl = new URL(url);
			urlConnection = (HttpsURLConnection) requestUrl.openConnection();

			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			//Magia in this line
			urlConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			urlConnection.setConnectTimeout(5000);
			urlConnection.setReadTimeout(5000);
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("GET");
			urlConnection.setChunkedStreamingMode(2048);
			urlConnection.connect();
			urlConnection.connect();
			responseCode = urlConnection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {

				in = new BufferedInputStream(urlConnection.getInputStream());

				BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				String line;

				while ((line = reader.readLine()) != null) {
					sbResultadoConsumoServicio.append(line);
				}

			} else {
				return null;
			}

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, MiddlewareDSBroker.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		}

		return sbResultadoConsumoServicio.toString();
	}

	public static void disableCertificateValidation() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			;
		}
	}

}
