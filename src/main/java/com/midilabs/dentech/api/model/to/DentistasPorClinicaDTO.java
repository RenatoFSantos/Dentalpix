package com.midilabs.dentech.api.model.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.midilabs.dentech.api.model.vo.Clinica;
import com.midilabs.dentech.api.model.vo.Dentista;

public class DentistasPorClinicaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Clinica clinica;
	private List<Dentista> dentistas = new ArrayList<>();
	
	public DentistasPorClinicaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public DentistasPorClinicaDTO(Clinica clinica, List<Dentista> dentistas) {
		this.clinica = clinica;
		this.dentistas = dentistas;
	}
	
	// *********************************************
	// --- GETs e SETs
	// *********************************************

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Dentista> getDentistas() {
		return dentistas;
	}

	public void setDentistas(List<Dentista> dentistas) {
		this.dentistas = dentistas;
	}
	
	

}
