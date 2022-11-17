package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.models.TipoPelicula;

import java.util.List;
import java.util.Optional;

public interface TipoPeliService {

    public TipoPelicula save(TipoPelicula tipopelicula);
    public Optional<TipoPelicula> get(Integer id);
    public void update(TipoPelicula tipopelicula);
    public void delete(Integer id);
    public List<TipoPelicula> findAll();

}
