package com.proyecto.cineplus.controllers;

import com.proyecto.cineplus.models.Butaca;
import com.proyecto.cineplus.models.Sala;
import com.proyecto.cineplus.repository.IButacaRepository;
import com.proyecto.cineplus.repository.ISalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/butaca")
public class ButacaController {

    @Autowired
    IButacaRepository repobutaca;

    @Autowired
    ISalaRepository reposala;

    @GetMapping("/cargar")
    public String abrirPagina(Model model){
        model.addAttribute("butaca", new Butaca());
        model.addAttribute("listadoButaca", repobutaca.findAll());
        model.addAttribute("listadoSala", reposala.findAll());
        return "MButaca";
    }

    @GetMapping("/listado")
    public String listadoButacas(@ModelAttribute(name = "butaca")Butaca butaca, Model model){
        model.addAttribute("listadoSala", reposala.findAll());
        model.addAttribute("butaca", new Butaca());
        model.addAttribute("listadoButaca", repobutaca.findAll());
        return "ListButaca";
    }

    @PostMapping("/guardar")
    public String guardarButaca(@ModelAttribute(name = "butaca")Butaca butaca, Model model){

        if(butaca != null){
            System.out.println(butaca);

            if(butaca.getIdsala() == -1){
                model.addAttribute("validacion", "Selecciona una Sala");
                model.addAttribute("listadoSala", reposala.findAll());
                model.addAttribute("listadoButaca", reposala.findAll());
                return "MButaca";
            }

        repobutaca.save(butaca);
            model.addAttribute("listadoSala", reposala.findAll());
            model.addAttribute("listadoButaca", repobutaca.findAll());
            return "redirect:/butaca/listado";

        }
        return "MButaca";
    }

    @GetMapping("/editar/{id}")
    public String editarButaca(@PathVariable String id, Model model){

        Optional<Butaca> butaca = repobutaca.findById(id);

        if(butaca.isPresent()){
            model.addAttribute("listadoSala", reposala.findAll());
            model.addAttribute("listadoButaca", repobutaca.findAll());
            model.addAttribute("butaca", butaca);
            return "MButaca";
        }
        return "redirect:/butaca/listado";
    }

    public String eliminarButaca(@PathVariable String id, Model model){
        Butaca butaca = repobutaca.findById(id).get();

        if(butaca != null){

            model.addAttribute("listadoSala", reposala.findAll());
            model.addAttribute("listadoButaca", repobutaca.findAll());
            model.addAttribute("butaca", butaca);
            return "MButaca";
        }
        return "redirect:/butaca/listado";
    }

}
