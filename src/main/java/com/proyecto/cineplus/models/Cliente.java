package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@Column(name = "id_Cliente")
	private int idCliente;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private String estado;

	public Cliente() {
		super();
	}

	
	public Cliente(int idCliente, String nombre, String telefono, String direccion, String email, String estado) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.estado = estado;
	}


	
	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int id) {
		this.idCliente = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	
}
