package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="boleta")
public class Boleta {
	
	@Id
	@Column(name="cod_bol")
	private String codBoleta;

	@ManyToOne
	@JoinColumn(name="id_Cliente",updatable = false,insertable = false)
	private Cliente cliente;
	
	@Column(name="id_Cliente")
	private int idCliente;

	
	@Column(name="fecha_bol")
	private String fechaBoleta;
	
	@Column(name="prec_total")
	private double precioTotal;

	public Boleta() {
		super();
	}

	public Boleta(String codBoleta, int idCliente, String fechaBoleta, double precioTotal) {
		super();
		this.codBoleta = codBoleta;
		this.idCliente = idCliente;
		this.fechaBoleta = fechaBoleta;
		this.precioTotal = precioTotal;
	}

	public String getCodBoleta() {
		return codBoleta;
	}

	public void setCodBoleta(String codBoleta) {
		this.codBoleta = codBoleta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaBoleta() {
		return fechaBoleta;
	}

	public void setFechaBoleta(String fechaBoleta) {
		this.fechaBoleta = fechaBoleta;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
