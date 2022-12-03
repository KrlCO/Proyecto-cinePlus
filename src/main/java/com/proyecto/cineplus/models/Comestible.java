package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comestible")
public class Comestible {

	@Id
	private String idcomestible;

	private String descrip;

	private double precio;

	private int stockactual;

	@ManyToOne
	@JoinColumn(name = "idtipocomestible", insertable=false, updatable = false)
	private TipoComestible tipocomestible;

	private int idtipocomestible;

	private String estado;

	public Comestible() {
	}

	public Comestible(String idcomestible, String descrip, double precio, int stockactual, TipoComestible tipocomestible, int idtipocomestible, String estado) {
		this.idcomestible = idcomestible;
		this.descrip = descrip;
		this.precio = precio;
		this.stockactual = stockactual;
		this.tipocomestible = tipocomestible;
		this.idtipocomestible = idtipocomestible;
		this.estado = estado;
	}

	public String getIdcomestible() {
		return idcomestible;
	}

	public void setIdcomestible(String idcomestible) {
		this.idcomestible = idcomestible;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStockactual() {
		return stockactual;
	}

	public void setStockactual(int stockactual) {
		this.stockactual = stockactual;
	}

	public TipoComestible getTipocomestible() {
		return tipocomestible;
	}

	public void setTipocomestible(TipoComestible tipocomestible) {
		this.tipocomestible = tipocomestible;
	}

	public int getIdtipocomestible() {
		return idtipocomestible;
	}

	public void setIdtipocomestible(int idtipocomestible) {
		this.idtipocomestible = idtipocomestible;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
