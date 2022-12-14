package com.proyecto.cineplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/boleta")
public class BoletaController {
/*
	@Autowired
	private IBoletaRepository repoBoleta;
	
	@Autowired
	private IClienteRepository repoCliente;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader; 
	
	//variable Auxiliar
	private int idRecolectado;
	
	@GetMapping("/reporte")
	public String cargarBoleta(@RequestParam(name = "identificador",required = false,defaultValue ="-2") int idCliente,Model model) {
		
		if (idCliente == -1) {
			model.addAttribute("validacion", "Seleccione un Cliente.");
			model.addAttribute("listCliente", repoCliente.findAll());
			return "RPBoleta";
		}
		
		idRecolectado = idCliente;
		model.addAttribute("listBoleta", repoBoleta.findByIdCliente(idCliente));
		model.addAttribute("listCliente", repoCliente.findAll());
		return "RPBoleta";
	}
	
	@GetMapping("/filtro")
	public void verFiltro(
			HttpServletResponse response) {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("Parameter", idRecolectado);
		System.out.print(idRecolectado);
		*//*response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");*//* // para descarga
		response.setHeader("Content-Disposition", "inline;"); // en línea
		response.setContentType("application/pdf");
		
		try {
			String ru = resourceLoader.getResource("classpath:reportes/RPBoleta.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
