package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Pelicula")
public class Pelicula {
	
	@Id
	@Column(name="cod_peli")
	private String idpeli;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "tipo_peli", insertable=false, updatable = false)
	private TipoPelicula tipopelicula;
	
	private int tipo_peli;
	
	
	private String fecha_estreno;
	
	private String fecha_final;
	
	private String estado;
	
	
	

	public Pelicula() {
		super();
	}

	public Pelicula(String idpeli, String nombre, TipoPelicula tipopelicula, int tipo_peli, String fecha_estreno,
			String fecha_final, String estado) {
		super();
		this.idpeli = idpeli;
		this.nombre = nombre;
		this.tipopelicula = tipopelicula;
		this.tipo_peli = tipo_peli;
		this.fecha_estreno = fecha_estreno;
		this.fecha_final = fecha_final;
		this.estado = estado;
	}

	public String getIdpeli() {
		return idpeli;
	}

	public void setIdpeli(String idpeli) {
		this.idpeli = idpeli;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPelicula getTipopelicula() {
		return tipopelicula;
	}

	public void setTipopelicula(TipoPelicula tipopelicula) {
		this.tipopelicula = tipopelicula;
	}

	public int getTipo_peli() {
		return tipo_peli;
	}

	public void setTipo_peli(int tipo_peli) {
		this.tipo_peli = tipo_peli;
	}

	public String getFecha_estreno() {
		return fecha_estreno;
	}

	public void setFecha_estreno(String fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}

	public String getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	

}
