package com.midilabs.dentech.api.model.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clinica_dentista")
public class ClinicaDentista extends EntityBase {
	

	private static final long serialVersionUID = 1L;

	private Clinica clinica;
	private Dentista dentista;
	
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************


	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clde_sq_id")
	public Long getId() {
		return super.getId();
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="clin_sq_id")
	public Clinica getClinica() {
		return clinica;
	}
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="dett_sq_id")
	public Dentista getDentista() {
		return dentista;
	}
	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}
	
	

}
