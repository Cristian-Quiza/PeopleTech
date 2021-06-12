package co.com.middleware.dto;

import java.util.List;

public class RespuestaDataService {

	private String actualizacion_datos;
	private String fecha_vencimiento;
	/**Nuevos campos para ecommerce*/
	private String monto_maximo_ecommerce;
	private String cantidad_maximo_ecommerce;
	private String default_monto_ecommerce;
	private String default_cantidad_ecommerce;
	private String estado_ecommerce;
	private String monto_maximo_diario;
	private String cantidad_maximo_diario;
	private String fecha_cvc;
	/************************************/
	
	private String mensaje_respuesta;
	private String ultimo_acceso;
	private String numero_celular;
	private String email;
	private String ciudad;
	private String foto_perfil;
	private String direccion;
	private String segundo_apellido;
	private String primer_apellido;
	private String segundo_nombre;
	private String primer_nombre;
	private String pais;
	private String departamento_id;
	private String departamento;
	private String ciudad_id;
	private String pais_id;
	private String validacion_titularidad;
	private String core_id;
	/*Dispositivo*/
	private String actualizaDispositivo;
	private List<ServicioWeb> servicios_web;
	/* terminos y condiciones */
	private List<RespuestaDataService> terminos_condiciones;
	private String codigo_politica;
	private String url;
	private String obligatorio;
	private String nombre_politica;
	private String resumen_politica;
	/* Productos usuario*/
	private List<RespuestaDataService> producto_usuario;
	private List<RespuestaDataService> producto_corporativo;
	private String codigo_tarjeta;
	private String empresa;
	private String codigo_tarjeta_zeus;
	private String numero_documento;
	private String pan_enmascarado;
	private String saldo;
	private String codigo_producto;
	private String producto;
	private String estado_tarjeta;
	private String estado;
	private String motivo_bloqueo;
	private String ecomerce;	
	private String fecha_final;
	private String fecha_inicio;
	private String ecommerce_saldo;

	/*
	 * Movimientos tarjeta
	 */	
	private List<RespuestaDataService> movimientos_tarjeta;
	private String movimiento_id;
	private String numero_transaccion;
	private String origen_transaccion;
	private String monto;
	private String iva;
	private String inc;
	private String propina;
	private String nombre_comercio;
	private String codigo_respuesta;
	private String numero_aprobacion;
	private String tipo_movimiento;
	private String fecha_transaccion;
	private String hora_transaccion;
	private String terminal; 
	private String respuesta;	
	private String transaccion_afectada;
	/*
	 * entidad
	 */
	private String codigoentidad;	
	private String fechaCreacion;
	private String motivoEmision;
	private String numeroIntentos;
	private String estadoId;
	private String debeCambiarPin;
	private String cvv2;
	private Integer mensajeSistemaId;
	private String codigo;
	private String mensajeUsuario;
	private String mensajeSistema;
	private String numeroCuenta;
	/*Consultas*/
	private List<RespuestaDataService> lista_paises;
	private String nombre_pais;
	private String id;
	private List<RespuestaDataService> lista_ciudades;
	private String nombre_ciudad;
	private List<RespuestaDataService> lista_departamentos;
	private String nombre_departamento;
	/*Variable fecha servidor */
	private String fecha;
	/* Estado Tarjeta*/
	private String estadoTarjetaPlastico;
	private String estadoTarjetaVirtual;
	/* Consulta Parametro*/
	private String parametroId;
	private String nombre;
	private String descripcion;
	private String valor;
	/*Crea Entidad */
	private String codigoEntidad;	
	/*publicidad*/
	private List<RespuestaDataService> promociones;
	private String imagen;
	private String link;
	/*Agregado movimientos*/
	private String total;
	private String tipo_movimiento_id;
	/*pedir tarjeta propia*/
	private String referencia_pago;
	/*Tarjetas inscritas*/
	private List<RespuestaDataService> tarjetas_inscritas;
	private List<RespuestaDataService> notificaciones;
	private String fecha_creacion;	
	private String notificacion_numero;
	private String mensaje;
	private String fecha_visto;
	private String fecha_gestion;
	private String fecha_finalizacion;
	private String prioridad;
	/*Pago tarjeta con People*/
	private String costo_transferencia;
	/*Tarjetas amparadas*/
	private String nombre_th;
	private List<RespuestaDataService> tarjetas_amparadas;
	/*Imagen perfil*/
	/*version*/
	private String codigo_version;
	private List<RespuestaDataService> productos;	
	/*CONSULTA COSTOS*/
	private String costo_tarjeta;
	private String costo_envio;
	private String 	minimo_transferencia;
	private String iva_compra;
	private String iva_servicio;
	private String nombre_producto;
	/*LLAVE MAESTRA*/
	private List<RespuestaDataService> abonos_tarjeta;
	private String abotar_codigo;
	private String codigo_abono;
	private String movimiento_llavero;
	private String llavero_codigo;
	private String codigo_empresa;
	private String monto_abono;
	private String nombre_llavero;
	private String concepto;
	private String fecha_abono;
	private String saldo_pendiente;
	private String movimiento_legalizado;
	
	
	
