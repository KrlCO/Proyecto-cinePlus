package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.TipoPelicula;
import com.proyecto.cineplus.repository.ITipoPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPeliServiceImpl implements TipoPeliService{

    @Autowired
    private ITipoPelicula tipopeli;

    @Override
    public TipoPelicula save(TipoPelicula tipopelicula) {
        return tipopeli.save(tipopelicula);
    }

    @Override
    public Optional<TipoPelicula> get(Integer id) {
        return tipopeli.findById(id);
    }

    @Override
    public void update(TipoPelicula tipopelicula) {
        tipopeli.save(tipopelicula);
    }

    @Override
    public void delete(Integer id) {
       tipopeli.deleteById(id);
    }

    @Override
    public List<TipoPelicula> findAll() {
        return tipopeli.findAll();
    }
}
