package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="dentista_paciente")
public class DentistaPaciente extends EntityBase {


	private static final long serialVersionUID = 1L;
	
	private Dentista dentista;
	private Paciente paciente;

	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "depa_sq_id")
	public Long getId() {
		return super.getId();
	}
	
	@ManyToOne
	@JoinColumn(name="dett_sq_id", nullable = false)
//	@JsonBackReference
	public Dentista getDentista() {
		return dentista;
	}
	
	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}
	
	@ManyToOne
	@JoinColumn(name="paci_sq_id", nullable = false)
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
