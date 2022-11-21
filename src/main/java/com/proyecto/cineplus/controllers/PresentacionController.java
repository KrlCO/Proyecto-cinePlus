package com.proyecto.cineplus.controllers;

import com.proyecto.cineplus.service.PeliculaService;
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
	private IComestibleRepository repoComestible;
	
	@Autowired
	private IPeliculaRepository repoPelicula;

	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private IUsuarioRepository repoUsuario;


	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("cantidadPelicula", peliculaService.findAll().size());
		return "presentacion";
	}


}
