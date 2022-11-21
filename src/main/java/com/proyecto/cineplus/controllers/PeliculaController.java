package com.proyecto.cineplus.controllers;

import java.io.IOException;
import java.util.Optional;

import com.proyecto.cineplus.models.TipoPelicula;
import com.proyecto.cineplus.models.User;
import com.proyecto.cineplus.service.IUsuarioService;
import com.proyecto.cineplus.service.PeliculaService;
import com.proyecto.cineplus.service.TipoPeliService;
import com.proyecto.cineplus.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.repository.IPeliculaRepository;
import com.proyecto.cineplus.repository.ITipoPelicula;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

	@Autowired
	IPeliculaRepository rep;

	@Autowired
	ITipoPelicula repot;

	@Autowired
	private PeliculaService peliculaService;

	@Autowired
	private TipoPeliService tipoPeliService;
	 @Autowired
	private IUsuarioService usuarioService;

	 @Autowired
	 private UploadFileService upload;

	@GetMapping("/cargar")
	public String abrirPagina(Model model) {
		model.addAttribute("pelicula", new Pelicula());
		model.addAttribute("listadoTipoPelicula", tipoPeliService.findAll());
		model.addAttribute("listadoPelicula", peliculaService.findAll());
		return "MPelicula";
	}

	@GetMapping("/listado")
	public String listadoPeliculas(@ModelAttribute(name = "pelicula") Pelicula pelicula, Model model) {
		model.addAttribute("listadoTipoPelicula", tipoPeliService.findAll());
		model.addAttribute("pelicula", new Pelicula());
		model.addAttribute("cantidad", peliculaService.findAll().size());
		model.addAttribute("listadoPelicula", peliculaService.findAll());
		return "ListPelicula";
	}

	@PostMapping("/guardar")
	public String save(Pelicula pelicula, @RequestParam("img") MultipartFile file)throws IOException{

		User u = new User(1, "", "krl", "", "", "", "");
		pelicula.setUser(u);

		String nombreImagen = upload.saveImage(file);
		pelicula.setImage(nombreImagen);

		peliculaService.save(pelicula);

		return "redirect:/pelicula/listado";

	}

	@GetMapping("/editar/{id}")
	public String edit(@PathVariable String id,Model model, Pelicula pelis){

		Optional<Pelicula> peliculas = rep.findById(id);

			/*if(!p.getImage().equals("default.jpg")){

				upload.deleteImage(p.getImage());
			}
			String nombreImagen = upload.saveImage(file);
			pelis.setImage(nombreImagen);*/

		if (peliculas.isPresent()) {
			model.addAttribute("listadoTipoPelicula", tipoPeliService.findAll());
			model.addAttribute("listadoPelicula", peliculaService.findAll());
			model.addAttribute("cantidad", peliculaService.findAll().size());
			model.addAttribute("pelicula",peliculas);
			return "MPelicula";

		}
		return "redirect:/pelicula/listado";

	}

	@PostMapping("/update")
	public String update(Pelicula pelicula, TipoPelicula tipopeli, @RequestParam ("img") MultipartFile file)throws IOException{

		Pelicula p = new Pelicula();
		TipoPelicula t = new TipoPelicula();
		p = peliculaService.get(pelicula.getIdpeli()).get();
		t = tipoPeliService.get(tipopeli.getIdtipo()).get();

		if(file.isEmpty()){
			pelicula.setImage(p.getImage());
		}else{
			if(!p.getImage().equals("default.jpg")){
				upload.deleteImage(p.getImage());
			}
			String nombreImagen = upload.saveImage(file);
			pelicula.setImage(nombreImagen);
		}

		pelicula.setUser(p.getUser());
		peliculaService.update(pelicula);
		tipoPeliService.update(tipopeli);

		return "redirect:/pelicula/listado";
	}
	  
		
/*		  @GetMapping("/eliminar/{id}")
		  public String eliminarPelicula(@PathVariable String id, Model model) {
		  
		 *//* Optional<Pelicula> pelicula = rep.findById(id); *//*
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
		 
		}*/

		@GetMapping("/eliminar/{id}")
		public String delete(@PathVariable String id){

			Pelicula p = new Pelicula();
			p = peliculaService.get(id).get();

			if(!p.getImage().equals("default.jpg")){

				upload.deleteImage(p.getImage());
			}

		peliculaService.delete(id);

		return "redirect:/pelicula/listado";

		}
	  }