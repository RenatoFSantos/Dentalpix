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
import com.midilabs.dentech.api.model.vo.Perfil;
import com.midilabs.dentech.api.repository.PerfilRepository;
import com.midilabs.dentech.api.service.PerfilService;

@RestController
@RequestMapping("/perfils")
public class PerfilResource {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public List<Perfil> listar() {
		return perfilRepository.findAll();
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<Perfil> buscarPerfilPorId(@PathVariable Long id) {
		Perfil perfilSalvo = perfilService.buscarPerfilPorId(id);
		return perfilSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(perfilSalvo);
	}
	
	@PostMapping
	public ResponseEntity<Perfil> criar(@Valid @RequestBody Perfil perfil, HttpServletResponse response) {
		Perfil perfilSalvo = perfilRepository.save(perfil);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, perfilSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilSalvo);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<Perfil> atualizar(@PathVariable Long id, @Valid @RequestBody Perfil perfil) {
		Perfil perfilSalvo = perfilService.atualizar(id, perfil);
		return ResponseEntity.ok(perfilSalvo);
	}
	
	@DeleteMapping("{/id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.perfilRepository.deleteById(id);
	}
		
	
	
}
