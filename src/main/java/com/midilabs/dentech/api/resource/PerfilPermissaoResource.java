package com.midilabs.dentech.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.midilabs.dentech.api.event.RecursoCriadoEvent;
import com.midilabs.dentech.api.model.vo.Perfil_Permissao;
import com.midilabs.dentech.api.repository.PerfilPermissaoRepository;
import com.midilabs.dentech.api.service.PerfilPermissaoService;

@RestController
@RequestMapping("/perfil_permissaos")
public class PerfilPermissaoResource {

	@Autowired
	private PerfilPermissaoRepository perfilPermissaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PerfilPermissaoService perfilPermissaoService;
	
	
	@GetMapping
	public List<Perfil_Permissao> listar() {
		return perfilPermissaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Perfil_Permissao> buscarPermissaoPorId(@PathVariable Long id) {
		Perfil_Permissao permissaoSalvo = perfilPermissaoService.buscarPerfilPermissaoPorId(id);
		return permissaoSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(permissaoSalvo);
		
	}
		
	@PostMapping
	public ResponseEntity<Perfil_Permissao> criar(@Valid @RequestBody Perfil_Permissao perfilPermissao, HttpServletResponse response) {
		Perfil_Permissao perfilPermissaoSalvo = perfilPermissaoRepository.save(perfilPermissao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, perfilPermissaoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilPermissaoSalvo);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Perfil_Permissao> atualizar(@PathVariable Long id, @Valid @RequestBody Perfil_Permissao perfilPermissao) {
		Perfil_Permissao perfilPermissaoAtualizada = perfilPermissaoService.atualizar(id, perfilPermissao);
		return ResponseEntity.ok(perfilPermissaoAtualizada);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		perfilPermissaoRepository.deleteById(id);
	}
	
}
