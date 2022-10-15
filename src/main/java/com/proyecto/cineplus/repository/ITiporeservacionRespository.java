package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.Tiporeservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiporeservacionRespository extends JpaRepository<Tiporeservacion, Integer> {
}
