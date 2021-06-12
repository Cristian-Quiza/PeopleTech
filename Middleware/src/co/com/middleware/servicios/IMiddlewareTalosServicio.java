package co.com.middleware.servicios;

import com.sun.jersey.core.header.FormDataContentDisposition;

public interface IMiddlewareTalosServicio {
	
	public String realizarechoTestTalos() throws Exception;
	
	public String realizarCrearTarjetaHabiente(String tramaRequest) throws Exception;

	public String realizarCiudad(String tramaRequest) throws Exception;

	public String realizarDepartamentos(String tramaRequest) throws Exception;

	public String realizarLogin(String tramaRequest) throws Exception;

	public String realizarCrearSolicitud(String tramaRequest) throws Exception;

	public String realizarIndicadorLogin(String tramaRequest) throws Exception;

	public String realizarArchivoSolicitud(String tramaRequest) throws Exception;

	public String realizarMatiSolicitud(String tramaRequest) throws Exception;

	public String realizarValidarOtp(String tramaRequest) throws Exception;

	public String realizarPais() throws Exception;

	public String realizarGenerarOtp(String tramaRequest) throws Exception;

	public String realizarConsultaTerminosYCondiciones() throws Exception;

	public String realizarGenero() throws Exception;

	public String realizarDatosSolicitud(String tramaRequest) throws Exception;

	public String realizarCrearArchivos(String tramaRequest) throws Exception;

	public String realizarAdministrador(String tramaRequest, FormDataContentDisposition fileMetaData) throws Exception;
	
	public String realizarConsultarListas(String transaccion) throws Exception;

	public String realizarPreguntasSeguro() throws Exception;

	public String realizarTipoDocumento() throws Exception;

	public String realizarCreaActuaRespuestaSeguro(String tramaRequest) throws Exception;

	public String realizarDatosAdicionales(String tramaRequest) throws Exception;

	public String realizarConsultarProfesion() throws Exception;

	public String realizarFinalizarMati(String tramaRequest) throws Exception;

	public String realizarPreguntasBasicasSolicitud(String tramaRequest) throws Exception;

	public String realizarSolicitudes(String tramaRequest) throws Exception;


		

}
