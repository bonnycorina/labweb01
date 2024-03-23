package com.brc.ms.proyectos.services;

import java.util.List;

import com.brc.ms.proyectos.domain.ProyectoInvestigacion;


public interface ProyectoInvestigacionService {
	List<ProyectoInvestigacion> listarTodo();
	ProyectoInvestigacion buscarPorId(Long id);
	ProyectoInvestigacion grabar(ProyectoInvestigacion PryInv);
	ProyectoInvestigacion actualizar(ProyectoInvestigacion PryInv, Long id);
	void eliminar(Long id);
	ProyectoInvestigacion findByTitulo (String titulo);
	
}
