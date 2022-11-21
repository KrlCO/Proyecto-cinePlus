package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.User;
import com.proyecto.cineplus.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
