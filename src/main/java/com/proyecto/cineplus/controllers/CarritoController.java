package com.proyecto.cineplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cineplus.repository.IComestibleRepository;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	int numero [] = {1,2,3,4,5,6,7,8,9,10};  
	
	@Autowired
	private IComestibleRepository repocomestibles;
	
	
	@GetMapping("")
	public String listadoCliente(Model model) {
		model.addAttribute("comestibles",repocomestibles.findAll());
		
		System.out.println(repocomestibles.findAll());
		
		model.addAttribute("numero",  numero);
		return "Carrito";
	}
	
	
}
