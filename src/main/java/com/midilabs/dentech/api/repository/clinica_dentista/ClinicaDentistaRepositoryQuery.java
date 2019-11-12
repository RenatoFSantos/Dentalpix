package com.midilabs.dentech.api.repository.clinica_dentista;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midilabs.dentech.api.model.vo.ClinicaDentista;

public interface ClinicaDentistaRepositoryQuery {
	
	public List<ClinicaDentista> listarDentistasPorClinica(Long id);
	public Page<ClinicaDentista> listarClinicasPorDentista(Long id, Pageable pageable);

}
