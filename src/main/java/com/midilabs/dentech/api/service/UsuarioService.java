package com.midilabs.dentech.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.midilabs.dentech.api.model.vo.Usuario;
import com.midilabs.dentech.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario atualizar(Long id, @Valid Usuario usuario) {
		Usuario objUsuario = buscarUsuarioPorId(id);
		// --- Copia as propriedades alteradas para as propriedades do objeto pesquisado excluindo o código (id) que já está definido
		BeanUtils.copyProperties(usuario, objUsuario, "id");
		usuarioRepository.save(objUsuario);
		return objUsuario;
	}
	
	public void atualizarSenha(Long id, String senha) {
		Usuario objUsuario = buscarUsuarioPorId(id);
		// --- Atualiza a propriedade SENHA
		objUsuario.setUsua_ds_senha(senha);
		usuarioRepository.save(objUsuario);		
	}
	
	private Usuario buscarUsuarioPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@SuppressWarnings("unused")
	private Usuario buscarUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Usuario salvar(@Valid Usuario usuario) {
//		Clinica objClinica = clinicaRepository.findById(usuario.getClinica().getId()).orElseThrow(() -> new EmptyResultDataAccessException(1));
//		if (objClinica == null || objClinica.isInativo()) {
//			throw new ClinicaInexistenteOuInativaException();
//		}
		return usuarioRepository.save(usuario);
	}

}
