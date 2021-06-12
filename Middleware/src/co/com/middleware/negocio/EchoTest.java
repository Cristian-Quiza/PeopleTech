package co.com.middleware.negocio;

import co.com.middleware.broker.MiddlewareDSBroker;
import co.com.middleware.dto.RespuestaDataService;
import co.com.middlware.excepciones.NegocioExcepcion;

public class EchoTest {

	public RespuestaDataService procesarTransaccionEcho() throws NegocioExcepcion {

		RespuestaDataService respuestaRS = null;

		respuestaRS = MiddlewareDSBroker.getInstancia().echoTest();

		return respuestaRS;

	}

}
