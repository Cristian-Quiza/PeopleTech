package co.com.middleware.dto;

public class TransaccionDTO {
	
	private String otp;
	private String tipo_otp;
	private String estado_ecommerce;
	private String cantidad_compras;
	private String tipo_documento;
	private String documento;
	private String contrasena;
	private String token;
	private String app_ingreso;
	private String core_id;
	private String urlService;
	private String service_id;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String fecha_expedicion;
	private String fecha_nacimiento;
	private String numero_celular;
	private String direccion;
	private String tipo_pago;
	/*dispositivo*/
	private String guid;
	private String plataforma;
	private String modelo;
	/*solicitud invitado*/
	private String documento_invitado;
	private String correo_invitado;
	private String celular_invitado;
	private String codigo_producto;
	private String tipo_documento_invitado;
	private String direccion_invitado;
	private String codigo_tarjeta;
	private String tipo_transaccion_id;
	private String fecha_inicio;
	private String fecha_fin;
	private String terminos;	
	/* Actualiza Contacto */
	private String celular_anterior;
	private String celular_nuevo;
	private String ciudad_id;
	private String direccion_nueva;
	private String direccion_anterior;
	private String actualizar_portal;
	/* Activar Tarjeta */
	private String codigo_tarjeta_zeus;
	private String estado_tarjeta;
	/* Recuperar Contrasena */
	private String correo_electronico;
	/* Cambio contrasena */
	private String contrasena_actual;
	private String ip_actualizacion;
	private String confirmar_contrasena;
	private String nueva_contrasena;
	/* Consultas */
	private String pais_id;
	private String departamento_id;
	/* Asociar tarjeta coorp */
	private String nit_empresa;
	private String ultimos_digitos;
	private String identificador;	
	/*Pedir tarjeta amparada*/
	private String parentesco_id;
	private String tipo_documento_amp;
	private String documento_amp;
	/*Recarga*/
	private String monto;
	/*ValidarClave*/
	private String clave;
	private String confirmar_clave;
	/*Inscribir tarjeta*/
	private String nombre_completo;
	private String tipo_documento_inscrito;
	private String documento_inscrito;
	/*Pagar tarjeta con Poeple*/
	private String numero_referencia;
	/*Actualizacion notificacion*/
	private String eliminar;
	private String visto;
	private String notificacion_numero;
	/*Transferencia*/
	private String codigo_tarjeta_origen;
	private String codigo_tarjeta_destino;
	private String valor_transferencia;
	/*Soporte*/
	private String asunto;
	private String mensaje;
	private String soporte;
	/*Imagen Icono*/
	private String imagen;
	/*version*/
	private String codigo_app;
	private String imagen_uno;
	private String imagen_dos;
	private String imagen_tres;
	//llave
	private String codigo_abono;
	private String numero_documento;
	
	
	public String getAbono_codigo() {
		return abono_codigo;
	}

