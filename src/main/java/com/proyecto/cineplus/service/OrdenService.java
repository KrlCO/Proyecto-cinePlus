package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.Orden;
import com.proyecto.cineplus.models.User;

import java.util.List;
import java.util.Optional;

public interface OrdenService {

    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save (Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUser (User user);


}
