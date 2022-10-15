package com.proyecto.cineplus.controllers;
import com.proyecto.cineplus.models.Sala;
import com.proyecto.cineplus.repository.ISalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    ISalaRepository reposala;

    @GetMapping("/cargar")
    public String abrirPagina(Model model){
        model.addAttribute("sala", new Sala());
        model.addAttribute("listadoSala", reposala.findAll());
        return "MSala";
    }

    @GetMapping("/listado")
    public String listaSala(@ModelAttribute(name = "sala") Sala sala, Model model){
        model.addAttribute("listadoSala", reposala.findAll());
        model.addAttribute("sala", new Sala());
        return "ListSala";
    }

    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute(name="sala")Sala sala, Model model){

        if(sala != null){
            reposala.save(sala);
            model.addAttribute("listadoSala", reposala.findAll());
            model.addAttribute("sala", new Sala());
        }
        return "redirect:/sala/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarSala(@PathVariable int id, Model model){
        Optional<Sala> sala = reposala.findById(id);
        if(sala.isPresent()){
            model.addAttribute("litadoSala", reposala.findAll());
            model.addAttribute("sala", sala);
            return "MSala";
        }
        return "redirect:/sala/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSala(@PathVariable int id, Model model){
        Sala s = reposala.findById(id).get();

        if(s != null){
            reposala.save(s);
            model.addAttribute("listadoSala", reposala.findAll());
            model.addAttribute("sala", s);
            return "MSala";
        }
        return "redirect:/sala/listado";

    }

}
