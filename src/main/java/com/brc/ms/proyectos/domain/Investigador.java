package com.brc.ms.proyectos.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property="idInvestigador")
public class Investigador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idInvestigador;
	private String apePat;
	private String apeMat;
	private String nombres;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String dni;
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	@ManyToMany
	@JoinTable(name ="InvestigadoresProyectos",
			joinColumns = @JoinColumn(name = "IdInvestigador"),
			inverseJoinColumns = @JoinColumn(name = "IdPryInv"))
	private List<ProyectoInvestigacion> proyectos;
	

}
