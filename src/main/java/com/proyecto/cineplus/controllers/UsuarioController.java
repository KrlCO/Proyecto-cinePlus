package com.proyecto.cineplus.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cineplus.models.Usuario;
import com.proyecto.cineplus.repository.ITipoUsuarioRepository;
import com.proyecto.cineplus.repository.IUsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private ITipoUsuarioRepository repo_tipousu;
	
	@Autowired
	private IUsuarioRepository repo_usu;
	
	@GetMapping("/listado")
	
	public String principal(Model model) {
		RellenarGuardar(model, new Usuario());
		
		return "MUsuario";
	}
	
	@PostMapping("/Guardar")
	
	public String guardarUsuario(@ModelAttribute Usuario usuarios, Model model) {
		
		try {
			
			Usuario usuario = repo_usu.findById(usuarios.getId()).get();

			RellenarGuardar(model, usuarios);
			model.addAttribute("mensajeCorrecto","El ID del Usuario Existe");
			
		} catch (Exception e) {
			
			String datos =  formulario(usuarios);

			if(datos != null) {
				RellenarGuardar(model, usuarios);
				model.addAttribute("mensajeCorrecto",datos);
				return "MUsuario";
			}else {
				repo_usu.save(usuarios);
				RellenarGuardar(model, new Usuario());
				model.addAttribute("mensajeCorrecto","Se registro Correctamente el Usuario");
				return "redirect:/usuario/listado";
			}
		}
		
		return "MUsuario";
	}	
	
	@GetMapping("/Mostrar/{id}")
	
	public String mostrarUsuario(@PathVariable String id, Model model) {
				
		try {
			Optional<Usuario> usuario = repo_usu.findById(id);
			if (usuario.isPresent()) {
				RellenarEdit(model, usuario.get());
			}
		} catch (Exception e) {
			RellenarGuardar(model, new Usuario());
			return "redirect:/usuario/listado";
		}
		
		return "MUsuario";
	}
	
	@PostMapping("/Editar")
	
	public String editarUsuario(@ModelAttribute(name = "usuarios") Usuario usuarios, Model model) {
		
		try {
			String datos =  formulario(usuarios);
			
			if (datos != null) {
				repo_usu.save(usuarios);
				RellenarGuardar(model, new Usuario());
				model.addAttribute("mensajeCorrecto","Se Edito correctamente el Usuario");
			}else {
				RellenarEdit(model, usuarios);
				model.addAttribute("mensajeCorrecto",datos);
				return "MUsuario";
			}
		} catch (Exception e) {
			RellenarEdit(model, usuarios);
			model.addAttribute("mensajeCorrecto","No se pudo editar el Usuario");
			return "MUsuario";
		}
		return "redirect:/usuario/listado";
	}
	
	@GetMapping("/Eliminar/{id}")
	
	public String eliminarUsuario(@PathVariable String id, Model model) {
		
		try {
			Usuario usuario = repo_usu.findById(id).get();
			if (usuario != null) {
				usuario.setEstado("I");
				repo_usu.save(usuario);
				RellenarGuardar(model, new Usuario());
				model.addAttribute("mensajeCorrecto","Usuario desactivado");
			}else {
				RellenarGuardar(model, new Usuario());
				model.addAttribute("mensajeCorrecto","Error en desactivar usuario");
			}
			
		} catch (Exception e) {
			RellenarGuardar(model, new Usuario());
			model.addAttribute("mensajeCorrecto","Error en desactivar usuario");
			return "MUsuario";
		}
		
		return "redirect:/usuario/listado";
	}
	
	
	private String formulario(Usuario usuario) {
		
		if(usuario.getId()==null || usuario.getId().isEmpty()) {
			return "Error en el ID";
		}else if(usuario.getNombre()==null || usuario.getNombre().isEmpty()) {
			return "Error en el Nombre";
		}else if(usuario.getDireccion()==null || usuario.getDireccion().isEmpty()) {
			return "Error en la Dirección";
		}else if(usuario.getTelefono()==null || usuario.getTelefono().isEmpty() || usuario.getTelefono().length() > 9 || usuario.getTelefono().length() < 9 ) {
			return "Error en la Telefono";
		}else if(usuario.getTipo_usuario() == -1) {
			return "Selecionar Tipo de Usuario.";
		}else if(usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
			return "Error en el Email";
		}else if(usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
			return "Error en el Password";
		}
		
		return null;
	}
	
	private void RellenarGuardar(Model model, Usuario usario) {
		model.addAttribute("estado_formulario","/usuario/Guardar");		
		model.addAttribute("listaTipoUsuario", repo_tipousu.findAll());
		model.addAttribute("listaUsuarios",repo_usu.findAll());
		model.addAttribute("cantidad", repo_usu.findAll().size());
		model.addAttribute("usuarios", usario);
	}
	
	private void RellenarEdit(Model model, Usuario usario) {
		model.addAttribute("estado_formulario","/usuario/Editar");		
		model.addAttribute("listaTipoUsuario", repo_tipousu.findAll());
		model.addAttribute("listaUsuarios",repo_usu.findAll());
		model.addAttribute("usuarios", usario);
	}
}
