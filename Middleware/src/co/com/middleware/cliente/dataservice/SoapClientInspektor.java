package co.com.middleware.cliente.dataservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import co.com.middleware.broker.MiddlewareDSBroker;
import co.com.middleware.constantes.MensajesErrorConstantes;
import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middleware.constantes.NombresPropertiesConstantes;
import co.com.middleware.log.Log;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.PropiedadesManager;

public class SoapClientInspektor {

	public void getControlList(String nombre, String numeroDocumento) throws NegocioExcepcion {
		
		String wsURL = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT_INSPEKTOR); 
				//"https://inspektortest.datalaft.com:76/WSInspektor.asmx?WSDL";
		String passWsdl = PropiedadesManager.getInstance().getProperty(NombresPropertiesConstantes.SERVICIO_ENDPOINT_INSPEKTOR_PASS); 
		URL url = null;
		URLConnection connection = null;
		HttpURLConnection httpConn = null;
		String responseString = null;
		String outputString = "";
		OutputStream out = null;
		InputStreamReader isr = null;
		BufferedReader in = null;

		String xmlInput = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n" 
				+ "    <LoadWSInspektor xmlns=\"http://tempuri.org/\">\r\n" 
				+ "      <Numeiden>"+ numeroDocumento + "</Numeiden>\r\n" 
				+ "      <Nombre>" + nombre + "</Nombre>\r\n"
				+ "      <Password>"+passWsdl+"</Password>\r\n" 
				+ "    </LoadWSInspektor>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";

		try {
			url = new URL(wsURL);
			connection = url.openConnection();
			httpConn = (HttpURLConnection) connection;

			byte[] buffer = new byte[xmlInput.length()];
			buffer = xmlInput.getBytes();
			
			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			out = httpConn.getOutputStream();
			out.write(buffer);
			out.close();

			// Read the response and write it to standard out.
			isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
			in = new BufferedReader(isr);

			while ((responseString = in.readLine()) != null) {
				outputString = outputString + responseString;
			}
			// Get the response from the web service call
			Document document = parseXmlFile(outputString);

			NodeList nodeLst = document.getElementsByTagName(MiddlewareConstantes.TAG_SOAP_RESPUESTA);
			
			String webServiceResponse = nodeLst.item(0).getTextContent();
			
			System.out.println(webServiceResponse);

		} catch (ClientProtocolException e) {
			Log.getInstance().error("[ClientProtocolException] SoapClientInspektor -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, SoapClientInspektor.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_INSPEKTOR_RECHAZADA,
					MensajesErrorConstantes.MENSAJE_INSPEKTOR_RECHAZADA);
		} catch (IOException e) {
			Log.getInstance().error("[IOException] SoapClientInspektor -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, SoapClientInspektor.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_INSPEKTOR_RECHAZADA,
					MensajesErrorConstantes.MENSAJE_INSPEKTOR_RECHAZADA);
		} catch (Exception e) {
			Log.getInstance().error("[Exception] SoapClientInspektor -> consumirServicio",
					MiddlewareDSBroker.class);
			Log.getInstance().error(e, SoapClientInspektor.class);
			throw new NegocioExcepcion(MensajesErrorConstantes.CODIGO_INSPEKTOR_RECHAZADA,
					MensajesErrorConstantes.MENSAJE_INSPEKTOR_RECHAZADA);
		}
	}


	private Document parseXmlFile(String in) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(in));
			return db.parse(is);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

//	public static void main(String[] args) throws IOException {
//		// Code to make a webservice HTTP request
//		String responseString = "";
//		String outputString = "";
//		String wsEndPoint = "https://inspektortest.datalaft.com:76/WSInspektor.asmx?WSDL";
//		URL url = new URL(wsEndPoint);
//		URLConnection connection = url.openConnection();
//		HttpURLConnection httpConn = (HttpURLConnection) connection;
//		ByteArrayOutputStream bout = new ByteArrayOutputStream();
//		String xmlInput = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
//				"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
//				"  <soap:Body>\r\n" + 
//				"    <LoadWSInspektor xmlns=\"http://tempuri.org/\">\r\n" + 
//				"      <Numeiden>805007818</Numeiden>\r\n" + 
//				"      <Nombre>CEMENTOS DE COLOMBIA LTDA</Nombre>\r\n" + 
//				"      <Password>|kPBDSHv-,0!26u</Password>\r\n" + 
//				"    </LoadWSInspektor>\r\n" + 
//				"  </soap:Body>\r\n" + 
//				"</soap:Envelope>";
//		byte[] buffer = new byte[xmlInput.length()];
//		buffer = xmlInput.getBytes();
//		bout.write(buffer);
//		byte[] b = bout.toByteArray();
//		String SOAPAction = "LoadWSInspektor";
//		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
////		httpConn.setRequestProperty("SOAPAction", SOAPAction);
//		httpConn.setRequestMethod("POST");
//		httpConn.setDoOutput(true);
//		httpConn.setDoInput(true);
//		OutputStream out = httpConn.getOutputStream();
//		// Write the content of the request to the outputstream of the HTTP
//		// Connection.
//		out.write(b);
//		out.close();
//		// Ready with sending the request.
//		// Read the response.
//		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
//		BufferedReader in = new BufferedReader(isr);
//		// Write the SOAP message response to a String.
//		while ((responseString = in.readLine()) != null) {
//						outputString = outputString + responseString;
//		}
//		// Write the SOAP message formatted to the console.
//		String formattedSOAPResponse = parseXmlFile(outputString);
//		System.out.println(formattedSOAPResponse);
//	}
//	// format the XML in pretty String
//	private static String formatXML(String unformattedXml) {
//		try {
//			Document document = parseXmlFile(unformattedXml);
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			transformerFactory.setAttribute("indent-number", 3);
//			Transformer transformer = transformerFactory.newTransformer();
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//			DOMSource source = new DOMSource(document);
//			StreamResult xmlOutput = new StreamResult(new StringWriter());
//			transformer.transform(source, xmlOutput);
//			return xmlOutput.getWriter().toString();
//		} catch (TransformerException e) {
//			throw new RuntimeException(e);
//		}
//	}
	// parse XML
//	private static Document parseXmlFile(String in) {
//		try {
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			InputSource is = new InputSource(new StringReader(in));
//			return db.parse(is);
//		} catch (IOException | ParserConfigurationException | SAXException e) {
//			throw new RuntimeException(e);
//		}
//	}

}
