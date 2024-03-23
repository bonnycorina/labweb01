package com.brc.ms.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brc.ms.proyectos.domain.ProyectoInvestigacion;
import com.brc.ms.proyectos.services.ProyectoInvestigacionService;

@RestController
@RequestMapping("/api/v1/ProyectosDeInvestigador")
public class ProyectoInvestigacionController {

	@Autowired
	private ProyectoInvestigacionService PryInvService;
	
	@GetMapping
	public List<ProyectoInvestigacion> listarProyectosInv(){
		return PryInvService.listarTodo();
	}
	
	public ProyectoInvestigacion listarPorId(@PathVariable Long id) {
		return PryInvService.buscarPorId(id);
	}
	
	@PostMapping
	public ProyectoInvestigacion crearInvestigador(@RequestBody ProyectoInvestigacion proyInv) {
		return PryInvService.grabar(proyInv);
	}
}
