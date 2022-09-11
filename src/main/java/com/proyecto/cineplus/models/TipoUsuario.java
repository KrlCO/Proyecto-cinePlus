package com.proyecto.cineplus.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_User")
public class TipoUsuario {
	@Id
	private int cod_tipo;
	private String desc_tipo;
	
	public TipoUsuario() {
		super();
	}
	
	public TipoUsuario(int cod_tipo, String desc_tipo) {
		super();
		this.cod_tipo = cod_tipo;
		this.desc_tipo = desc_tipo;
	}

	public int getCod_tipo() {
		return cod_tipo;
	}

	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}

	public String getDesc_tipo() {
		return desc_tipo;
	}

	public void setDesc_tipo(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}
	
	
}
