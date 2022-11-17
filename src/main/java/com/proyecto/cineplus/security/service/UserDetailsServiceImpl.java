/*
package com.proyecto.cineplus.security.service;

import com.proyecto.cineplus.models.Usuarios;
import com.proyecto.cineplus.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
*/

/*
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuarios user = usuarioService.getByNombreUsuario(nombreUsuario).orElseThrow(() -> new
                UsernameNotFoundException(nombreUsuario));
        return UsuarioPrincipal.build(user);


    }
}
*/
