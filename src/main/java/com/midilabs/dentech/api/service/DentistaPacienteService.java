package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.DentistaPaciente;
import com.midilabs.dentech.api.repository.DentistaPacienteRepository;

@Service
public class DentistaPacienteService {
	
	@Autowired
	private DentistaPacienteRepository dentistaPacienteRepository;
	
	public DentistaPaciente buscarDentistaPacientePorId(Long id) {
		return dentistaPacienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		
	}
	
	public DentistaPaciente atualizar(Long id, DentistaPaciente dentistaPaciente) {
		DentistaPaciente dentistaPacienteSalvo = buscarDentistaPacientePorId(id);
		BeanUtils.copyProperties(dentistaPaciente, dentistaPacienteSalvo, "id");
		return dentistaPacienteRepository.save(dentistaPacienteSalvo);
	}

}
