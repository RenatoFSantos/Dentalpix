package com.midilabs.dentech.api.repository.clinica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midilabs.dentech.api.model.vo.Clinica;
import com.midilabs.dentech.api.repository.filter.ClinicaFilter;
import com.midilabs.dentech.api.resource.projection.ResumoClinica;

public interface ClinicaRepositoryQuery {
	
	public Page<Clinica> filtrar(ClinicaFilter clinicafilter, Pageable pageable);
	public Page<ResumoClinica> resumir(ClinicaFilter clinicafilter, Pageable pageable);

}