	public void setAbono_codigo(String abono_codigo) {
		this.abono_codigo = abono_codigo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getCodigo_movimiento() {
		return codigo_movimiento;
	}

	public void setCodigo_movimiento(String codigo_movimiento) {
		this.codigo_movimiento = codigo_movimiento;
	}

	/**/
	private String abono_codigo;
	private String observacion;
	private String codigo_movimiento;
	
	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getSoporte() {
		return soporte;
	}

	public void setSoporte(String soporte) {
		this.soporte = soporte;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getPais_id() {
		return pais_id;
	}

	public void setPais_id(String pais_id) {
		this.pais_id = pais_id;
	}

	public String getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(String departamento_id) {
		this.departamento_id = departamento_id;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getFecha_expedicion() {
		return fecha_expedicion;
	}

	public void setFecha_expedicion(String fecha_expedicion) {
		this.fecha_expedicion = fecha_expedicion;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNumero_celular() {
		return numero_celular;
	}

	public void setNumero_celular(String numero_celular) {
		this.numero_celular = numero_celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento_invitado() {
		return documento_invitado;
	}

	public void setDocumento_invitado(String documento_invitado) {
		this.documento_invitado = documento_invitado;
	}

	public String getCorreo_invitado() {
		return correo_invitado;
	}

	public void setCorreo_invitado(String correo_invitado) {
		this.correo_invitado = correo_invitado;
	}

	public String getCelular_invitado() {
		return celular_invitado;
	}

	public void setCelular_invitado(String celular_invitado) {
		this.celular_invitado = celular_invitado;
	}

	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getUrlService() {
		return urlService;
	}

	public void setUrlService(String urlService) {
		this.urlService = urlService;
	}

	public String getCore_id() {
		return core_id;
	}

	public void setCore_id(String core_id) {
		this.core_id = core_id;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getApp_ingreso() {
		return app_ingreso;
	}

	public void setApp_ingreso(String app_ingreso) {
		this.app_ingreso = app_ingreso;
	}

	public String getTipo_documento_invitado() {
		return tipo_documento_invitado;
	}

	public void setTipo_documento_invitado(String tipo_documento_invitado) {
		this.tipo_documento_invitado = tipo_documento_invitado;
	}

	public String getDireccion_invitado() {
		return direccion_invitado;
	}

	public void setDireccion_invitado(String direccion_invitado) {
		this.direccion_invitado = direccion_invitado;
	}

	public String getCodigo_tarjeta() {
		return codigo_tarjeta;
	}

	public void setCodigo_tarjeta(String codigo_tarjeta) {
		this.codigo_tarjeta = codigo_tarjeta;
	}

	public String getTipo_transaccion_id() {
		return tipo_transaccion_id;
	}

	public void setTipo_transaccion_id(String tipo_transaccion_id) {
		this.tipo_transaccion_id = tipo_transaccion_id;
	}

	public String getCelular_anterior() {
		return celular_anterior;
	}

	public void setCelular_anterior(String celular_anterior) {
		this.celular_anterior = celular_anterior;
	}

	public String getCelular_nuevo() {
		return celular_nuevo;
	}

	public void setCelular_nuevo(String celular_nuevo) {
		this.celular_nuevo = celular_nuevo;
	}

	public String getCiudad_id() {
		return ciudad_id;
	}

	public void setCiudad_id(String ciudad_id) {
		this.ciudad_id = ciudad_id;
	}

	public String getDireccion_nueva() {
		return direccion_nueva;
	}

	public void setDireccion_nueva(String direccion_nueva) {
		this.direccion_nueva = direccion_nueva;
	}

	public String getDireccion_anterior() {
		return direccion_anterior;
	}

	public void setDireccion_anterior(String direccion_anterior) {
		this.direccion_anterior = direccion_anterior;
	}

	public String getCodigo_tarjeta_zeus() {
		return codigo_tarjeta_zeus;
	}

	public void setCodigo_tarjeta_zeus(String codigo_tarjeta_zeus) {
		this.codigo_tarjeta_zeus = codigo_tarjeta_zeus;
	}

	public String getEstado_tarjeta() {
		return estado_tarjeta;
	}

	public void setEstado_tarjeta(String estado_tarjeta) {
		this.estado_tarjeta = estado_tarjeta;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasena_actual() {
		return contrasena_actual;
	}

	public void setContrasena_actual(String contrasena_actual) {
		this.contrasena_actual = contrasena_actual;
	}

	public String getConfirmar_contrasena() {
		return confirmar_contrasena;
	}

	public void setConfirmar_contrasena(String confirmar_contrasena) {
		this.confirmar_contrasena = confirmar_contrasena;
	}

	public String getIp_actualizacion() {
		return ip_actualizacion;
	}

	public void setIp_actualizacion(String ip_actualizacion) {
		this.ip_actualizacion = ip_actualizacion;
	}

	public String getNueva_contrasena() {
		return nueva_contrasena;
	}

	public void setNueva_contrasena(String nueva_contrasena) {
		this.nueva_contrasena = nueva_contrasena;
	}

	public String getActualizar_portal() {
		return actualizar_portal;
	}

	public void setActualizar_portal(String actualizar_portal) {
		this.actualizar_portal = actualizar_portal;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getNit_empresa() {
		return nit_empresa;
	}

	public void setNit_empresa(String nit_empresa) {
		this.nit_empresa = nit_empresa;
	}

	public String getUltimos_digitos() {
		return ultimos_digitos;
	}

	public void setUltimos_digitos(String ultimos_digitos) {
		this.ultimos_digitos = ultimos_digitos;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getParentesco_id() {
		return parentesco_id;
	}

	public void setParentesco_id(String parentesco_id) {
		this.parentesco_id = parentesco_id;
	}

	public String getTipo_documento_amp() {
		return tipo_documento_amp;
	}

	public void setTipo_documento_amp(String tipo_documento_amp) {
		this.tipo_documento_amp = tipo_documento_amp;
	}

	public String getDocumento_amp() {
		return documento_amp;
	}

	public void setDocumento_amp(String documento_amp) {
		this.documento_amp = documento_amp;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getConfirmar_clave() {
		return confirmar_clave;
	}

	public void setConfirmar_clave(String confirmar_clave) {
		this.confirmar_clave = confirmar_clave;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getTipo_documento_inscrito() {
		return tipo_documento_inscrito;
	}

	public void setTipo_documento_inscrito(String tipo_documento_inscrito) {
		this.tipo_documento_inscrito = tipo_documento_inscrito;
	}

	public String getDocumento_inscrito() {
		return documento_inscrito;
	}

	public void setDocumento_inscrito(String documento_inscrito) {
		this.documento_inscrito = documento_inscrito;
	}

	public String getNumero_referencia() {
		return numero_referencia;
	}

	public void setNumero_referencia(String numero_referencia) {
		this.numero_referencia = numero_referencia;
	}

	public String getEliminar() {
		return eliminar;
	}

	public void setEliminar(String eliminar) {
		this.eliminar = eliminar;
	}

	public String getVisto() {
		return visto;
	}

	public void setVisto(String visto) {
		this.visto = visto;
	}

	public String getNotificacion_numero() {
		return notificacion_numero;
	}

	public void setNotificacion_numero(String notificacion_numero) {
		this.notificacion_numero = notificacion_numero;
	}

	public String getCodigo_tarjeta_origen() {
		return codigo_tarjeta_origen;
	}

	public void setCodigo_tarjeta_origen(String codigo_tarjeta_origen) {
		this.codigo_tarjeta_origen = codigo_tarjeta_origen;
	}

	public String getCodigo_tarjeta_destino() {
		return codigo_tarjeta_destino;
	}

	public void setCodigo_tarjeta_destino(String codigo_tarjeta_destino) {
		this.codigo_tarjeta_destino = codigo_tarjeta_destino;
	}

	public String getValor_transferencia() {
		return valor_transferencia;
	}

	public void setValor_transferencia(String valor_transferencia) {
		this.valor_transferencia = valor_transferencia;
	}

	public String getTerminos() {
		return terminos;
	}

	public void setTerminos(String terminos) {
		this.terminos = terminos;
	}

	public String getCodigo_app() {
		return codigo_app;
	}

	public void setCodigo_app(String codigo_app) {
		this.codigo_app = codigo_app;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getImagen_uno() {
		return imagen_uno;
	}

	public void setImagen_uno(String imagen_uno) {
		this.imagen_uno = imagen_uno;
	}

	public String getImagen_dos() {
		return imagen_dos;
	}

	public void setImagen_dos(String imagen_dos) {
		this.imagen_dos = imagen_dos;
	}

	public String getImagen_tres() {
		return imagen_tres;
	}

	public void setImagen_tres(String imagen_tres) {
		this.imagen_tres = imagen_tres;
	}

	public String getCodigo_abono() {
		return codigo_abono;
	}

	public void setCodigo_abono(String codigo_abono) {
		this.codigo_abono = codigo_abono;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}

	public String getCantidad_compras() {
		return cantidad_compras;
	}

	public void setCantidad_compras(String cantidad_compras) {
		this.cantidad_compras = cantidad_compras;
	}

	public String getEstado_ecommerce() {
		return estado_ecommerce;
	}

	public void setEstado_ecommerce(String estado_ecommerce) {
		this.estado_ecommerce = estado_ecommerce;
	}

	public String getTipo_otp() {
		return tipo_otp;
	}

	public void setTipo_otp(String tipo_otp) {
		this.tipo_otp = tipo_otp;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}	
	

}
