package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.models.Reservacion;

import java.util.List;
import java.util.Optional;

public interface ReservacionService {

    public Reservacion save(Reservacion reservacion);
    public Optional<Reservacion> findById(String id);
    public void update(Reservacion reservacion);
    public void delete(String id);
    public List<Reservacion> findAll();

}
