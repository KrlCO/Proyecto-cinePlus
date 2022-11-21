package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private IPeliculaRepository peliculaRepository;

    @Override
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Optional<Pelicula> get(String id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public void update(Pelicula pelicula) {

        peliculaRepository.save(pelicula);
    }

    @Override
    public void delete(String id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }
}
