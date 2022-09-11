package com.proyecto.cineplus.controllers;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.cineplus.repository.IComestibleRepository;
import com.proyecto.cineplus.repository.IDetalleBoletaRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/detalleBoleta")
public class DetalleBoletaController {

	
	@Autowired
	private IDetalleBoletaRepository repoDetalleBoleta;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader; 
	
	@Autowired
	private IComestibleRepository repoComestible;
	
	//variable auxiliar
	private String comestibleRecolectado;
	
	@GetMapping("/reporte")
	public String cargarDetalleBoleta(@RequestParam(name = "idComestible",required = false,defaultValue = "C") String id,Model model) {
		if (id.equals("B")) {
			model.addAttribute("validacion", "Seleccione un Comestible.");
			model.addAttribute("listComestible", repoComestible.findAll());
			return "RPVenta";

		}
		comestibleRecolectado = id;
		model.addAttribute("listComestible", repoComestible.findAll());
		model.addAttribute("listDetalleBoleta", repoDetalleBoleta.findByCodComestible(id));
		return "RPVenta";
	}
	
	@GetMapping("/filtro")
	public void verFiltro(
			HttpServletResponse response) {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("Parameter", comestibleRecolectado);
		System.out.print(comestibleRecolectado);
		/*response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");*/ // para descarga
		response.setHeader("Content-Disposition", "inline;"); // en línea
		response.setContentType("application/pdf");
		
		try {
			String ru = resourceLoader.getResource("classpath:reportes/RPDetalleBoleta.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
