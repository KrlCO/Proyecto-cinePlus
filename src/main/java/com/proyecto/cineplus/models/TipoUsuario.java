package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tipouser")
public class TipoUsuario {

	@Id
	private int idtipo;
	private String desctipo;
	

}
