package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Dentista;
import com.midilabs.dentech.api.repository.DentistaRepository;

@Service
public class DentistaService {
	
	@Autowired
	private DentistaRepository dentistaRepository;
	
	public Dentista buscaDentistaPorId(Long id) {
		return dentistaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Dentista atualizar(Long id, Dentista dentista) {
		Dentista dentistaSalvo = buscaDentistaPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(dentista, dentistaSalvo, "id");
		return dentistaRepository.save(dentistaSalvo);
	}

}
