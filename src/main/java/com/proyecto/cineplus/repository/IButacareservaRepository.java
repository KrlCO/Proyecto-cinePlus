package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.Butacareserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IButacareservaRepository extends JpaRepository<Butacareserva, String> {
}
