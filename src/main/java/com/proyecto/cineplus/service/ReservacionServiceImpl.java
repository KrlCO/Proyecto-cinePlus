package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.Reservacion;
import com.proyecto.cineplus.repository.IReservavionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservacionServiceImpl implements ReservacionService{

    @Autowired
    private IReservavionRepository iReservavionRepository;

    @Override
    public Reservacion save(Reservacion reservacion) {
        return iReservavionRepository.save(reservacion);
    }

    @Override
    public Optional<Reservacion> findById(String id) {
        return iReservavionRepository.findById(id);
    }

    @Override
    public void update(Reservacion reservacion) {
        iReservavionRepository.save(reservacion);
    }

    @Override
    public void delete(String id) {
        iReservavionRepository.deleteById(id);
    }

    @Override
    public List<Reservacion> findAll() {
        return iReservavionRepository.findAll();
    }
}
