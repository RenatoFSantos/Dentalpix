package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.PerfilPermissao;
import com.midilabs.dentech.api.repository.PerfilPermissaoRepository;

@Service
public class PerfilPermissaoService {

	@Autowired
	private PerfilPermissaoRepository perfilPermissaoRepository;
	
	
	public PerfilPermissao buscarPerfilPermissaoPorId(Long id) {
		return perfilPermissaoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public PerfilPermissao atualizar(Long id, PerfilPermissao perfilPermissao) {
		PerfilPermissao perfilPermissaoSalvo = buscarPerfilPermissaoPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(perfilPermissao, perfilPermissaoSalvo, "id");
		return perfilPermissaoRepository.save(perfilPermissaoSalvo);
				
	}
}
