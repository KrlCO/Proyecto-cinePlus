package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    public Pelicula save(Pelicula pelicula);
    public Optional<Pelicula> get(String id);
    public void update(Pelicula pelicula);
    public void delete(String id);
    public List<Pelicula> findAll();

}
