package co.com.middleware.negocio;


import co.com.middleware.broker.ConsultaBroker;
import co.com.middleware.cliente.dataservice.SoapClientInspektor;
import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middleware.dto.TransaccionDTO;
import co.com.middlware.excepciones.NegocioExcepcion;

public class Inspektor {

	public RespuestaDataService procesarConsultaInspektor(TransaccionDTO transaccionDTO) throws NegocioExcepcion {
		
		RespuestaDataService respuestaRS = null;
		RespuestaDataService respuestaDispositivo = null;

		if(transaccionDTO.getNumero_documento().equals("") || transaccionDTO.getNumero_documento() == null ||
				transaccionDTO.getNombre_completo() == null || transaccionDTO.getNombre_completo().equals("")) {
			respuestaRS = new RespuestaDataService();
			
			respuestaRS.setCodigo_respuesta(MensajesErrorConstantes.CODIGO_ERROR_GENERAL);			
			respuestaRS.setMensaje_respuesta(MensajesErrorConstantes.MENSAJE_ERROR_GENERAL);
			
			return respuestaRS;	
		}
		
		SoapClientInspektor clientInspektor = new SoapClientInspektor();
		
		clientInspektor.getControlList(transaccionDTO.getNombre_completo(), transaccionDTO.getNumero_documento());
		
		respuestaRS = ConsultaBroker.getInstancia().PagarTarjetaInvitado(transaccionDTO);

		return respuestaRS;
	}
}
