package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Clinica;
import com.midilabs.dentech.api.repository.ClinicaRepository;

@Service
public class ClinicaService {

	@Autowired
	private ClinicaRepository clinicaRepository;
	
	
	public Clinica atualizar(Long id, Clinica clinica) {
		Clinica objClinica = buscarClinicaPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(clinica, objClinica, "id");
		return clinicaRepository.save(objClinica);
	}
	
	private Clinica buscarClinicaPorId(Long id) {
		Clinica objClinica = clinicaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return objClinica;
	}
}
