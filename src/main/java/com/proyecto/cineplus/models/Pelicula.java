package com.proyecto.cineplus.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	private String idpeli;
	
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "tipopeli", insertable=false, updatable = false)
	private TipoPelicula tipopelicula;
	
	private int tipopeli;
	
	private String fechaestreno;
	
	private String fechafinal;
	
	private String estado;

	private String image;

	@ManyToOne
	private User user;

	public Pelicula(String idpeli, String titulo, TipoPelicula tipopelicula, int tipopeli, String fechaestreno, String fechafinal, String estado, String image, User user) {
		this.idpeli = idpeli;
		this.titulo = titulo;
		this.tipopelicula = tipopelicula;
		this.tipopeli = tipopeli;
		this.fechaestreno = fechaestreno;
		this.fechafinal = fechafinal;
		this.estado = estado;
		this.image = image;
		this.user = user;
	}
}
