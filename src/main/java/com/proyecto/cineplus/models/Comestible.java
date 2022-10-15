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

}
