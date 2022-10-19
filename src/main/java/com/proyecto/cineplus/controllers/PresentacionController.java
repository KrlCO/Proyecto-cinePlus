package com.proyecto.cineplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cineplus.repository.*;

@Controller
@RequestMapping("/presentacion")
public class PresentacionController {

	@Autowired
	private IClienteRepository repoCliente;
	
	@Autowired
	private IComestibleRepository repoComestible;
	
	@Autowired
	private IPeliculaRepository repoPelicula;
	
	@Autowired
	private IProveedorRepository repoProveedor;
	
	@Autowired
	private IUsuarioRepository repoUsuario;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("cantidadPelicula", repoPelicula.findAll().size());
		return "presentacion";
	}
}
