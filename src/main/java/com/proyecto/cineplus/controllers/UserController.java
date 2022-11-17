package com.proyecto.cineplus.controllers;
import com.proyecto.cineplus.models.User;
import com.proyecto.cineplus.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/registro")
    public String create(){
        return "users/registro";
    }

    @PostMapping("/save")
    public String save(User user){

        user.setTipo("USER");
        usuarioService.save(user);

        return "redirect:/presentacion/home";
    }

    @GetMapping("/login")
    public String login(){
        return "users/login";
    }
}
