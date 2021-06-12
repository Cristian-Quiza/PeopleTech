package co.com.middleware.servicios.controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import co.com.middleware.log.Log;
import co.com.middleware.servicios.IMiddlewareTalosServicio;
import co.com.middleware.servicios.implementacion.MiddlewareTalosImpl;
import co.com.middleware.token.UtilidadTokenTalos;

@Path("/servicios_talos")
public class MiddlewareTalosControlador {

	private IMiddlewareTalosServicio iMiddlewareTalosServicio = new MiddlewareTalosImpl();

	private UtilidadTokenTalos utilidadTokenTalos = new UtilidadTokenTalos();

	@GET
	@Path("/echoTestTalos")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response echoTestTalos() throws Exception {
		String respuestaStr = null;
		Base64 base64 = new Base64();

		long milliseconds = System.currentTimeMillis();	

		LocalDateTime current = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		respuestaStr = iMiddlewareTalosServicio.realizarechoTestTalos();

		Log.getInstance().info(
				"Response echoTest " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr, getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/crearTarjetaHabiente/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response crearTarjetaHabiente(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request crearTarjetaHabiente: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareTalosServicio
				.realizarCrearTarjetaHabiente(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response crearTarjetaHabiente " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/ciudad/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response ciudad(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarCiudad(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response ciudad " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/departamentos/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response departamentos(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarDepartamentos(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response departamentos " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/login/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response login(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarLogin(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response login " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/crearSolicitud/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response crearSolicitud(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarCrearSolicitud(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response crearSolicitud " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/indicadorLogin/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response indicadorLogin(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarIndicadorLogin(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response indicadorLogin " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/archivoSolicitud/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response archivoSolicitud(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarArchivoSolicitud(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response archivoSolicitud " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/matiSolicitud/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response matiSolicitud(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarMatiSolicitud(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response matiSolicitud " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/validarOtp/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response validarOtp(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarValidarOtp(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response validarOtp " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@GET
	@Path("/pais")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response pais() throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarPais();

		Log.getInstance().info("Response pais " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/generarOtp/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response generarOtp(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarGenerarOtp(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response generarOtp " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();
	}

	@POST
	@Path("/consultaTerminosYCondiciones")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response consultaTerminosYCondiciones() throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request consultaTerminosYCondiciones: ", getClass());

		respuestaStr = iMiddlewareTalosServicio.realizarConsultaTerminosYCondiciones();

		Log.getInstance().info("Response consultaTerminosYCondiciones " + (System.currentTimeMillis() - milliseconds)
				+ " : " + respuestaStr, getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/genero")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response genero() throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarGenero();

		Log.getInstance().info("Response genero " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	
	@POST
	@Path("/datosSolicitud/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response datosSolicitud(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarDatosSolicitud(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				" Response datosSolicitud " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}

	@POST
	@Path("/administrador")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response administrador(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData,
			@FormDataParam("transaccion") String transaccion) throws Exception {
		Log.getInstance().info(".1#$%#" + transaccion, getClass());
		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request administrador " + transaccion, getClass());

		int read = 0;
		byte[] bytes = new byte[1024];
		File newFileCarga = new File(fileMetaData.getFileName());

		OutputStream out = new FileOutputStream(newFileCarga);

		while ((read = fileInputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();

		respuestaStr = iMiddlewareTalosServicio.realizarAdministrador(utilidadTokenTalos.desencriptarObjeto(transaccion), fileMetaData);

		Log.getInstance().info("Response administrador " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		if (newFileCarga.delete()) {
			Log.getInstance().info("ARCHIVO ELIMINADO EXITOSAMENTE", getClass());
		} else {
			Log.getInstance().info("NO SE HA ELIMINADO EL ARCHIVO", getClass());
		}

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();
	}
	
	@POST
	@Path("/consultarListas/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response consultarListas(@PathParam("transaccionJson") String transaccion) throws Exception {

		String respuestaStr = null;
		String transaccionJson = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request consultarListas " + transaccionJson, getClass());

		respuestaStr = iMiddlewareTalosServicio.realizarConsultarListas(utilidadTokenTalos.desencriptarObjeto(transaccion));

		Log.getInstance().info(
				"Response crearArchivos " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();
	}


	@POST
	@Path("/crearArchivos/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response crearArchivos(@PathParam("transaccionJson") String transaccion) throws Exception {

		String respuestaStr = null;
		String transaccionJson = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request crearArchivos " + transaccionJson, getClass());

		respuestaStr = iMiddlewareTalosServicio.realizarCrearArchivos(utilidadTokenTalos.desencriptarObjeto(transaccion));

		Log.getInstance().info(
				"Response crearArchivos " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	@GET
	@Path("/preguntasSeguro")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response preguntasSeguro() throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarPreguntasSeguro();

		Log.getInstance().info("Response preguntasSeguro " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	
	@POST
	@Path("/tipoDocumento")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response tipoDocumento() throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarTipoDocumento();

		Log.getInstance().info("Response tipoDocumento " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}


	@POST
	@Path("/creaActuaRespuestaSeguro/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response creaActuaRespuestaSeguro(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarCreaActuaRespuestaSeguro(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response creaActuaRespuestaSeguro " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	
	@POST
	@Path("/datosAdicionales/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response datosAdicionales(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio.realizarDatosAdicionales(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response datosAdicionales " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}	

	
	@POST
	@Path("/consultarProfesion/{transaccionJson}")//independientemente de que no lleve parametro 
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response consultarProfesion() throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();
		
		Log.getInstance().info("Request consultaProfesion: ", getClass());

		respuestaStr = iMiddlewareTalosServicio.realizarConsultarProfesion();

		Log.getInstance().info("Response consultaProfesion " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	@POST
	@Path("/finalizarMati/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response finalizarMati(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarFinalizarMati(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response finalizarMati " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	
	@POST
	@Path("/preguntasBasicasSolicitud/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response preguntasBasicasSolicitud(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarPreguntasBasicasSolicitud(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response preguntasBasicasSolicitud " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	
	@POST
	@Path("/solicitudes/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public Response solicitudes(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareTalosServicio
				.realizarSolicitudes(utilidadTokenTalos.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response solicitudes " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return Response.ok().entity(utilidadTokenTalos.encriptarObjeto(respuestaStr))
				.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST").build();

	}
	
}