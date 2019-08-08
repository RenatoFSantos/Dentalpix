package com.midilabs.dentech.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.midilabs.dentech.api.event.RecursoCriadoEvent;
import com.midilabs.dentech.api.model.vo.Permissao;
import com.midilabs.dentech.api.repository.PermissaoRepository;
import com.midilabs.dentech.api.service.PermissaoService;

@Controller
@RequestMapping("/permissao")
public class PermissaoResource {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PermissaoService permissaoService;
	
	
	@GetMapping
	public List<Permissao> listar() {
		return permissaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Permissao> buscarPermissaoPorId(@PathVariable Long id) {
		Permissao permissaoSalvo = permissaoService.buscarPermissaoPorId(id);
		return permissaoSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(permissaoSalvo);
		
	}
		
	@PostMapping
	public ResponseEntity<Permissao> criar(@Valid @RequestBody Permissao permissao, HttpServletResponse response) {
		Permissao permissaoSalvo = permissaoRepository.save(permissao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, permissaoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(permissaoSalvo);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Permissao> atualizar(@PathVariable Long id, @Valid @RequestBody Permissao permissao) {
		Permissao permissaoAtualizada = permissaoService.atualizar(id, permissao);
		return ResponseEntity.ok(permissaoAtualizada);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		permissaoRepository.deleteById(id);
	}
	
}
