package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cineplus.models.TipoPelicula;

@Repository
public interface ITipoPelicula extends JpaRepository<TipoPelicula, Integer> {

}