	public String getEstado_ecommerce() {
		return estado_ecommerce;
	}

	public void setEstado_ecommerce(String estado_ecommerce) {
		this.estado_ecommerce = estado_ecommerce;
	}

	public String getMonto_maximo_diario() {
		return monto_maximo_diario;
	}

	public void setMonto_maximo_diario(String monto_maximo_diario) {
		this.monto_maximo_diario = monto_maximo_diario;
	}

	public String getCantidad_maximo_diario() {
		return cantidad_maximo_diario;
	}

	public void setCantidad_maximo_diario(String cantidad_maximo_diario) {
		this.cantidad_maximo_diario = cantidad_maximo_diario;
	}

	public String getMonto_maximo_ecommerce() {
		return monto_maximo_ecommerce;
	}

	public void setMonto_maximo_ecommerce(String monto_maximo_ecommerce) {
		this.monto_maximo_ecommerce = monto_maximo_ecommerce;
	}

	public String getCantidad_maximo_ecommerce() {
		return cantidad_maximo_ecommerce;
	}

	public void setCantidad_maximo_ecommerce(String cantidad_maximo_ecommerce) {
		this.cantidad_maximo_ecommerce = cantidad_maximo_ecommerce;
	}

	public String getDefault_monto_ecommerce() {
		return default_monto_ecommerce;
	}

	public void setDefault_monto_ecommerce(String default_monto_ecommerce) {
		this.default_monto_ecommerce = default_monto_ecommerce;
	}

	public String getDefault_cantidad_ecommerce() {
		return default_cantidad_ecommerce;
	}

	public void setDefault_cantidad_ecommerce(String default_cantidad_ecommerce) {
		this.default_cantidad_ecommerce = default_cantidad_ecommerce;
	}

	public String getCosto_tarjeta() {
		return costo_tarjeta;
	}

	public void setCosto_tarjeta(String costo_tarjeta) {
		this.costo_tarjeta = costo_tarjeta;
	}
	
	
	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	
	public String getEcomerce() {
		return ecomerce;
	}

	public void setEcomerce(String ecomerce) {
		this.ecomerce = ecomerce;
	}

	public String getCodigo_version() {
		return codigo_version;
	}

	public void setCodigo_version(String codigo_version) {
		this.codigo_version = codigo_version;
	}

