package co.com.middleware.dto;

import java.util.List;

public class ServicioWeb {

	private String protocolo;
	private String direccion_ip;
	private int puerto;
	private String end_point;
	private String nombre_servicio;
	private int time_out;
	private String namespace;
	private String nombreParametro;
	private String core_id;
	private String service_id;
	



	private List<String> parametros;

	
	public List<String> getParametros() {
		return parametros;
	}

	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}	

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	
	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	
	
	public String getURL(){
		return protocolo + direccion_ip + ":" + puerto + end_point;
	}

	public String getNombreParametro() {
		return nombreParametro;
	}

	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	public String getDireccion_ip() {
		return direccion_ip;
	}

	public void setDireccion_ip(String direccion_ip) {
		this.direccion_ip = direccion_ip;
	}

	public String getEnd_point() {
		return end_point;
	}

	public void setEnd_point(String end_point) {
		this.end_point = end_point;
	}

	public int getTime_out() {
		return time_out;
	}

	public void setTime_out(int time_out) {
		this.time_out = time_out;
	}

	public String getCore_id() {
		return core_id;
	}

	public void setCore_id(String core_id) {
		this.core_id = core_id;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	

}
