package co.com.middlware.utilidades;

import org.apache.commons.lang.StringUtils;


public class UtilidadString {
	
	/**
	 * Metodo encargado de verificar si un
	 * String se encuentra nulo o vacio.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return  StringUtils.isEmpty(str);
	}
	
	/**
	 * Metodo encargado de vierificar que un
	 * Strin NO se encuentr nulo o vacio.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return  StringUtils.isNotEmpty(str);
	}
	
	/**
	 * Comprueba si una cadena es un espacio en blanco,
	 * se encuentra vacia o esta nula.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		return  StringUtils.isBlank(str);
	}
	
	/**
	 * Comprueba que una cadena no sea solo espacios en blanco,
	 * no se encuentra vacia o no esta nula.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str){
		return  StringUtils.isNotBlank(str);
	}
	
	/**
	 * Metodo encargado de remover los espacios al principio
	 * y al final de un String.
	 * 
	 * si llega null, retorna ""
	 * 
	 * @param str
	 * @return
	 */
	public static String trimToEmpty(String str){
		return StringUtils.trimToEmpty(str);
	}
	
	/**
	 * Metodo encargado de remover los espacios al principio
	 * y al final de un String.
	 * 
	 * si llega null, retorna ""
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str){
		return StringUtils.trim(str);
	}
	
	/**
	 * Metodo encargado de remover los espacios al principio
	 * y al final de un String.
	 * 
	 * si llega null, retorna ""
	 * 
	 * @param str
	 * @return
	 */
	public static String trimToNull(String str){
		return StringUtils.trim(str);
	}
	
	/**
	 * Similar al trim, solo que si la cadena llega vacia 
	 * o nula, entonces retorna null.
	 * 
	 * @param str
	 * @return
	 */
	public static String strip(String str){
		return StringUtils.strip(str);
	}
	
	/**
	 * Similar al trim, solo que si la cadena llega vacia 
	 * o nula, entonces retorna null.
	 * 
	 * @param str
	 * @return
	 */
	public static String stripToEmpty(String str){
		return StringUtils.stripToEmpty(str);
	}
	
	/**
	 * Elimina los caracteres que coincidan enviados en 
	 * la variable stripChars de la cadena srt.
	 * strip(null, *)          = null
	 * strip("", *)            = ""
	 * strip("abc", null)      = "abc"
	 * strip("  abcyx", "xyz") = "  abc"
	 * 
	 * @param str
	 * @param stripChars
	 * @return
	 */
	public static String strip(String str, String stripChars){
		return StringUtils.strip(str, stripChars);
	}
	
	/**
	 * Elimina los caracteres que coincidan enviados en 
	 * la variable stripChars al principio de la cadena srt.
	 * 
	 * la variable stripChars del principio de la cadena srt.
	 * strip(null, *)          = null
	 * strip("", *)            = ""
	 * strip("abc", null)      = "abc"
	 * strip("  abcyx", "xyz") = "  abc"
	 * 
	 * @param str
	 * @param stripChars
	 * @return
	 */
	public static String stripStart(String str, String stripChars){
		return StringUtils.stripStart(str, stripChars);
	}
	
	/**
	 * Pone la primera letra de una cadena en minuscula.
	 * 
	 * uncapitalize(null)  = null
	 * uncapitalize("")    = ""
	 * uncapitalize("Cat") = "cat"
	 * uncapitalize("CAT") = "cAT"
	 * 
	 * @param str
	 * @return
	 */
	public static String uncapitalize(String str){
		return StringUtils.uncapitalize(str);
	}
	
	/**
	 * Pone la primera letra de una cadena en mayuscula
	 * 
	 * capitalize(null)  = null
	 * capitalize("")    = ""
	 * capitalize("cat") = "Cat"
	 * capitalize("cAt") = "CAt"
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalize(String str){
		return StringUtils.capitalize(str);
	}
	
	/**
	 * Centra una cadena de texto con el tama�o dado en el
	 * campo size.
	 * 
	 * center(null, *)   = null
	 * center("", 4)     = "    "
	 * center("ab", -1)  = "ab"
	 * center("ab", 4)   = " ab "
	 * center("abcd", 2) = "abcd"
	 * center("a", 4)    = " a  "
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public static String center(String str, int size){
		return StringUtils.center(str, size);
	}
	
	/**
	 * Centra una cadena de texto con el tama�o dado en el
	 * campo size y rellenando el tama�o con el valor del 
	 * campo padStr.
	 * 
	 * center(null, *, *)     = null 
	 * center("", 4, " ")     = "    "
	 * center("ab", -1, " ")  = "ab"
	 * center("ab", 4, " ")   = " ab"
	 * center("abcd", 2, " ") = "abcd"
	 * center("a", 4, " ")    = " a  "
	 * center("a", 4, "yz")   = "yayz"
	 * center("abc", 7, null) = "  abc  "
	 * center("abc", 7, "")   = "  abc  "
	 * 
	 * @param str
	 * @param size
	 * @param padStr
	 * @return
	 */
	public static String center(String str,
            int size, String padStr){
		return StringUtils.center(str, size, padStr);
	}
	
