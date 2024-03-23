package com.brc.ms.proyectos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brc.ms.proyectos.domain.ProyectoInvestigacion;

public interface ProyectoRepository extends JpaRepository<ProyectoInvestigacion, Long> {
	Optional<ProyectoInvestigacion> findByTitulo(String titulo);
	
}
