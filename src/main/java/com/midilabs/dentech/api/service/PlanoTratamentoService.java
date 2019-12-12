package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.PlanoTratamento;
import com.midilabs.dentech.api.repository.PlanoTratamentoRepository;

@Service
public class PlanoTratamentoService {

	@Autowired
	private PlanoTratamentoRepository planoTratamentoRepository;
	
	public PlanoTratamento buscaPlanoTratamentoPorId(Long id) {
		return planoTratamentoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public PlanoTratamento atualizar(Long id, PlanoTratamento planoTratamento) {
		PlanoTratamento planoTratamentoSalvo = this.buscaPlanoTratamentoPorId(id);
		BeanUtils.copyProperties(planoTratamento, planoTratamentoSalvo, "id");
		return planoTratamentoRepository.save(planoTratamentoSalvo);
	}
	
	
}
