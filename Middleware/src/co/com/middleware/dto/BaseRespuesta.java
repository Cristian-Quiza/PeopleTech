package co.com.middleware.dto;

public class BaseRespuesta {

	public BaseRespuesta(Integer codigoRespuesta, String descripcionRespuesta) {
		super();
		CodigoRespuesta = codigoRespuesta;
		DescripcionRespuesta = descripcionRespuesta;
	}

	private Integer CodigoRespuesta;

	private String DescripcionRespuesta;

	public Integer getCodigoRespuesta() {
		return CodigoRespuesta;
	}

	public void setCodigoRespuesta(Integer codigoRespuesta) {
		CodigoRespuesta = codigoRespuesta;
	}

	public String getDescripcionRespuesta() {
		return DescripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		DescripcionRespuesta = descripcionRespuesta;
	}

}
