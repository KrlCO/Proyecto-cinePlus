package com.proyecto.cineplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

	public List<Cliente> findByEstado(String estado);
}
