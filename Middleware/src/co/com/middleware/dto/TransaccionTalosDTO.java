package co.com.middleware.dto;

public class TransaccionTalosDTO {
	
	//Administrador
	private String extension;
	private String tarjeta_habiente;
	private String user;
	private String pwd;
	private String pk_solicitud;
	private String tipo_archivo;
	
	//ArchivoPost
	private String solicitud;
	private String indicador;
	
	//ConsultarListas
	private String identificacion;
	private String nombre;
	private String tipoid;
	
	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoid() {
		return tipoid;
	}

	public void setTipoid(String tipoid) {
		this.tipoid = tipoid;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getTarjeta_habiente() {
		return tarjeta_habiente;
	}

	public void setTarjeta_habiente(String tarjeta_habiente) {
		this.tarjeta_habiente = tarjeta_habiente;
	}
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPk_solicitud() {
		return pk_solicitud;
	}

	public void setPk_solicitud(String pk_solicitud) {
		this.pk_solicitud = pk_solicitud;
	}

	public String getTipo_archivo() {
		return tipo_archivo;
	}

	public void setTipo_archivo(String tipo_archivo) {
		this.tipo_archivo = tipo_archivo;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	
	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
}

