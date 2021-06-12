package co.com.middleware.servicios.implementacion;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middleware.log.Log;
import co.com.middleware.negocio.Consulta;
import co.com.middleware.negocio.EchoTest;
import co.com.middleware.negocio.Inspektor;
import co.com.middleware.negocio.LlaveMaestra;
import co.com.middleware.negocio.Login;
import co.com.middleware.negocio.Otp;
import co.com.middleware.negocio.Perfil;
import co.com.middleware.negocio.Solicitud;
import co.com.middleware.negocio.Tarjeta;
import co.com.middleware.negocio.Transferencias;
import co.com.middleware.servicios.IMiddlewareServicio;

public class MiddlewareImpl implements IMiddlewareServicio {

	@Override
	public String realizarLogin(String tramaRequest) throws UnsupportedEncodingException {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Login login = new Login();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;		
		
		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = login.procesarLogin(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}
	
	@Override
	public String realizarValidaTitularidad(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Login login = new Login();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;		
		
		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = login.procesarValidaTitularidad(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarTerminosCondiciones(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarTerminosCondiciones(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarInvitarPagoTarjeta(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Solicitud solicitud = new Solicitud();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = solicitud.procesarInvitarPagoTarjeta(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarCambioContrasena(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarCambioContrasena(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarClaveTransaccional(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarCrearClaveTranx(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarActualizarContacto(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarActualizarContacto(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()),"iso-8859-1");

		return respuestaStr;
	}

	@Override
	public String realizarConsultaProductosTH(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarConsultaProductosTH(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarCreaActualizaTH(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarRegistrarUsuario(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarAsociarTarjeta(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Tarjeta tarjeta = new Tarjeta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = tarjeta.procesarAsociarTarjetaCorporativa(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarNotificacionesTH(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarConsultaNotificaciones(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarDesasociarTarjetaCorpo(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Tarjeta tarjeta = new Tarjeta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = tarjeta.procesarDesasociarTarjetaCorporativa(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultaMovimientosTarjeta(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Solicitud solicitud = new Solicitud();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = solicitud.procesarConsultaMovimientosProducto(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarCobrarTarjeta(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Tarjeta tarjeta= new Tarjeta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = tarjeta.procesarPagarTarjetaWPeople(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarGuardarIconoPerfil(String tramaRequest, String imagen) throws Exception {
		
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil= new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes()), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarIconoPerfil(transaccionDTO, imagen);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarCambiarEstadoTarjeta(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Tarjeta tarjeta = new Tarjeta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = tarjeta.procesarCambiaEstadoTarjetea(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarCrearSoporte(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Solicitud solicitud= new Solicitud();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = solicitud.procesarCrearSoporte(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarEliminarCuentaTranf(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Transferencias transferencias= new Transferencias();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = transferencias.procesarEliminarCuentaTranf(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarActualizaNotificacion(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarActualizarNotificacion(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarRecuperarContrasena(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarRecuperarContrasena(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarAgregadoMovimientos(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta= new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesarAgregadoMovimientos(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarSolicitaTarjetaPropia(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Solicitud solicitud= new Solicitud();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = solicitud.procesarPedirTarjetaPropia(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarSolicitaTarjetaAmparada(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Solicitud solicitud= new Solicitud();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = solicitud.procesarPedirTarjetaAmparada(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarTransferencia(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Transferencias transferencias= new Transferencias();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = transferencias.procesarTransferencia(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultaAmparadas(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta = new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesarConsultaAmparadas(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarInscribirOtraTarjeta(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarInscribirTarjeta(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarTarjetasInscritas(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarTarjetasInscritas(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarValidarClaveTrans(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarValidarClaveTranx(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultaEstadoLlaveM(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		LlaveMaestra llaveMaestra= new LlaveMaestra();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = llaveMaestra.procesarConsultaEstadoLlaveM(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultaAbonosLlaveMaestra(String tramaRequest) throws Exception {
		
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		LlaveMaestra llaveMaestra= new LlaveMaestra();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = llaveMaestra.procesarConsultaAbonosLlaveMaestra(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarLegalizarAbono(String tramaRequest, String img) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		LlaveMaestra llaveMaestra= new LlaveMaestra();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = llaveMaestra.procesarLegalizarAbono(transaccionDTO,img);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}
	
	@Override
	public String realizarMovimientosTarjetaLlaveMaestra(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		LlaveMaestra llaveMaestra= new LlaveMaestra();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = llaveMaestra.procesarMovimientosTarjetaLlaveMaestra(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarReversoLLaveMaestra(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		LlaveMaestra llaveMaestra= new LlaveMaestra();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = llaveMaestra.procesarrReversoLLaveMaestra(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarRecargar(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Tarjeta tarjeta= new Tarjeta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = tarjeta.procesarRecarga(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	

	@Override
	public String realizarValidaUsuario(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarValidaUsuario(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarPais(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta = new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesarPais(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultaDepartamentos(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta = new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesarConsultaDepartamentos(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultaCiudades(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta = new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesarConsultaCiudades(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}
	
	@Override
	public String realizarConsultaPublicidad(String tramaRequest) throws Exception {

		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta = new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesarConsultaPublicidad(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConfiguracionEcommerce(String tramaRequest) throws Exception {
		
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Transferencias transferencias = new Transferencias();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = transferencias.procesarConfiguracionEcommerce(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}
	
	@Override
	public String realizarGenerarCvv2(String tramaRequest) throws Exception {
		
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Tarjeta tarjeta = new Tarjeta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = tarjeta.procesarGenerarCvv2(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}
	
	@Override
	public String realizarConsultaVersion(String tramaRequest) throws Exception {
		
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta= new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesaConsultaVersion(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarConsultaCostos(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta= new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesaConsultaCostos(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarPagarTarjetaInvitado(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Consulta consulta= new Consulta();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = consulta.procesaPagarTarjetaInvitado(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarInspector(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Inspektor inspektor= new Inspektor();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = inspektor.procesarConsultaInspektor(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarActivarEcommerce(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Transferencias transferencias = new Transferencias();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = transferencias.procesarActivarEcommerce(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarGenerarOtp(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Otp otp = new Otp();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = otp.procesarGenerarOtp(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarValidarOtp(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Otp otp = new Otp();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = otp.procesarValidarOtp(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarOmitirActualizacion(String tramaRequest) throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		Perfil perfil = new Perfil();
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		String respuestaStr = null;
		String transaccionJson = null;

		transaccionJson = new String(base64.decode(tramaRequest.getBytes("iso-8859-1")), "iso-8859-1");

		transaccionDTO = gson.fromJson(transaccionJson, TransaccionDTO.class);

		Log.getInstance().debug("transaccionDTO " + transaccionJson, getClass());

		respuesta = perfil.procesarOmitirActualizacion(transaccionDTO);

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes()));

		return respuestaStr;
	}

	@Override
	public String realizarEchoTest() throws Exception {
		RespuestaDataService respuesta = new RespuestaDataService();
		Base64 base64 = new Base64();
		Gson gson = new Gson();
		EchoTest echoTest = new EchoTest();
		String respuestaStr = null;

		respuesta = echoTest.procesarTransaccionEcho();

		respuestaStr = new String(base64.encode(gson.toJson(respuesta).getBytes("iso-8859-1")));

		return respuestaStr;
	}

	

}
