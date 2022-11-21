package com.proyecto.cineplus.controllers;

import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.service.IUsuarioService;
import com.proyecto.cineplus.service.OrdenService;
import com.proyecto.cineplus.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdminController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private OrdenService ordenService;

    @GetMapping("")
    public String home(Model model){

        List<Pelicula> pelicula = peliculaService.findAll();
        model.addAttribute("pelicula", pelicula);

        return "admin/home";
    }


}
