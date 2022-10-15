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
@Table(name = "usercine")
public class Usuario {

	@Id
	private String idusuario;
	private String nombre;
	private String apellidos;

	@ManyToOne
	@JoinColumn(name = "tipouser", insertable = false, updatable = false)
	private TipoUsuario tipousuario;
	
	private int tipouser;
	private String email;
	private String password;
	private String estado;
	

}
