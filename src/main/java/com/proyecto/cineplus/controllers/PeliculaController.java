package com.proyecto.cineplus.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.repository.IPeliculaRepository;
import com.proyecto.cineplus.repository.ITipoPelicula;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

		@Autowired
		IPeliculaRepository rep;

	@Autowired
	ITipoPelicula repot;


	@GetMapping("/listado")
	public String listadoPeliculas(@ModelAttribute(name = "pelicula") Pelicula pelicula, Model model) {
		model.addAttribute("listadoTipoPelicula", repot.findAll());
		model.addAttribute("pelicula", new Pelicula());
		model.addAttribute("cantidad", rep.findAll().size());
		model.addAttribute("listadoPelicula", rep.findAll());
		return "MPelicula";
	}

	@PostMapping("/guardar")
	public String guardarPelicula(@ModelAttribute(name = "pelicula") Pelicula peliculas, Model model) {

			if (peliculas != null) {
				System.out.println(peliculas);
				
				if (peliculas.getTipo_peli() == -1) {
					model.addAttribute("validacion", "Seleccione un tipo de pelicula.");
					model.addAttribute("listadoTipoPelicula", repot.findAll());
					model.addAttribute("listadoPelicula", rep.findAll());
					model.addAttribute("cantidad", rep.findAll().size());
					return "MPelicula";
				}
				
			rep.save(peliculas);
			model.addAttribute("listadoTipoPelicula", repot.findAll());
			model.addAttribute("listadoPelicula", rep.findAll());
			model.addAttribute("cantidad", rep.findAll().size());
			return "redirect:/pelicula/listado";
			}
			return "MPelicula";

	}

	
	  
	  @GetMapping("/editar/{id}")
		public String editarPelicula(@PathVariable String id,Model model ) {
		  
			Optional<Pelicula> peliculas = rep.findById(id);
			
			if (peliculas.isPresent()) {
				model.addAttribute("listadoTipoPelicula", repot.findAll());
				model.addAttribute("listadoPelicula", rep.findAll());
				model.addAttribute("cantidad", rep.findAll().size());
				model.addAttribute("pelicula",peliculas); 
				return "MPelicula";
				
			}
			return "redirect:/pelicula/listado";
			
		}
	  
		
		  @GetMapping("/eliminar/{id}")
		  public String eliminarPelicula(@PathVariable String id, Model model) {
		  
		 /* Optional<Pelicula> pelicula = rep.findById(id); */
		 Pelicula pelicula = rep.findById(id).get(); 
		  
		  if(pelicula != null) {
			  
		  pelicula.setEstado("I");
		  rep.save(pelicula);
		  model.addAttribute("listadoTipoPelicula", repot.findAll());
		  model.addAttribute("listadoPelicula", rep.findAll());
		  model.addAttribute("cantidad", rep.findAll().size());
		  model.addAttribute("pelicula",pelicula); 
		  return "MPelicula";
		  
		  }
		  return "redirect:/pelicula/listado";
		 
		}	
	  }