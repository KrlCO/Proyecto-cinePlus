package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name="tipopeli")
public class TipoPelicula {
	
	@Id
	private int idtipo;
	
	private String desctipo;
	

}
