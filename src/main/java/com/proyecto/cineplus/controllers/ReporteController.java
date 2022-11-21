package com.proyecto.cineplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cineplus.models.Cliente;
import com.proyecto.cineplus.models.Reservacion;
import com.proyecto.cineplus.repository.IClienteRepository;
import com.proyecto.cineplus.repository.IReservavionRepository;



@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	@Autowired
    private IReservavionRepository reporeserv;

    @Autowired
    private IClienteRepository repocliente;
   // private IClienteRepository repocliente;
	
    @GetMapping("/cliente")
    public String reporte_entrada(Model model){

	int num_cliente = repocliente.findAll().size();
	
	String [] client_arra = new String[num_cliente];
	
	int contador = 0;
	
	//cantidad de clientes y almancenamiento del IDCLIENTE
	
	for (Cliente clientes : repocliente.findAll()) {
		client_arra[contador] = clientes.getIdcliente(); 
		contador++;
	}
	    	
	String valores [][] = new  String [num_cliente][2];
	
	if (reporeserv.findAll() == null) {
		System.out.println("Es nulo");
	}else {
		for (Reservacion datos : reporeserv.findAll()) {
    		for (int i = 0; i < client_arra.length; i++) {
    			if(datos.getIdcliente().equals(client_arra[i])) {  				
    				valores [i][0] = datos.getCliente().getNombre();
    				//aumentar la cantidad de tikets que compro
    				if (valores[i][1] == null) valores[i][1] = "0";
    				int valor  = Integer.parseInt(valores[i][1]); 
    				valores [i][1] =  String.valueOf(valor + 1) ;
    			}
			} 
    		    		
		}
	}
	
	System.out.println(valores);
	
	model.addAttribute("listadoReporte",valores);
	return "RPReporte";


    }
}
