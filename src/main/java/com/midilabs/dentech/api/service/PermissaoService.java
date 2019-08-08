package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Permissao;
import com.midilabs.dentech.api.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	
	public Permissao buscarPermissaoPorId(Long id) {
		return permissaoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Permissao atualizar(Long id, Permissao permissao) {
		Permissao permissaoSalvo = buscarPermissaoPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(permissao, permissaoSalvo, "id");
		return permissaoRepository.save(permissaoSalvo);
				
	}
}
