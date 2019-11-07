package com.midilabs.dentech.api.repository.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midilabs.dentech.api.model.vo.Paciente;
import com.midilabs.dentech.api.repository.filter.PacienteFilter;

public interface PacienteRepositoryQuery {
	
	public Page<Paciente> filtrar(PacienteFilter pacienteFilter, Pageable pageable);

}
