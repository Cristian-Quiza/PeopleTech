package co.com.middleware.constantes;

public class MensajesConstantes {
	
	public static final String ERROR_USUARIO_NO_EXISTE = "Usuario no existe";
	public static final String ERROR_CONSULTADO_ULTIMO_ESTADO_ARCHIVO = "Ocurrio un error inesperado al consultar el ultimo estado de un archivo.";
	public static final String ERROR_CONSULTADO_ARCHIVO_SUBIDO = "Ocurrio un error inesperado al consultar un archivo cargado en el sistema.";
	public static final String ERROR_INSERTANDO_ARCHIVO_A_PROCESAR = "Ocurrio un error inesperado al insertar el registro de un archivo que se va a procesar.";
	public static final String ESTADO_ARCHIVO_NULO = "El estado del archivo es incorrecto o nulo, por favor revisar.";
	public static final String ERROR_CONSULTADO_ENTIDAD_POR_BIN = "Ocurrio un error inesperado al consultar la entidad a partir del BIN.";
	public static final String ENTIDAD_POR_BIN_NO_ENCONTRADA = "No se econtro ninguna entidad asociada al BIN a consultar.";
	public static final String ERROR_ARCHIVO_SUBIDO_NO_ENCONTRADO = "No se encontro un registro previo del archivo subido.";
	public static final String ERROR_INVOCANDO_PL_NM = "Error en la ejecucion del PL-SQL encargado de procesar el archivo de novedad monetaria.";
	public static final String ERROR_INVOCANDO_PL_NNM = "Error en la ejecucion del PL-SQL encargado de procesar el archivo de novedad NO monetaria.";
	public static final String ERROR_CONSULTA_ENTIDAD_TIPO_CUENTA = "Ocurrio un error al cunsultar los tipos de cuenta que tiene la entidad.";
	public static final String ERROR_CONSULTADO_ENTIDAD_SOBREFLEX = "Ocurrio un error inesperado al consultar las entidades para generar el archivo de sobreflex.";
	public static final String ERROR_CARGAR_PINES = "Ocurrio un error al cargar los pines.";
	public static final String ERROR_CARGAR_PIN_GENERICO = "Ocurrio un error al cargar pin generico de la entidad.";
	public static final String ERROR_AGREGANDO_PVN = "Ocurrio un error al agregar el PVN a la tarjeta en BD.";
	public static final String ERROR_CONSULTANDO_PARAMETRO = "Ocurrio un error al consultar el parametro.";
	public static final String ERROR_CONSULTANDO_SEQ_SOBREFLEX = "Error consultando la secuencia para el archivo de Sobreflex.";
	public static final String ERROR_CONSULTANDO_SEQ_TAR = "Error consultando la secuencia para el archivo de TAR.";
	public static final String BIN_NO_ENCONTRADO = "No se encontro el registro del bin.";
	public static final String ERROR_CONSULTA_BIN_BY_ID = "Ocurrio un error inesperado al consultar el Bin por Id.";
	public static final String ERROR_ACTUALIZANDO_UN_REGISTRO= "Ocurrio un error inesperado al actualizar un registro en la BD";
	public static final String ERROR_CONSULTADO_UN_REGISTRO= "Ocurrio un error inesperado al consultar en la BD";
	public static final String ERROR_INSERTANDO_UN_REGISTRO= "Ocurrio un error inesperado al insertar en la BD";
	
	
	/**
	 * MENSAJES ERROR PIN
	 */
	public static final String ERROR_PIN_CONSECUTIVOS_ASC = "El pin generado tiene numeros consecutivos ascendentes.";
	public static final String ERROR_PIN_CONSECUTIVOS_DESC = "El pin generado tiene numeros consecutivos descendentes.";
	public static final String ERROR_PIN_CARACTERES_IGUALES = "Todos los caracteres del pin son iguales.";
	public static final String ERROR_PIN_3_PRIMEROS_CARACTERES_IGUALES = "Los 3 primeros caracteres del pin son iguales.";
	public static final String ERROR_PIN_3_ULTIMOS_CARACTERES_IGUALES = "Los 3 ultimos caracteres del pin son iguales.";
	
	/**
	 * MENSAJES ERROR TARJETA
	 */
	
	public static final String ERROR_PAN = "Ocurrio un error al obtener el PAN a partir del Track2";
	public static final String ERROR_PARTIAL_PAN = "El tama�o del PAN es menor que el del Partial PAN";
}
