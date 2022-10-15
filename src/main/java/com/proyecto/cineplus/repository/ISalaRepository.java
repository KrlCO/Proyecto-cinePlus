package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaRepository extends JpaRepository<Sala, Integer> {
}
