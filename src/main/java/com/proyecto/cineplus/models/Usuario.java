package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@Column(name = "id_Usuario")
	private String id;
	private String nombre;
	private String telefono;
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "tipo_usuario", insertable = false, updatable = false)
	private TipoUsuario tipousuario;
	
	private int tipo_usuario;
	
	private String email;
	private String password;
	private String estado;
	
	public Usuario() {
		super();
	}

	public Usuario(String id, String nombre, String telefono, String direccion, int tipo_usuario, TipoUsuario tipousuario, String email,
			String password, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipo_usuario = tipo_usuario;
		this.tipousuario = tipousuario;
		this.email = email;
		this.password = password;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	public TipoUsuario getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
