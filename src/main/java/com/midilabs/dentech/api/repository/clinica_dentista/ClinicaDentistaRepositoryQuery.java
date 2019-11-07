package com.midilabs.dentech.api.repository.clinica_dentista;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midilabs.dentech.api.model.vo.Clinica;
import com.midilabs.dentech.api.model.vo.ClinicaDentista;
import com.midilabs.dentech.api.model.vo.Dentista;

public interface ClinicaDentistaRepositoryQuery {
	
	public Page<ClinicaDentista> listarDentistasPorClinica(Long id, Pageable pageable);
	public Page<ClinicaDentista> listarClinicasPorDentista(Long id, Pageable pageable);

}
