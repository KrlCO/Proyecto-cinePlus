package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservavionRepository extends JpaRepository<Reservacion,String> {
}
