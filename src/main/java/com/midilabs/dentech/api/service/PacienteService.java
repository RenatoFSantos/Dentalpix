package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Paciente;
import com.midilabs.dentech.api.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	public Paciente buscaPacientePorId(Long id) {
		return this.pacienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Paciente atualizar(Long id, Paciente paciente) {
		Paciente pacienteSalvo = this.buscaPacientePorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(paciente, pacienteSalvo, "id");
		return pacienteRepository.save(pacienteSalvo);
	}
	
}
