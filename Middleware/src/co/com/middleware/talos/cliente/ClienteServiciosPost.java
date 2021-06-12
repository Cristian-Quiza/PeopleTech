package co.com.middleware.talos.cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.sun.jersey.core.header.FormDataContentDisposition;

import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.dto.ParametrosTalosDTO;
import co.com.middleware.log.Log;
import co.com.middlware.excepciones.NegocioExcepcion;

public class ClienteServiciosPost {

	final static List<Integer> codRespuestaExitosos = Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 226);

	private ContentType contentType = ContentType.create("application/json", "UTF-8");

	EncabezadosHttpsNotificacion encabezadosHttp = new EncabezadosHttpsNotificacion();

	public String consumirServicioPost(String endpoint, String transaccionPost) throws NegocioExcepcion {

		CloseableHttpClient client = HttpClients.createDefault();

		try {
			try {

				HttpPost httpPost = new HttpPost(endpoint);

				httpPost.setHeaders(encabezadosHttp.getEncabezadosHttp());

				StringEntity requestEntity = new StringEntity(transaccionPost, contentType);

				httpPost.setEntity(requestEntity);

				CloseableHttpResponse response = client.execute(httpPost);
				try {
					HttpEntity entity = response.getEntity();

					String jsonResponse = EntityUtils.toString(entity);

					if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
						throw new RuntimeException(
								"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
					} else {
						Log.getInstance().info(
								"**********Respuesta Correcta: **********\n" + response.getStatusLine().getStatusCode(),
								getClass());
					}

					return jsonResponse;

				} finally {
					response.close();
				}
			} finally {
				client.close();
			}
		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);

			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_CONSUMO_SERVICIO_REST,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		}

	}


	public String consumirServicioPOST(String endpoint, String transaccionPost) throws NegocioExcepcion {
		Log.getInstance().debug("M�todo consumirServicio", getClass());

		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";
		BufferedReader br = null;

		try {
			Log.getInstance().info("endpoint:::::::" + endpoint, getClass()); // DEBUG
			Log.getInstance().info("transaccionPost:::::::" + transaccionPost, getClass()); // DEBUG

			EncabezadosHttpsNotificacion encabezadosHttp = new EncabezadosHttpsNotificacion();

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost httpPost = new HttpPost(endpoint);

			if (!transaccionPost.equals("")) {

				httpPost.setHeaders(encabezadosHttp.getEncabezadosHttp());

				StringEntity requestEntity = new StringEntity(transaccionPost, contentType);

				httpPost.setEntity(requestEntity);
			}

			HttpResponse response = httpClient.execute(httpPost);

			if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
				throw new RuntimeException(
						"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
			} else {

				Log.getInstance().info("Respuesta Correcta: " + response.getStatusLine().getStatusCode(), getClass());

			}

			br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			Log.getInstance().info("Consumiendo el servicio del Servidor...", getClass());

			while ((respuestaServicio = br.readLine()) != null) {
				sbResultadoConsumoServicio.append(respuestaServicio);
			}

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
						ClienteServiciosPost.class);
				throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
						MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
			};
		}

		return sbResultadoConsumoServicio.toString();

	}

	public String consumirServiceGet(String endpoint) throws NegocioExcepcion {

		Log.getInstance().debug("M�todo consumirServicio", getClass());

		StringBuilder sbResultadoConsumoServicio = new StringBuilder();
		String respuestaServicio = "";
		BufferedReader br = null;

		try {

			EncabezadosHttpsNotificacion encabezadosHttp = new EncabezadosHttpsNotificacion();

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet httpGet = new HttpGet(endpoint);

			httpGet.setHeaders(encabezadosHttp.getEncabezadosHttp());

			HttpResponse response = httpClient.execute(httpGet);

			if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
				throw new RuntimeException(
						"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
			} else {
				Log.getInstance().info("Respuesta Correcta: " + response.getStatusLine().getStatusCode(), getClass());
			}

			br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			Log.getInstance().info("Consumiendo el servicio del Servidor...", getClass());
			while ((respuestaServicio = br.readLine()) != null) {
				sbResultadoConsumoServicio.append(respuestaServicio);
			}

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
						ClienteServiciosPost.class);
				throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
						MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
			}
			;
		}

		return sbResultadoConsumoServicio.toString();
	}

	public String consumirServicePostFile(String endpoint, List<String> listaParametros, List<String> listaNombresParam,
			FormDataContentDisposition fileMetaData) throws NegocioExcepcion {

		Log.getInstance().debug("M�todo consumirServicio", getClass());

		String resString = "";
		BufferedReader reader = null;
		try (CloseableHttpClient client = HttpClients.createDefault()) {

			HttpPost post = new HttpPost(endpoint);

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

			for (int i = 0; i < listaParametros.size(); i++) {
				Log.getInstance().info("*****"+i+"*****"+ listaNombresParam.get(i)+"**********"+listaParametros.get(i)+ "**** Total listaparametros:"+ listaParametros.size()+"****TOAL LISTANOMBRES "+listaNombresParam.size()+"*",getClass());
				if (i == 0) {
					builder.addPart("file", new FileBody(new File(fileMetaData.getFileName()))).build();
					builder.addTextBody(listaNombresParam.get(i), listaParametros.get(i));
				} else {
					builder.addTextBody(listaNombresParam.get(i), listaParametros.get(i));
				}
			}

			HttpEntity entity = builder.build();

			post.setEntity(entity);

			try (CloseableHttpResponse response = client.execute(post)) {

				if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
					throw new RuntimeException(
							"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
				} else {

					Log.getInstance().info(
							"**********Respuesta Correcta: **********\n" + response.getStatusLine().getStatusCode(),
							getClass());
					HttpEntity entityr = response.getEntity();
					InputStream is = entityr.getContent(); // Create an InputStream with the response
					reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = null;

					while ((line = reader.readLine()) != null) // Read line by line
						sb.append(line + "\n");

					resString = sb.toString(); // Result is here
					is.close(); // Close the stream
				}

			}

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
						ClienteServiciosPost.class);
				throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
						MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
			}

		}

		return resString;
	}

	public String consumirServicioArchivo(String endpoint, String tramaRequest) throws NegocioExcepcion {

		Log.getInstance().debug("M�todo consumirServicio", getClass());

		String resString = "";
		BufferedReader reader = null;
		try (CloseableHttpClient client = HttpClients.createDefault()) {

			HttpPost post = new HttpPost(endpoint);

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

			builder.addTextBody(ParametrosTalosDTO.SOLICITUD, tramaRequest);

			HttpEntity entity = builder.build();

			post.setEntity(entity);

			try (CloseableHttpResponse response = client.execute(post)) {

				if (!codRespuestaExitosos.contains(response.getStatusLine().getStatusCode())) {
					throw new RuntimeException(
							"Fall� : C�digo de Error HTTP: " + response.getStatusLine().getStatusCode());
				} else {

					Log.getInstance().info(
							"**********Respuesta Correcta: **********\n" + response.getStatusLine().getStatusCode(),
							getClass());
					HttpEntity entityr = response.getEntity();
					InputStream is = entityr.getContent(); // Create an InputStream with the response
					reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = null;

					while ((line = reader.readLine()) != null) // Read line by line
						sb.append(line + "\n");

					resString = sb.toString(); // Result is here
					is.close(); // Close the stream
				}

			}

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
					ClienteServiciosPost.class);
			Log.getInstance().error(e, ClienteServiciosPost.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
					MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				Log.getInstance().error("[Exception] ClienteServiciosDataservice -> consumirServicio",
						ClienteServiciosPost.class);
				throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_ERROR_GENERAL,
						MensajesErrorConstantes.MENSAJE_ERROR_CONSUMO_SERVICIO_REST);
			}
		}
		return resString;
	}
}
