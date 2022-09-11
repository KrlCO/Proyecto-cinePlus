package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comestible")
public class Comestible {

	@Id
	@Column(name = "cod_Com")
	private String idComestible;
	
	@Column(name = "descrip")
	private String descripcion;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "stock_Actual")
	private int stock;
	
	@Column(name = "id_Tipo")
	private int idTipo;
	
	@Column(name = "id_proveedor")
	private int idProveedor;
	
	@Column(name = "estado")
	private String estado;

	public Comestible() {
		super();
	}

	public Comestible(String idComestible, String descripcion, double precio, int stock, int idTipo, int idProveedor,
			String estado) {
		super();
		this.idComestible = idComestible;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.idTipo = idTipo;
		this.idProveedor = idProveedor;
		this.estado = estado;
	}

	public String getIdComestible() {
		return idComestible;
	}

	public void setIdComestible(String idComestible) {
		this.idComestible = idComestible;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
}
