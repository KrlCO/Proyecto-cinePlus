package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cineplus.models.Pelicula;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, String>  {

}
