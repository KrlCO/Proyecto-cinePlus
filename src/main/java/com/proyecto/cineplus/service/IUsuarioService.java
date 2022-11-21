package com.proyecto.cineplus.service;

import com.proyecto.cineplus.models.User;
import com.proyecto.cineplus.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<User> findAll();
    Optional<User> findById(Integer id);
    User save(User user);
    Optional<User> findByEmail(String email);

}
