package com.brc.ms.proyectos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brc.ms.proyectos.domain.Investigador;

public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {
	Optional<Investigador> findByDni(String dni);
	Optional<Investigador> findByEmail (String email);
}
