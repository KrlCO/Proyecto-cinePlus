package com.proyecto.cineplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.DetalleBoleta;

public interface IDetalleBoletaRepository extends JpaRepository<DetalleBoleta, Integer>{
	
	public List<DetalleBoleta> findByCodComestible(String comestible);
}
