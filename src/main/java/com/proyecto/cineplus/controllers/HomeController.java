package com.proyecto.cineplus.controllers;

import com.proyecto.cineplus.models.DetalleOrden;
import com.proyecto.cineplus.models.Orden;
import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/usuario")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private TipoPeliService tipoPeliService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private OrdenService oredenService;

    @Autowired
    private IDetalleIOrdenService detalleOrdenService;

    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

  Orden orden = new Orden();

    @GetMapping("")
    public String home(Model model){

        model.addAttribute("pelicula", peliculaService.findAll());

        return "users/home";
    }

    @GetMapping("/peliculashome/{id}")
    public String peliculaHome(@PathVariable String id, Model model) {

        log.info("Id enviado como parametro {}", id);

        Pelicula pelicula = new Pelicula();
        Optional<Pelicula> peliculaOptional = peliculaService.get(id);
        pelicula = peliculaOptional.get();

        model.addAttribute("pelicula", pelicula);

        return "users/peliculashome";
    }
}
