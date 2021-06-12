package co.com.middleware.servicios;

public interface IMiddlewareServicio {

	
	public String realizarEchoTest() throws Exception;	
	
	public String realizarLogin(String tramaRequest) throws Exception;
	
	public String realizarTerminosCondiciones(String tramaRequest) throws Exception;
	
	public String realizarInvitarPagoTarjeta(String tramaRequest) throws Exception;
	
	public String realizarCambioContrasena(String tramaRequest) throws Exception;
	
	public String realizarClaveTransaccional(String tramaRequest) throws Exception;
	
	public String realizarActualizarContacto(String tramaRequest) throws Exception;
	
	public String realizarConsultaProductosTH(String tramaRequest) throws Exception;
	
	public String realizarCreaActualizaTH(String tramaRequest) throws Exception;
	
	public String realizarAsociarTarjeta(String tramaRequest) throws Exception;
	
	public String realizarNotificacionesTH(String tramaRequest) throws Exception;
	
	public String realizarDesasociarTarjetaCorpo(String tramaRequest) throws Exception;
	
	public String realizarConsultaMovimientosTarjeta(String tramaRequest) throws Exception;
	
	public String realizarCobrarTarjeta(String tramaRequest) throws Exception;
	
	public String realizarGuardarIconoPerfil(String tramaRequest, String imagen) throws Exception;
	
	public String realizarCambiarEstadoTarjeta(String tramaRequest) throws Exception;
	
	public String realizarCrearSoporte(String tramaRequest) throws Exception;
	
	public String realizarEliminarCuentaTranf(String tramaRequest) throws Exception;
	
	public String realizarActualizaNotificacion(String tramaRequest) throws Exception;
	
	public String realizarRecuperarContrasena(String tramaRequest) throws Exception;
	
	public String realizarAgregadoMovimientos(String tramaRequest) throws Exception;
	
	public String realizarSolicitaTarjetaPropia(String tramaRequest) throws Exception;
	
	public String realizarSolicitaTarjetaAmparada(String tramaRequest) throws Exception;
	
	public String realizarTransferencia(String tramaRequest) throws Exception;
	
	public String realizarConsultaAmparadas(String tramaRequest) throws Exception;
	
	public String realizarInscribirOtraTarjeta(String tramaRequest) throws Exception;
	
	public String realizarTarjetasInscritas(String tramaRequest) throws Exception;
	
	public String realizarValidarClaveTrans(String tramaRequest) throws Exception;
	
	public String realizarConsultaEstadoLlaveM(String tramaRequest) throws Exception;
	
	public String realizarConsultaAbonosLlaveMaestra(String tramaRequest) throws Exception;
	
	public String realizarLegalizarAbono(String tramaRequest, String imageStr) throws Exception;
	
	public String realizarRecargar(String tramaRequest) throws Exception;
	
	public String realizarMovimientosTarjetaLlaveMaestra(String tramaRequest) throws Exception;
	
	public String realizarReversoLLaveMaestra(String tramaRequest) throws Exception;

	public String realizarValidaUsuario(String tramaRequest) throws Exception;
	
	public String realizarPais(String tramaRequest) throws Exception;
	
	public String realizarConsultaDepartamentos(String tramaRequest) throws Exception;
	
	public String realizarConsultaCiudades(String tramaRequest) throws Exception;
	
	public String realizarConsultaPublicidad(String tramaRequest) throws Exception;	
	
	public String realizarConfiguracionEcommerce(String tramaRequest) throws Exception;
	
	public String realizarGenerarCvv2(String tramaRequest) throws Exception;
	
	public String realizarConsultaVersion(String tramaRequest) throws Exception;

	public String realizarConsultaCostos(String desencriptarObjeto) throws Exception;

	public String realizarValidaTitularidad(String desencriptarObjeto)throws Exception;

	public String realizarPagarTarjetaInvitado(String desencriptarObjeto)throws Exception;

	public String realizarInspector(String tramaRequest) throws Exception;

	public String realizarActivarEcommerce(String tramaRequest) throws Exception;

	public String realizarGenerarOtp(String tramaRequest) throws Exception;

	public String realizarValidarOtp(String tramaRequest) throws Exception;

	public String realizarOmitirActualizacion(String tramaRequest) throws Exception;
	
}
