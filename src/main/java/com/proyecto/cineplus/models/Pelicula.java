package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
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
	
}
