package com.midilabs.dentech.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Perfil;
import com.midilabs.dentech.api.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public Perfil buscarPerfilPorId(Long id) {
		return perfilRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Perfil atualizar(Long id, Perfil perfil) {
		Perfil perfilSalvo = buscarPerfilPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(perfil, perfilSalvo, "id");
		return perfilRepository.save(perfilSalvo);
	}

}
