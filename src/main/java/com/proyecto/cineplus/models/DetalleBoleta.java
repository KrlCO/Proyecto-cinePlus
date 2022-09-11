package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleboleta")
public class DetalleBoleta {

	@Id
	@Column(name = "cod_Deta_Bol")
	private int codDetalleBol;
	
	@ManyToOne
	@JoinColumn(name = "cod_bol",insertable = false,updatable = false)
	private Boleta boleta;
	
	@Column(name = "cod_bol")
	private String codBoleta;
	
	@ManyToOne
	@JoinColumn(name = "cod_peli",insertable = false,updatable = false)
	private Pelicula pelicula;
	
	@Column(name = "cod_peli")
	private String codPelicula;
	
	@ManyToOne
	@JoinColumn(name = "cod_Com",insertable = false,updatable = false)
	private Comestible comestible;
	
	@Column(name = "cod_Com")
	private String codComestible;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "total")
	private double total;
	
	public DetalleBoleta() {
		super();
	}

	public DetalleBoleta(int codDetalleBol, String codBoleta, String codPelicula, String codComestible, int cantidad,
			double total) {
		super();
		this.codDetalleBol = codDetalleBol;
		this.codBoleta = codBoleta;
		this.codPelicula = codPelicula;
		this.codComestible = codComestible;
		this.cantidad = cantidad;
		this.total = total;
	}

	public int getCodDetalleBol() {
		return codDetalleBol;
	}

	public void setCodDetalleBol(int codDetalleBol) {
		this.codDetalleBol = codDetalleBol;
	}

	public String getCodBoleta() {
		return codBoleta;
	}

	public void setCodBoleta(String codBoleta) {
		this.codBoleta = codBoleta;
	}

	public String getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(String codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getCodComestible() {
		return codComestible;
	}

	public void setCodComestible(String codComestible) {
		this.codComestible = codComestible;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Comestible getComestible() {
		return comestible;
	}

	public void setComestible(Comestible comestible) {
		this.comestible = comestible;
	}
	
	
	
}
