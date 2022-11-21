package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleOrdenRepository extends JpaRepository <DetalleOrden, Integer> {
}
