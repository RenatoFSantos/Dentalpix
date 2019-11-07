package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Perfil_Permissao;
import com.midilabs.dentech.api.repository.PerfilPermissaoRepository;

@Service
public class PerfilPermissaoService {

	@Autowired
	private PerfilPermissaoRepository perfilPermissaoRepository;
	
	
	public Perfil_Permissao buscarPerfilPermissaoPorId(Long id) {
		return perfilPermissaoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Perfil_Permissao atualizar(Long id, Perfil_Permissao perfilPermissao) {
		Perfil_Permissao perfilPermissaoSalvo = buscarPerfilPermissaoPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(perfilPermissao, perfilPermissaoSalvo, "id");
		return perfilPermissaoRepository.save(perfilPermissaoSalvo);
				
	}
}
