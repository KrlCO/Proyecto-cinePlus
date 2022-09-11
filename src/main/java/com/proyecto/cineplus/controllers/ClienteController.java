package com.proyecto.cineplus.controllers;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.cineplus.models.Cliente;
import com.proyecto.cineplus.repository.IClienteRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	IClienteRepository repo;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader; 
	
	//variable auxiliar
	private String estadoRecolectado;
	
	@GetMapping("/listado")
	public String listadoCliente(Model model) {
		model.addAttribute("listado", repo.findAll());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("cantidad", repo.findAll().size());
		return "MCliente";
	}
	
	@PostMapping("/Guardar")
	public String guardarCliente(@ModelAttribute(name = "cliente") Cliente cliente,Model model) {
		
		if (cliente != null) {
			repo.save(cliente);
			model.addAttribute("listado", repo.findAll());
			model.addAttribute("cliente", new Cliente());
			model.addAttribute("cantidad", repo.count());
			return "MCliente";
		}
		return "redirect:/cliente/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable int id,Model model) {
		Optional<Cliente> cliente = repo.findById(id);
		if (cliente.isPresent()) {			
			model.addAttribute("listado", repo.findAll());
			model.addAttribute("cantidad", repo.count());
			model.addAttribute("cliente", cliente);
			return "MCliente";
		}
		return "redirect:/cliente/listado";
	}
	
	@GetMapping("/reporte")
	public String reporteCargar(@RequestParam(name = "estado",required = false,defaultValue = "C") String estado,Model model) {
		if (estado.equals("B")) {
			model.addAttribute("validacion", "Seleccione un estado.");
			return "RPCliente";
		}
		estadoRecolectado = estado;
		model.addAttribute("listCliente", repo.findByEstado(estado));
		model.addAttribute("cantidad", repo.findAll().size());
		return "RPCliente";
	}
	
	@GetMapping("/filtro")
	public void verFiltro(
			HttpServletResponse response) {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("Parameter", estadoRecolectado);
		System.out.print(estadoRecolectado);
		/*response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");*/ // para descarga
		response.setHeader("Content-Disposition", "inline;"); // en línea
		response.setContentType("application/pdf");
		
		try {
			String ru = resourceLoader.getResource("classpath:reportes/RPCliente.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable int id, Model model) {
		Cliente obj = repo.findById(id).get();
		
		if (obj != null) {
			obj.setEstado("I");
			repo.save(obj);
			model.addAttribute("listado", repo.findAll());
			model.addAttribute("cantidad", repo.count());
			model.addAttribute("cliente", obj);
			return "MCliente";
		}
		return "redirect:/pelicula/listado";
	}
}
