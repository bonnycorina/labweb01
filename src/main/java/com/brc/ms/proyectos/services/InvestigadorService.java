package com.brc.ms.proyectos.services;
import java.util.List;

import com.brc.ms.proyectos.domain.Investigador;
import com.brc.ms.proyectos.exception.EntityNotFoundException;
import com.brc.ms.proyectos.exception.IllegalOperationException;
//Implementando el crud
public interface InvestigadorService {
	List<Investigador> listarTodo();
	Investigador buscarPorId(Long id) throws EntityNotFoundException;
	Investigador grabar(Investigador investigador)throws IllegalOperationException;
	Investigador actualizar(Investigador investigador, Long id) throws EntityNotFoundException, IllegalOperationException;
	void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException;
	Investigador findByDni (String dni);
	Investigador findByEmail (String email);
}
