package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.Butaca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IButacaRepository extends JpaRepository <Butaca, String> {
}
