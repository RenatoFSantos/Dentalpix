package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.ClinicaDentista;
import com.midilabs.dentech.api.repository.ClinicaDentistaRepository;

@Service
public class ClinicaDentistaService {
	
	@Autowired
	private ClinicaDentistaRepository clinicaDentistaRepository;
	
	public ClinicaDentista buscarClinicaDentistaPorId(Long id) {
		return clinicaDentistaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public ClinicaDentista atualizar(Long id, ClinicaDentista clinicaDentista) {
		ClinicaDentista clinicaDentistaSalvo = buscarClinicaDentistaPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(clinicaDentista, clinicaDentistaSalvo, "id");
		return clinicaDentistaRepository.save(clinicaDentistaSalvo);
				
	}
	

}
