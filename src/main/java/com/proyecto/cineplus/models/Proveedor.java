package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@Column(name = "id")
	private int id_proveedor;
	
	private String nombre;

	@Column(name = "telf")
	private String telefono;
	
	@Column(name = "direc")
	private String direccion;

	public Proveedor(int id_proveedor, String nombre, String telefono, String direccion) {
		super();
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Proveedor() {
		super();
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
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


	
	
}