	/**
	 * Rellena una cadena de texto con espacios en blanco a la derecha
	 * el nunmero de espacios es definido por el campo size.
	 * @param str
	 * @param size
	 * @return
	 */
	public static String rightPad(String str, int size){
		return StringUtils.rightPad(str, size);
	}
	
	/**
	 * Rellena una cadena de texto con el valor del campo padChar a la
	 * derecha, el nunmero de espacios es definido por el campo size.
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return
	 */
	public static String rightPad(String str, int size, char padChar){
		return StringUtils.rightPad(str, size, padChar);
	}
	
	/**
	 * Rellena una cadena de texto con el valor del campo padChar a la
	 * derecha, el nunmero de espacios es definido por el campo size.
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return
	 */
	public static String rightFiller(String str, int size, char padChar){
		
		if(str == null){
			str = "";
		}
		
		if(str.length() >= size){
			return str.substring(0, size);
		}
		else{
			return StringUtils.rightPad(str, size, padChar);
		}
	}
	
	
	/**
	 * Rellena una cadena de texto con espacios en blanco a la izquierda
	 * el nunmero de espacios es definido por el campo size.
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public static String leftPad(String str, int size){
		return StringUtils.leftPad(str, size);
	}
	
	/**
	 * Rellena una cadena de texto con el valor del campo padChar a la
	 * izquierda, el nunmero de espacios es definido por el campo size.
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return
	 */
	public static String leftFiller(String str, int size, char padChar){
		
		if(str == null){
			str = "";
		}
		
		if(str.length() >= size){
			return str.substring(0, size);
		}
		else{
			return StringUtils.leftPad(str, size, padChar);
		}
	}
	
	/**
	 * Rellena una cadena de texto con el valor del campo padChar a la
	 * izquierda, el nunmero de espacios es definido por el campo size.
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return
	 */
	public static String leftPad(String str, int size, char padChar){
		return StringUtils.leftPad(str, size, padChar);
	}
	
	/**
	 * Convierte una cadena hexString a un arreglo de bytes.
	 * @param str
	 * @return
	 */
	public static byte[] hexStringToByteArray(String str) {

		int len = str.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
	                             + Character.digit(str.charAt(i+1), 16));
	    }
	    return data;
	}
	
	/**
	 * Convierte de BCD a String
	 * @param bcd
	 * @return
	 */
	public static String BCDtoString(byte bcd) {
		StringBuffer sb = new StringBuffer();

		byte high = (byte) (bcd & 0xf0);
		high >>>= (byte) 4;
		high = (byte) (high & 0x0f);
		byte low = (byte) (bcd & 0x0f);

		sb.append(high);
		sb.append(low);

		return sb.toString();
	}
	
	/**
	 * Convierte de BCD a String
	 * @param bcd
	 * @return
	 */
	public static String BCDtoString(byte[] bcd) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < bcd.length; i++) {
			sb.append(BCDtoString(bcd[i]));
		}

		return sb.toString();
	}
	
	/**
	 * Enmascara una cadena de texto
	 * @param cadenaAEnmascarrar
	 * @return
	 */
	public static String enMascarar(String cadenaAEnmascarrar)
	{
		 String s = cadenaAEnmascarrar.replaceAll("\\D", "");
		 int start = 7;
	     int end =s.length() - 4;
	     if (cadenaAEnmascarrar.length()<7)
	     {
	    	 start = 2;
	    	 end = s.length() - 2;
	     }
	     else if (cadenaAEnmascarrar.length()<9)
	     {
	    	 start = 3;
	    	 end = s.length() - 3;
	     }
	     String overlay = StringUtils.repeat("*", end - start);
	     return StringUtils.overlay(s, overlay, start, end);
	}
	
	public static String enMascararDocumento(String cadenaAEnmascarrar)
	{

		 String overlay = "";
		 int start = cadenaAEnmascarrar.length() - 6;
	     int end = cadenaAEnmascarrar.length() - 3;
	     String resultado = "****";
	     
	     overlay = StringUtils.repeat("*", 3);
	     
	     if(cadenaAEnmascarrar != null){
	    	 resultado = StringUtils.overlay(cadenaAEnmascarrar, overlay, start, end); 
	     }
	     	     
	     
	     return resultado;
		
		
	}
	
		
	
}
