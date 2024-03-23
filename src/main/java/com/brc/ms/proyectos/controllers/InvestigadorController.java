package com.brc.ms.proyectos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brc.ms.proyectos.domain.Investigador;
import com.brc.ms.proyectos.exception.EntityNotFoundException;
import com.brc.ms.proyectos.exception.IllegalOperationException;
import com.brc.ms.proyectos.services.InvestigadorService;

@RestController
@RequestMapping("/api/v1/investigadores")
public class InvestigadorController {
	@Autowired
	private InvestigadorService InvService;
	
	@GetMapping
	public List<Investigador> listarInvestigadores(){
		return InvService.listarTodo();
	}
	
	public ResponseEntity <?> litarPorId(@PathVariable Long id) {
		
		Optional<Investigador> invOptional = Optional.ofNullable(InvService.buscarPorId(id));
		if(invOptional.isPresent()) {
			return ResponseEntity.ok(invOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity <?> crearInvestigador(@RequestBody Investigador investigador) throws IllegalOperationException{
		return ResponseEntity.status(HttpStatus.CREATED).body(InvService.grabar(investigador));
	}
	public ResponseEntity<Investigador> editarInvestigador(@PathVariable Long id, @RequestBody Investigador inv) throws IllegalOperationException {
		
		Optional<Investigador> o = Optional.ofNullable(InvService.buscarPorId(id));
		if (o.isPresent()) {
			Investigador invDB = o.get();
			invDB.setApePat(inv.getApePat());
			invDB.setApeMat(inv.getApeMat());
			invDB.setEmail(inv.getEmail());
			invDB.setDni(inv.getDni());
			invDB.setFechaReg(inv.getFechaReg());
			invDB.setNombres(inv.getNombres());
						
			return ResponseEntity.status(HttpStatus.CREATED).body(InvService.grabar(invDB));
			
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("(id)")
	public ResponseEntity<Object> eliminarInvestigador(@PathVariable Long id) throws EntityNotFoundException, IllegalOperationException{
		Optional<Investigador> o = Optional.of(InvService.buscarPorId(id));
		if (o.isPresent()) {
			InvService.eliminar(id);
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.notFound().build();
	}
}
