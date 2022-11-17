/*
package com.proyecto.cineplus.config;

import com.proyecto.cineplus.enums.RolNombre;
import com.proyecto.cineplus.models.Rol;
import com.proyecto.cineplus.models.Usuarios;
import com.proyecto.cineplus.service.RolService;
import com.proyecto.cineplus.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {

        */
/*Usuarios user = new Usuarios();
        String passwordEncoded = passwordEncoder.encode("admin");
        user.setNombreUsuario("admin");
        user.setPassword(passwordEncoded);
        Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolAdmin);
        roles.add(rolUser);
        user.setRoles(roles);
        usuarioService.save(user);*//*


    }
}
*/
