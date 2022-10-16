package com.proyecto.cineplus.controllers;

import com.proyecto.cineplus.models.Butaca;
import com.proyecto.cineplus.models.Butacareserva;
import com.proyecto.cineplus.repository.IButacaRepository;
import com.proyecto.cineplus.repository.IButacareservaRepository;
import com.proyecto.cineplus.repository.IReservavionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/reservabutaca")
public class ReservaButacaController {

    @Autowired
    IButacareservaRepository reporeservbc;

    @Autowired
    IButacaRepository repobutaca;

    @Autowired
    IReservavionRepository reposervacion;

    @GetMapping("/cargar")
    public String abrirPagina(Model model){
        model.addAttribute("reservab", new Butacareserva());
        model.addAttribute("listadoButacas", repobutaca.findAll());
        model.addAttribute("listaReservas", reposervacion.findAll());
        model.addAttribute("listadoReservasB", reporeservbc.findAll());
        return "MReservaButaca";
    }

    @GetMapping("/listado")
    public String listadoReservaB(@ModelAttribute(name = "reservab") Butacareserva reservab, Model model){
        model.addAttribute("reservab", new Butacareserva());
        model.addAttribute("listadoButacas", repobutaca.findAll());
        model.addAttribute("listaReservas", reposervacion.findAll());
        model.addAttribute("listadoReservasB", reporeservbc.findAll());

        return "ListReservaButaca";
    }

    @PostMapping("/guardar")
    public String guardarReservaB(@ModelAttribute(name = "reservab")Butacareserva reservab, Model model){

        if(reservab != null){

            reporeservbc.save(reservab);
            model.addAttribute("listadoButacas", repobutaca.findAll());
            model.addAttribute("listaReservas", reposervacion.findAll());
            model.addAttribute("listadoReservasB", reporeservbc.findAll());
        return "redirect:/reservabutaca/listado";
        }
        return "MReservaButaca";
    }

    @GetMapping("/editar/{id}")
    public String editarReservaB(@PathVariable String id, Model model){

        Optional<Butacareserva> reservab = reporeservbc.findById(id);

        if(reservab.isPresent()){
            model.addAttribute("listadoButacas", repobutaca.findAll());
            model.addAttribute("listaReservas", reposervacion.findAll());
            model.addAttribute("listadoReservasB", reporeservbc.findAll());
            model.addAttribute("reservab", reservab);
            return "MReservaButaca";
        }
        return "redirect:/reservabutaca/listado";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarReservab(@PathVariable String id, Model model){
        Butacareserva reservab = reporeservbc.findById(id).get();

        if(reservab != null){
            model.addAttribute("listadoButacas", repobutaca.findAll());
            model.addAttribute("listaReservas", reposervacion.findAll());
            model.addAttribute("listadoReservasB", reporeservbc.findAll());
            model.addAttribute("reservab", reservab);
            return "MReservaButaca";
        }

        return "redirect:/reservabutaca/listado";
    }

}
