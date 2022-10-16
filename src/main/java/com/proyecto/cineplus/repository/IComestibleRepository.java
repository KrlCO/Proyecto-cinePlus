package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.Comestible;
import org.springframework.stereotype.Repository;

@Repository
public interface IComestibleRepository  extends JpaRepository<Comestible, String>{

}
