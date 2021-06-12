/**
 * 
 */
package co.com.middleware.servicios.controlador;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;

import com.sun.jersey.multipart.FormDataParam;

import co.com.middleware.log.Log;
import co.com.middleware.servicios.IMiddlewareServicio;
import co.com.middleware.servicios.implementacion.MiddlewareImpl;
import co.com.middleware.token.UtilidadToken;

/**
 * @author juan.fonseca
 *
 */

@Path("/servicios_mdl")
public class MiddlewareControlador {

	private IMiddlewareServicio iMiddlewareServicio = new MiddlewareImpl();
	
	private UtilidadToken utilidadToken = new UtilidadToken();

	@Path("/echoTest")
	@GET
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String echoTest() throws Exception {

		Log.getInstance().info("Request ecoTest:::", getClass());

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request ecoTest: ", getClass());

		respuestaStr = iMiddlewareServicio.realizarEchoTest();

		Log.getInstance().info(
				"Response echoTest " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr, getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/login/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String login(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarLogin(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response login " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/validaTitularidad/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String validaTitularidad(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarValidaTitularidad(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response validaTitularidad " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/terminosCondiciones/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String terminosCondiciones(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request terminosCondiciones: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarTerminosCondiciones(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response terminosCondiciones " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/invitarPagoTarjeta/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String invitarPagoTarjeta(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request invitarPagoTarjeta: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarInvitarPagoTarjeta(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response terminosCondiciones " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/pagarTarjetaInvitado/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String pagarTarjetaInvitado(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request invitarPagoTarjeta: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarPagarTarjetaInvitado(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response terminosCondiciones " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/cambioContrasena/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String cambioContrasena(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request cambioContrasena: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarCambioContrasena(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response cambioContrasena " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/claveTransaccional/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String claveTransaccional(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request claveTransaccional: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarClaveTransaccional(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response claveTransaccional " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/actualizarContacto/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ActualizarContacto(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request actualizarContacto: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarActualizarContacto(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response actualizarContacto " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/consultaProductosTH/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ConsultaProductosTH(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request consultaProductosTH: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarConsultaProductosTH(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response consultaProductosTH " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/creaTh/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String CreaActualizaTH(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request creaTh: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarCreaActualizaTH(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response creaTh " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/asociarTarjeta/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String AsociarTarjeta(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarAsociarTarjeta(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response asociarTarjeta " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/notificacionesTH/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String NotificacionesTH(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarNotificacionesTH(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response notificacionesTH " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/desasociarTarjetaCorpo/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String DesasociarTarjetaCorpo(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarDesasociarTarjetaCorpo(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response desasociarTarjetaCorpo " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/consultaMovimientosTarjeta/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ConsultaMovimientosTarjeta(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarConsultaMovimientosTarjeta(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response consultaMovimientosTarjeta " + (System.currentTimeMillis() - milliseconds)
				+ " : " + respuestaStr, getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/cobrarTarjeta/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String CobrarTarjeta(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarCobrarTarjeta(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response cobrarTarjeta " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@POST
	@Path("/guardarIconoPerfil")
	@Produces("text/plain; charset=UTF-8")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String GuardarIconoPerfil(@FormDataParam("transaccion") String transaccion,@FormDataParam("imagen") InputStream attachment) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();
		Log.getInstance().info("Request guardarIconoPerfil " + transaccion, getClass());

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;

		byte[] bytes = new byte[16384];

		while ((nRead = attachment.read(bytes, 0, bytes.length)) != -1) {
			buffer.write(bytes, 0, nRead);
		}

		String imageStr = Base64.encodeBase64String(buffer.toByteArray());

		respuestaStr = iMiddlewareServicio.realizarGuardarIconoPerfil(utilidadToken.desencriptarObjeto(transaccion),
				imageStr);

		Log.getInstance().info(
				"Response guardarIconoPerfil " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}
	

	@GET
	@Path("/cambiarEstadoTarjeta/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String CambiarEstadoTarjeta(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarCambiarEstadoTarjeta(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response cambiarEstadoTarjeta " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/crearSoporte/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String CrearSoporte(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarCrearSoporte(transaccionJson);

		Log.getInstance().info(
				"Response CrearSoporte " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return respuestaStr;

	}

	@GET
	@Path("/eliminarCuentaTranf/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String EliminarCuentaTranf(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarEliminarCuentaTranf(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response EliminarCuentaTranf " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/actualizaNotificacion/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ActualizaNotificacion(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarActualizaNotificacion(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response ActualizaNotificacion " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/recuperarContrasena/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String RecuperarContrasena(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarRecuperarContrasena(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response RecuperarContrasena " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/agregadoMovimientos/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String AgregadoMovimientos(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarAgregadoMovimientos(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response AgregadoMovimientos " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/solicitaTarjetaPropia/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String SolicitaTarjetaPropia(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarSolicitaTarjetaPropia(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response SolicitaTarjetaPropia " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/solicitaTarjetaAmparada/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String SolicitaTarjetaAmparada(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarSolicitaTarjetaAmparada(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response SolicitaTarjetaAmparada " + (System.currentTimeMillis() - milliseconds) + " : "
				+ respuestaStr, getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/transferencia/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String Transferencia(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarTransferencia(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response Transferencia " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/consultaAmparadas/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ConsultaAmparadas(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarConsultaAmparadas(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response ConsultaAmparadas " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/inscribirOtraTarjeta/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String InscribirOtraTarjeta(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarInscribirOtraTarjeta(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response InscribirOtraTarjeta " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/tarjetasInscritas/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String TarjetasInscritas(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarTarjetasInscritas(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response TarjetasInscritas " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/validarClaveTrans/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ValidarClaveTrans(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarValidarClaveTrans(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response ValidarClaveTrans " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/consultaEstadoLlaveM/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String AsociarTarjetaLlaveMaestra(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarConsultaEstadoLlaveM(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response AsociarTarjetaLlaveMaestra " + (System.currentTimeMillis() - milliseconds)
				+ " : " + respuestaStr, getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/consultaAbonosLlaveMaestra/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ConsultaAbonosLlaveMaestra(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarConsultaAbonosLlaveMaestra(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response ConsultaAbonosLlaveMaestra " + (System.currentTimeMillis() - milliseconds)
				+ " : " + respuestaStr, getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@POST
	@Path("/legalizarAbono")
	@Produces("text/plain; charset=UTF-8")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String legalizarAbono(@FormDataParam("transaccion") String transaccion,
			@FormDataParam("imagen") InputStream attachment) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Response LegalizarAbono " + transaccion, getClass());

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;

		byte[] bytes = new byte[16384];

		while ((nRead = attachment.read(bytes, 0, bytes.length)) != -1) {
			buffer.write(bytes, 0, nRead);
		}

		String imageStr = Base64.encodeBase64String(buffer.toByteArray());

		respuestaStr = iMiddlewareServicio.realizarLegalizarAbono(utilidadToken.desencriptarObjeto(transaccion),
				imageStr);

		Log.getInstance().info(
				"Response LegalizarAbono " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

//	@POST
//	@Path("/legalizarAbono")
//	@Produces("text/plain; charset=UTF-8")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public String legalizarAbono(@Multipart("transaccion") String transaccion, 
//    		@Multipart("imagen") Attachment attachment) throws Exception {
//
//		String respuestaStr = null;
//
//		long milliseconds = System.currentTimeMillis();
//		Log.getInstance().info(
//				"Response LegalizarAbono " + transaccion,
//				getClass());
//
//		 InputStream finput = attachment.getObject(InputStream.class);
//	        byte[] bytes = org.apache.cxf.helpers.IOUtils.readBytesFromStream(finput);
//			String imageStr = Base64.encodeBase64String(bytes);
//			
//		respuestaStr = iMiddlewareServicio.realizarLegalizarAbono(utilidadToken.desencriptarObjeto(transaccion),imageStr);	
//
//		Log.getInstance().info(
//				"Response LegalizarAbono " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
//				getClass());
//
//		return  utilidadToken.encriptarObjeto(respuestaStr);
//
//	}

	@GET
	@Path("/recargar/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String Recargar(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio.realizarRecargar(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response Recargar " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr, getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/movimientosTarjetaLlaveMaestra/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String MovimientosTarjetaLlaveMaestra(@PathParam("transaccionJson") String transaccionJson)
			throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarMovimientosTarjetaLlaveMaestra(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response MovimientosTarjetaLlaveMaestra " + (System.currentTimeMillis() - milliseconds)
				+ " : " + respuestaStr, getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/reversoLLaveMaestra/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ReversoLLaveMaestra(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		respuestaStr = iMiddlewareServicio
				.realizarReversoLLaveMaestra(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response ReversoLLaveMaestra " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/validaUsuario/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ValidaUsuario(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request ValidaUsuario: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarValidaUsuario(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response ValidaUsuario " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/pais/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String Pais(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request Pais: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarPais(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response Pais " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/departamento/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String Departamento(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request Departamento: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarConsultaDepartamentos(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response Departamento " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/ciudad/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String Ciudad(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request Ciudad: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarConsultaCiudades(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info("Response Ciudad " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/publicidad/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String Publicidad(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request Publicidad: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarConsultaPublicidad(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response Publicidad " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/activarEcommerce/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ActivaEcommerce(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request ActivaEcommerce: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarActivarEcommerce(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response activaEcommerce " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/configEcommerce/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ConfiguracionEcommerce(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request configEcommerce: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio
				.realizarConfiguracionEcommerce(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response configEcommerce " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/generarCvv/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String GeneracionCvv2(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request Publicidad: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarGenerarCvv2(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response Publicidad " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/consultaVersion/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ConsultaVersion(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request consultaVersion: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarConsultaVersion(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response consultaVersion " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/consultaCostos/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String ConsultaCostos(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request consultaCostos: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarConsultaCostos(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response consultaCostos " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@POST
	@Path("/inspektor/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String inspektor(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request inspektor: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarInspector(transaccionJson);

		Log.getInstance().info(
				"Response inspektor " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr, getClass());

		return respuestaStr;

	}

	@GET
	@Path("/generarOtp/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String generarOtp(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request generarOtp: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarGenerarOtp(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response generarOtp " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}

	@GET
	@Path("/validarOtp/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String validarOtp(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request validarOtp: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarValidarOtp(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response validarOtp " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}
	
	@GET
	@Path("/omitirActualizacion/{transaccionJson}")
	@Produces("text/plain; charset=UTF-8")
	@Consumes("text/plain; charset=UTF-8")
	@DefaultValue("")
	public String omitirActualizacion(@PathParam("transaccionJson") String transaccionJson) throws Exception {

		String respuestaStr = null;

		long milliseconds = System.currentTimeMillis();

		Log.getInstance().info("Request omitirActualizacion: " + transaccionJson, getClass());

		respuestaStr = iMiddlewareServicio.realizarOmitirActualizacion(utilidadToken.desencriptarObjeto(transaccionJson));

		Log.getInstance().info(
				"Response omitirActualizacion " + (System.currentTimeMillis() - milliseconds) + " : " + respuestaStr,
				getClass());

		return utilidadToken.encriptarObjeto(respuestaStr);

	}
}
