package com.proyecto.cineplus.repository;

import com.proyecto.cineplus.models.Orden;
import com.proyecto.cineplus.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {

    List<Orden> findByUser(User user);

}
