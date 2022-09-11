package com.proyecto.cineplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.proyecto.cineplus.models.Usuario;
import com.proyecto.cineplus.repository.IUsuarioRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUsuarioRepository repoUsuario;
	
	@GetMapping("/logeo")
	
	public String logeo(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/ingresar")
	public String ingresar(@ModelAttribute(name = "usuario") Usuario usuario,Model model) {
		
		Usuario obj = repoUsuario.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
		
		if(obj != null) {
			return "redirect:/presentacion/home";
		}else {
			model.addAttribute("mensaje","No existen las credenciales.");
			return "login";
		}

	}
}
