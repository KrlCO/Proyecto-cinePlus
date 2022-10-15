package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name ="tipocomest")
public class TipoComestible {

	@Id
	private int idtipocomestible;
	
	private String descrip;

}
