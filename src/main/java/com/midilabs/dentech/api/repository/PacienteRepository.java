package com.midilabs.dentech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midilabs.dentech.api.model.vo.Paciente;
import com.midilabs.dentech.api.repository.paciente.PacienteRepositoryQuery;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteRepositoryQuery {
	

}
