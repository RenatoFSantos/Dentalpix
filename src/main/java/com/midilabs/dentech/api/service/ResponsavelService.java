package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Responsavel;
import com.midilabs.dentech.api.repository.ResponsavelRepository;

@Service
public class ResponsavelService {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	public Responsavel buscarResponsavelPorId(Long id) {
		return responsavelRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Responsavel atualizar(Long id, Responsavel responsavel) {
		Responsavel responsavelSalvo = this.buscarResponsavelPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(responsavel, responsavelSalvo, "id");
		return responsavelRepository.save(responsavelSalvo);
	}

}
