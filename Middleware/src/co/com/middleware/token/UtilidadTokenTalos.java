package co.com.middleware.token;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;

import javax.crypto.SecretKey;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jwt.EncryptedJWT;

import co.com.middleware.constantes.MiddlewareConstantes;
import co.com.middlware.excepciones.NegocioExcepcion;
import co.com.middlware.utilidades.EnumManejoErrores;


public class UtilidadTokenTalos {

	static RSAPublicKey publicKey = null;

	static RSAPrivateKey privateKey = null;

	static PublicKey publicLlave = null;

	static PrivateKey privateLlave = null;

	static JWEAlgorithm alg = JWEAlgorithm.RSA_OAEP_256;

	static EncryptionMethod enc = EncryptionMethod.A256CBC_HS512;

	static SecretKey cek;

	Date now = new Date();	
//encriptar 
	public String encriptarObjeto(String objTokenizar) {
		
		String objetoRespuesta = null;
		
		try {			
			
			publicKey = getPublicKey();
			
			JWEObject jwe = new JWEObject(new JWEHeader(alg, enc), new Payload(objTokenizar));

			jwe.encrypt(new RSAEncrypter((RSAPublicKey) publicKey, cek));

			objetoRespuesta = jwe.serialize();

			return objetoRespuesta;

		} catch (JOSEException e) {
			new Exception(EnumManejoErrores.ERROR_PROCESO_TRANSACCION.getValue());		
		} catch (FileNotFoundException e1) {		
			e1.printStackTrace();
		} catch (CertificateException e1) {
			e1.printStackTrace();
		}

		return objetoRespuesta;
	}
	//desencriptar SEGURIDAD_DER_TALOS donde se extrae una llave privada 
	public String desencriptarObjeto(String jweString) {

		String objetoRespuesta = null;
		
		try {
			byte[] keyBytes = Files.readAllBytes(new File(MiddlewareConstantes.SEGURIDAD_DER_TALOS).toPath());
			
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
			
			KeyFactory kf = KeyFactory.getInstance("RSA");
			
			PrivateKey pk = kf.generatePrivate(spec);
			
			EncryptedJWT jwt = EncryptedJWT.parse(jweString);
			
			RSADecrypter decrypter = new RSADecrypter(pk);
			
			jwt.decrypt(decrypter);
			
			objetoRespuesta = jwt.getPayload().toString();

		} catch (ParseException e) {			
			new NegocioExcepcion("98","Parametros Incorrectos");
		} catch (Exception e) {					
			new NegocioExcepcion("98","Parametros Incorrectos");
		}
		return objetoRespuesta;

	}
	

	
	private static RSAPublicKey getPublicKey() throws FileNotFoundException, CertificateException {

		File file = new File(MiddlewareConstantes.SEGURIDAD_CERT_TALOS);//extrae la llave privada
		Charset charset = StandardCharsets.UTF_8;
		String content = null;
		
		try (InputStream in = new FileInputStream(file)) {
			
			byte[] bytes = new byte[(int) file.length()];
			in.read(bytes);

			content = new String(bytes, charset);			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
		
		ByteArrayInputStream bytes = new ByteArrayInputStream(content.getBytes());
		
		X509Certificate xcert = (X509Certificate) certFactory.generateCertificate(bytes);
		
		PublicKey myPrivKey = xcert.getPublicKey();
		
		return (RSAPublicKey) myPrivKey;

	}


}
