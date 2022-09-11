package com.proyecto.cineplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.Boleta;

public interface IBoletaRepository  extends JpaRepository<Boleta, String>{
	
	public List<Boleta> findByIdCliente(Integer idCliente);
}
