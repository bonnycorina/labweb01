package com.brc.ms.proyectos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idPryInv")
public class ProyectoInvestigacion implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPryInv;
	private String titulo;
	@Temporal(TemporalType.DATE)
	private Date fechaInicioPry;
	@Temporal(TemporalType.DATE)
	private Date fechaCierrePry;
	private String estadoPry;
	private float presupuestoPry;
	
	private Investigador responsable;
	@ManyToMany (mappedBy ="proyectos")
	private List<Investigador> investigadores = new ArrayList<>();
	
	@OneToMany(mappedBy = "proyecto")
	@JsonManagedReference
	private List<AvanceProyecto> avances = new ArrayList<>();

}
