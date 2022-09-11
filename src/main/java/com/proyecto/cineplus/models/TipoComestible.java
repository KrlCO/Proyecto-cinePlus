package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="tipo_comest")
public class TipoComestible {

	@Id
	private int id;
	
	@Column(name ="descrip")
	private String descripcion;

	public TipoComestible() {
		super();
	}

	public TipoComestible(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
}
