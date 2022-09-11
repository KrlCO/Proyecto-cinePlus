package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.TipoUsuario;

public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
	

}