	public String getNombre_pais() {
		return nombre_pais;
	}

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre_ciudad() {
		return nombre_ciudad;
	}

	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}

	

	public String getNombre_departamento() {
		return nombre_departamento;
	}

	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}

	

	/**
	 * @return the movimiento_id
	 */
	public String getMovimiento_id() {
		return movimiento_id;
	}

	/**
	 * @param movimiento_id the movimiento_id to set
	 */
	public void setMovimiento_id(String movimiento_id) {
		this.movimiento_id = movimiento_id;
	}

	/**
	 * @return the numero_transaccion
	 */
	public String getNumero_transaccion() {
		return numero_transaccion;
	}

	/**
	 * @param numero_transaccion the numero_transaccion to set
	 */
	public void setNumero_transaccion(String numero_transaccion) {
		this.numero_transaccion = numero_transaccion;
	}

	/**
	 * @return the origen_transaccion
	 */
	public String getOrigen_transaccion() {
		return origen_transaccion;
	}

	/**
	 * @param origen_transaccion the origen_transaccion to set
	 */
	public void setOrigen_transaccion(String origen_transaccion) {
		this.origen_transaccion = origen_transaccion;
	}

	/**
	 * @return the monto
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}

	/**
	 * @return the iva
	 */
	public String getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(String iva) {
		this.iva = iva;
	}

	/**
	 * @return the inc
	 */
	public String getInc() {
		return inc;
	}

	/**
	 * @param inc the inc to set
	 */
	public void setInc(String inc) {
		this.inc = inc;
	}

	/**
	 * @return the propina
	 */
	public String getPropina() {
		return propina;
	}

	/**
	 * @param propina the propina to set
	 */
	public void setPropina(String propina) {
		this.propina = propina;
	}

	/**
	 * @return the nombre_comercio
	 */
	public String getNombre_comercio() {
		return nombre_comercio;
	}

	/**
	 * @param nombre_comercio the nombre_comercio to set
	 */
	public void setNombre_comercio(String nombre_comercio) {
		this.nombre_comercio = nombre_comercio;
	}

	/**
	 * @return the codigo_respuesta
	 */
	public String getCodigo_respuesta() {
		return codigo_respuesta;
	}

	/**
	 * @param codigo_respuesta the codigo_respuesta to set
	 */
	public void setCodigo_respuesta(String codigo_respuesta) {
		this.codigo_respuesta = codigo_respuesta;
	}

	/**
	 * @return the numero_aprobacion
	 */
	public String getNumero_aprobacion() {
		return numero_aprobacion;
	}

	/**
	 * @param numero_aprobacion the numero_aprobacion to set
	 */
	public void setNumero_aprobacion(String numero_aprobacion) {
		this.numero_aprobacion = numero_aprobacion;
	}

	/**
	 * @return the tipo_movimiento
	 */
	public String getTipo_movimiento() {
		return tipo_movimiento;
	}

	/**
	 * @param tipo_movimiento the tipo_movimiento to set
	 */
	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	/**
	 * @return the fecha_transaccion
	 */
	public String getFecha_transaccion() {
		return fecha_transaccion;
	}

	/**
	 * @param fecha_transaccion the fecha_transaccion to set
	 */
	public void setFecha_transaccion(String fecha_transaccion) {
		this.fecha_transaccion = fecha_transaccion;
	}

	/**
	 * @return the hora_transaccion
	 */
	public String getHora_transaccion() {
		return hora_transaccion;
	}

	/**
	 * @param hora_transaccion the hora_transaccion to set
	 */
	public void setHora_transaccion(String hora_transaccion) {
		this.hora_transaccion = hora_transaccion;
	}

	/**
	 * @return the terminal
	 */
	public String getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the transaccion_afectada
	 */
	public String getTransaccion_afectada() {
		return transaccion_afectada;
	}

	/**
	 * @param transaccion_afectada the transaccion_afectada to set
	 */
	public void setTransaccion_afectada(String transaccion_afectada) {
		this.transaccion_afectada = transaccion_afectada;
	}

	
	/**
	 * @return the ultimo_acceso
	 */
	public String getUltimo_acceso() {
		return ultimo_acceso;
	}

	/**
	 * @param ultimo_acceso the ultimo_acceso to set
	 */
	public void setUltimo_acceso(String ultimo_acceso) {
		this.ultimo_acceso = ultimo_acceso;
	}

	/**
	 * @return the numero_celular
	 */
	public String getNumero_celular() {
		return numero_celular;
	}

	/**
	 * @param numero_celular the numero_celular to set
	 */
	public void setNumero_celular(String numero_celular) {
		this.numero_celular = numero_celular;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the foto_perfil
	 */
	public String getFoto_perfil() {
		return foto_perfil;
	}

	/**
	 * @param foto_perfil the foto_perfil to set
	 */
	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the segundo_apellido
	 */
	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	/**
	 * @param segundo_apellido the segundo_apellido to set
	 */
	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	/**
	 * @return the primer_apellido
	 */
	public String getPrimer_apellido() {
		return primer_apellido;
	}

	/**
	 * @param primer_apellido the primer_apellido to set
	 */
	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	/**
	 * @return the segundo_nombre
	 */
	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	/**
	 * @param segundo_nombre the segundo_nombre to set
	 */
	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	
	/**
	 * @return the motivoEmision
	 */
	public String getMotivoEmision() {
		return motivoEmision;
	}

	/**
	 * @param motivoEmision the motivoEmision to set
	 */
	public void setMotivoEmision(String motivoEmision) {
		this.motivoEmision = motivoEmision;
	}

	/**
	 * @return the mensajeSistemaId
	 */
	public Integer getMensajeSistemaId() {
		return mensajeSistemaId;
	}

	/**
	 * @param mensajeSistemaId the mensajeSistemaId to set
	 */
	public void setMensajeSistemaId(Integer mensajeSistemaId) {
		this.mensajeSistemaId = mensajeSistemaId;
	}

	/**
	 * @return the primer_nombre
	 */
	public String getPrimer_nombre() {
		return primer_nombre;
	}

	/**
	 * @param primer_nombre the primer_nombre to set
	 */
	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	

	/**
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the numeroIntentos
	 */
	public String getNumeroIntentos() {
		return numeroIntentos;
	}

	/**
	 * @param numeroIntentos the numeroIntentos to set
	 */
	public void setNumeroIntentos(String numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}

	/**
	 * @return the estadoId
	 */
	public String getEstadoId() {
		return estadoId;
	}

	/**
	 * @param estadoId the estadoId to set
	 */
	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	/**
	 * @return the debeCambiarPin
	 */
	public String getDebeCambiarPin() {
		return debeCambiarPin;
	}

	/**
	 * @param debeCambiarPin the debeCambiarPin to set
	 */
	public void setDebeCambiarPin(String debeCambiarPin) {
		this.debeCambiarPin = debeCambiarPin;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the mensajeUsuario
	 */
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	/**
	 * @param mensajeUsuario the mensajeUsuario to set
	 */
	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

	/**
	 * @return the mensajeSistema
	 */
	public String getMensajeSistema() {
		return mensajeSistema;
	}

	/**
	 * @param mensajeSistema the mensajeSistema to set
	 */
	public void setMensajeSistema(String mensajeSistema) {
		this.mensajeSistema = mensajeSistema;
	}

	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	
	public String getEstadoTarjetaPlastico() {
		return estadoTarjetaPlastico;
	}

	public void setEstadoTarjetaPlastico(String estadoTarjetaPlastico) {
		this.estadoTarjetaPlastico = estadoTarjetaPlastico;
	}

	public String getEstadoTarjetaVirtual() {
		return estadoTarjetaVirtual;
	}

	public void setEstadoTarjetaVirtual(String estadoTarjetaVirtual) {
		this.estadoTarjetaVirtual = estadoTarjetaVirtual;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getParametroId() {
		return parametroId;
	}

	public void setParametroId(String parametroId) {
		this.parametroId = parametroId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the codigoEntidad
	 */
	public String getCodigoEntidad() {
		return codigoEntidad;
	}

	/**
	 * @param codigoEntidad the codigoEntidad to set
	 */
	public void setCodigoEntidad(String codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}	

	

	

	/**
	 * @return the obligatorio
	 */
	public String getObligatorio() {
		return obligatorio;
	}

	/**
	 * @param obligatorio the obligatorio to set
	 */
	public void setObligatorio(String obligatorio) {
		this.obligatorio = obligatorio;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	/**
	 * @return the numero_documento
	 */
	public String getNumero_documento() {
		return numero_documento;
	}

	/**
	 * @param numero_documento the numero_documento to set
	 */
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	/**
	 * @return the pan_enmascarado
	 */
	public String getPan_enmascarado() {
		return pan_enmascarado;
	}

	/**
	 * @param pan_enmascarado the pan_enmascarado to set
	 */
	public void setPan_enmascarado(String pan_enmascarado) {
		this.pan_enmascarado = pan_enmascarado;
	}

	/**
	 * @return the saldo
	 */
	public String getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}


	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the motivo_bloqueo
	 */
	public String getMotivo_bloqueo() {
		return motivo_bloqueo;
	}

	/**
	 * @param motivo_bloqueo the motivo_bloqueo to set
	 */
	public void setMotivo_bloqueo(String motivo_bloqueo) {
		this.motivo_bloqueo = motivo_bloqueo;
	}

	public String getCodigoentidad() {
		return codigoentidad;
	}

	public void setCodigoentidad(String codigoentidad) {
		this.codigoentidad = codigoentidad;
	}

	

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre_politica() {
		return nombre_politica;
	}

	public void setNombre_politica(String nombre_politica) {
		this.nombre_politica = nombre_politica;
	}

	public String getResumen_politica() {
		return resumen_politica;
	}

	public void setResumen_politica(String resumen_politica) {
		this.resumen_politica = resumen_politica;
	}

	public String getCodigo_politica() {
		return codigo_politica;
	}

	public void setCodigo_politica(String codigo_politica) {
		this.codigo_politica = codigo_politica;
	}

	public List<RespuestaDataService> getTerminos_condiciones() {
		return terminos_condiciones;
	}

	public void setTerminos_condiciones(List<RespuestaDataService> terminos_condiciones) {
		this.terminos_condiciones = terminos_condiciones;
	}

	public String getMensaje_respuesta() {
		return mensaje_respuesta;
	}

	public void setMensaje_respuesta(String mensaje_respuesta) {
		this.mensaje_respuesta = mensaje_respuesta;
	}

	public String getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(String departamento_id) {
		this.departamento_id = departamento_id;
	}

	public String getCiudad_id() {
		return ciudad_id;
	}

	public void setCiudad_id(String ciudad_id) {
		this.ciudad_id = ciudad_id;
	}

	public String getPais_id() {
		return pais_id;
	}

	public void setPais_id(String pais_id) {
		this.pais_id = pais_id;
	}

	public List<ServicioWeb> getServicios_web() {
		return servicios_web;
	}

	public void setServicios_web(List<ServicioWeb> servicios_web) {
		this.servicios_web = servicios_web;
	}

	public List<RespuestaDataService> getProducto_usuario() {
		return producto_usuario;
	}

	public void setProducto_usuario(List<RespuestaDataService> producto_usuario) {
		this.producto_usuario = producto_usuario;
	}

	public List<RespuestaDataService> getProducto_corporativo() {
		return producto_corporativo;
	}

	public void setProducto_corporativo(List<RespuestaDataService> producto_corporativo) {
		this.producto_corporativo = producto_corporativo;
	}

	public String getCodigo_tarjeta() {
		return codigo_tarjeta;
	}

	public void setCodigo_tarjeta(String codigo_tarjeta) {
		this.codigo_tarjeta = codigo_tarjeta;
	}

	public String getCodigo_tarjeta_zeus() {
		return codigo_tarjeta_zeus;
	}

	public void setCodigo_tarjeta_zeus(String codigo_tarjeta_zeus) {
		this.codigo_tarjeta_zeus = codigo_tarjeta_zeus;
	}

	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getEstado_tarjeta() {
		return estado_tarjeta;
	}

	public void setEstado_tarjeta(String estado_tarjeta) {
		this.estado_tarjeta = estado_tarjeta;
	}

	public List<RespuestaDataService> getLista_paises() {
		return lista_paises;
	}

	public void setLista_paises(List<RespuestaDataService> lista_paises) {
		this.lista_paises = lista_paises;
	}


	public List<RespuestaDataService> getLista_ciudades() {
		return lista_ciudades;
	}


	public void setLista_ciudades(List<RespuestaDataService> lista_ciudades) {
		this.lista_ciudades = lista_ciudades;
	}


	public List<RespuestaDataService> getLista_departamentos() {
		return lista_departamentos;
	}


	public void setLista_departamentos(List<RespuestaDataService> lista_departamentos) {
		this.lista_departamentos = lista_departamentos;
	}

	public List<RespuestaDataService> getMovimientos_tarjeta() {
		return movimientos_tarjeta;
	}

	public void setMovimientos_tarjeta(List<RespuestaDataService> movimientos_tarjeta) {
		this.movimientos_tarjeta = movimientos_tarjeta;
	}

	public List<RespuestaDataService> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<RespuestaDataService> promociones) {
		this.promociones = promociones;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTipo_movimiento_id() {
		return tipo_movimiento_id;
	}

	public void setTipo_movimiento_id(String tipo_movimiento_id) {
		this.tipo_movimiento_id = tipo_movimiento_id;
	}

	public String getReferencia_pago() {
		return referencia_pago;
	}

	public void setReferencia_pago(String referencia_pago) {
		this.referencia_pago = referencia_pago;
	}

	public List<RespuestaDataService> getTarjetas_inscritas() {
		return tarjetas_inscritas;
	}

	public void setTarjetas_inscritas(List<RespuestaDataService> tarjetas_inscritas) {
		this.tarjetas_inscritas = tarjetas_inscritas;
	}

	public List<RespuestaDataService> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<RespuestaDataService> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getNotificacion_numero() {
		return notificacion_numero;
	}

	public void setNotificacion_numero(String notificacion_numero) {
		this.notificacion_numero = notificacion_numero;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha_visto() {
		return fecha_visto;
	}

	public void setFecha_visto(String fecha_visto) {
		this.fecha_visto = fecha_visto;
	}

	public String getFecha_gestion() {
		return fecha_gestion;
	}

	public void setFecha_gestion(String fecha_gestion) {
		this.fecha_gestion = fecha_gestion;
	}

	public String getFecha_finalizacion() {
		return fecha_finalizacion;
	}

	public void setFecha_finalizacion(String fecha_finalizacion) {
		this.fecha_finalizacion = fecha_finalizacion;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getCosto_transferencia() {
		return costo_transferencia;
	}

	public void setCosto_transferencia(String costo_transferencia) {
		this.costo_transferencia = costo_transferencia;
	}

	public String getNombre_th() {
		return nombre_th;
	}

	public void setNombre_th(String nombre_th) {
		this.nombre_th = nombre_th;
	}

	public List<RespuestaDataService> getTarjetas_amparadas() {
		return tarjetas_amparadas;
	}

	public void setTarjetas_amparadas(List<RespuestaDataService> tarjetas_amparadas) {
		this.tarjetas_amparadas = tarjetas_amparadas;
	}

	public String getActualizaDispositivo() {
		return actualizaDispositivo;
	}

	public void setActualizaDispositivo(String actualizaDispositivo) {
		this.actualizaDispositivo = actualizaDispositivo;
	}

	public List<RespuestaDataService> getProductos() {
		return productos;
	}

	public void setProductos(List<RespuestaDataService> productos) {
		this.productos = productos;
	}

	public String getCosto_envio() {
		return costo_envio;
	}

	public void setCosto_envio(String costo_envio) {
		this.costo_envio = costo_envio;
	}

	public String getMinimo_transferencia() {
		return minimo_transferencia;
	}

	public void setMinimo_transferencia(String minimo_transferencia) {
		this.minimo_transferencia = minimo_transferencia;
	}

	public String getIva_compra() {
		return iva_compra;
	}

	public void setIva_compra(String iva_compra) {
		this.iva_compra = iva_compra;
	}

	public String getIva_servicio() {
		return iva_servicio;
	}

	public void setIva_servicio(String iva_servicio) {
		this.iva_servicio = iva_servicio;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getValidacion_titularidad() {
		return validacion_titularidad;
	}

	public void setValidacion_titularidad(String validacion_titularidad) {
		this.validacion_titularidad = validacion_titularidad;
	}

	public List<RespuestaDataService> getAbonos_tarjeta() {
		return abonos_tarjeta;
	}

	public void setAbonos_tarjeta(List<RespuestaDataService> abonos_tarjeta) {
		this.abonos_tarjeta = abonos_tarjeta;
	}

	public String getCodigo_abono() {
		return codigo_abono;
	}

	public void setCodigo_abono(String codigo_abono) {
		this.codigo_abono = codigo_abono;
	}

	public String getMovimiento_llavero() {
		return movimiento_llavero;
	}

	public void setMovimiento_llavero(String movimiento_llavero) {
		this.movimiento_llavero = movimiento_llavero;
	}

	public String getLlavero_codigo() {
		return llavero_codigo;
	}

	public void setLlavero_codigo(String llavero_codigo) {
		this.llavero_codigo = llavero_codigo;
	}

	public String getCodigo_empresa() {
		return codigo_empresa;
	}

	public void setCodigo_empresa(String codigo_empresa) {
		this.codigo_empresa = codigo_empresa;
	}

	public String getMonto_abono() {
		return monto_abono;
	}

	public void setMonto_abono(String monto_abono) {
		this.monto_abono = monto_abono;
	}

	public String getNombre_llavero() {
		return nombre_llavero;
	}

	public void setNombre_llavero(String nombre_llavero) {
		this.nombre_llavero = nombre_llavero;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getFecha_abono() {
		return fecha_abono;
	}

	public void setFecha_abono(String fecha_abono) {
		this.fecha_abono = fecha_abono;
	}

	public String getSaldo_pendiente() {
		return saldo_pendiente;
	}

	public void setSaldo_pendiente(String saldo_pendiente) {
		this.saldo_pendiente = saldo_pendiente;
	}

	public String getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getEcommerce_saldo() {
		return ecommerce_saldo;
	}

	public void setEcommerce_saldo(String ecommerce_saldo) {
		this.ecommerce_saldo = ecommerce_saldo;
	}

	public String getAbotar_codigo() {
		return abotar_codigo;
	}

	public void setAbotar_codigo(String abotar_codigo) {
		this.abotar_codigo = abotar_codigo;
	}

	public String getMovimiento_legalizado() {
		return movimiento_legalizado;
	}

	public void setMovimiento_legalizado(String movimiento_legalizado) {
		this.movimiento_legalizado = movimiento_legalizado;
	}

	public String getCore_id() {
		return core_id;
	}

	public void setCore_id(String core_id) {
		this.core_id = core_id;
	}

	public String getFecha_cvc() {
		return fecha_cvc;
	}

	public void setFecha_cvc(String fecha_cvc) {
		this.fecha_cvc = fecha_cvc;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getActualizacion_datos() {
		return actualizacion_datos;
	}

	public void setActualizacion_datos(String actualizacion_datos) {
		this.actualizacion_datos = actualizacion_datos;
	}


}
