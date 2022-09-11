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

import com.proyecto.cineplus.models.Comestible;
import com.proyecto.cineplus.repository.IComestibleRepository;
import com.proyecto.cineplus.repository.IProveedorRepository;
import com.proyecto.cineplus.repository.ITipoComestibleRepository;

@Controller
@RequestMapping("/comestible")
public class ComestibleController {

	@Autowired
	private IComestibleRepository repoComestible;
	@Autowired
	private ITipoComestibleRepository repoTipoComestible;
	
	@Autowired
	private IProveedorRepository repoIProveedorRepository;
	
	@GetMapping("/listado")
	public String listadoComestible(@ModelAttribute(name = "comestible") Comestible comestible,Model model) {
		model.addAttribute("listado", repoComestible.findAll());
		model.addAttribute("comestible", new Comestible());
		model.addAttribute("cantidad", repoComestible.findAll().size());
		model.addAttribute("cboComestible", repoTipoComestible.findAll());
		model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
		return "MComestible";
	}
	
	@PostMapping("/Guardar")
	public String guardarComestible(@ModelAttribute(name = "comestible") Comestible comestible,Model model) {
		
		if (comestible != null) {
		
			if (comestible.getIdTipo() == -1) {
				model.addAttribute("validacion", "Seleccione un tipo comestible.");
				model.addAttribute("cboComestible", repoTipoComestible.findAll());
				model.addAttribute("listado", repoComestible.findAll());
				model.addAttribute("cantidad", repoComestible.findAll().size());
				model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
				return "MComestible";
			}
			
			if (comestible.getIdProveedor() == -1) {
				model.addAttribute("validacion2", "Seleccione un tipo Proveedor.");
				model.addAttribute("cboComestible", repoTipoComestible.findAll());
				model.addAttribute("listado", repoComestible.findAll());
				model.addAttribute("cantidad", repoComestible.findAll().size());
				model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
				return "MComestible";
			}
			
			repoComestible.save(comestible);
			model.addAttribute("listado", repoComestible.findAll());
			model.addAttribute("cboComestible", repoTipoComestible.findAll());
			model.addAttribute("cantidad", repoComestible.findAll().size());
			model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
			return "MComestible";
		}
		return "redirect:/comestible/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String editarComestible(@PathVariable String id,Model model ) {
		Optional<Comestible> comestible = repoComestible.findById(id);
		
		if (comestible.isPresent()) {
			model.addAttribute("listado", repoComestible.findAll());
			model.addAttribute("cboComestible", repoTipoComestible.findAll());
			model.addAttribute("comestible", comestible);
			model.addAttribute("cantidad", repoComestible.findAll().size());
			model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
			return "MComestible";
		}
		return "redirect:/comestible/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarComestible(@PathVariable String id,Model model) {
		Comestible obj = repoComestible.findById(id).get();
		if (obj != null) {
			obj.setEstado("I");
			repoComestible.save(obj);
			model.addAttribute("listado", repoComestible.findAll());
			model.addAttribute("cboComestible", repoTipoComestible.findAll());
			model.addAttribute("comestible", obj);
			model.addAttribute("cantidad", repoComestible.findAll().size());
			model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
			return "MComestible";
		}
		return "redirect:/comestible/listado";
	}
}
