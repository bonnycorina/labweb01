package com.brc.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brc.ms.proyectos.domain.ProyectoInvestigacion;
import com.brc.ms.proyectos.repositories.ProyectoRepository;

@Service
public class ProyectoInvestigacionServiceImp implements ProyectoInvestigacionService {
	
	private ProyectoRepository PryInvest;
	
	@Override
	public List<ProyectoInvestigacion> listarTodo() {
		return PryInvest.findAll();
	}

	@Override
	@Transactional
	public ProyectoInvestigacion buscarPorId(Long id) {
		Optional<ProyectoInvestigacion> PryInv = PryInvest.findById(id);
		return PryInv.get();
	}

	@Override
	@Transactional
	public ProyectoInvestigacion grabar(ProyectoInvestigacion PryInv) {
		return PryInvest.save(PryInv);
	}

	@Override
	@Transactional
	public ProyectoInvestigacion actualizar(ProyectoInvestigacion PryInv, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public ProyectoInvestigacion findByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
