package co.com.middleware.constantes;

public class MiddlewareConstantes {

		
	public final static String RESPUESTA_EXITOSA= "1";
	public final static String APP_INGRESO= "app_people";
	public final static String SEGURIDAD_CERT = "configuracion/seguridad/certificadoMDLPeople.txt";
	public final static String SEGURIDAD_CERT_TALOS = "/var/lib/tomcat/bin/configuracion/seguridad/certificadoApp.txt";
	public final static String SEGURIDAD_DER_TALOS ="/var/lib/tomcat/bin/configuracion/seguridad/certificadoMdlTalos.der";
	public final static String SEGURIDAD_DER ="configuracion/seguridad/MdlCertificate.der";
	public static final String TAG_SOAP_RESPUESTA = null;
	
	public static void main(String[] args) {
		String[] data = "Número de consulta: 108353#Cantidad de coincidencias: 3#No: 1|Prioridad: 2|Tipo documento: NIT|Numero documento: 805007818|Nombre: ASESORES CONSULTORES ASOCIADOS LTDA|Número tipo lista: 4|Lista: Lista OFAC#No: 2|Prioridad: 2|Tipo documento: NIT|Numero documento: 805007818|Nombre: ACA LTDA|Número tipo lista: 4|Lista: Lista OFAC#No: 3|Prioridad: -1|Tipo documento: |Numero documento: 830078000|Nombre: CEMENTOS DE COLOMBIA LTDA|Número tipo lista: -99|Lista: Lista Propia".split("#");
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
