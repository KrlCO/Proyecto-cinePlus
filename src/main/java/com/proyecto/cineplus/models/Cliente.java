package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	private String idcliente;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String password;

	private Date fechaRegistro;

}
