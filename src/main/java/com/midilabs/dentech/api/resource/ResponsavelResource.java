package com.midilabs.dentech.api.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.midilabs.dentech.api.model.vo.Responsavel;
import com.midilabs.dentech.api.repository.ResponsavelRepository;
import com.midilabs.dentech.api.repository.filter.ResponsavelFilter;
import com.midilabs.dentech.api.service.ResponsavelService;

@RestController
@RequestMapping("/responsavels")
public class ResponsavelResource {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	@Autowired
	private ResponsavelService responsavelService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	@GetMapping
//	public List<Responsavel> listar() {
//		return responsavelRepository.findAll();
//	}
	
	@GetMapping
	public Page<Responsavel> pesquisar(ResponsavelFilter responsavelFilter, Pageable pageable) {
		return responsavelRepository.filtrar(responsavelFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Responsavel> buscarResponsavelPorId(@PathVariable Long id) {
		Responsavel responsavelSalvo = responsavelService.buscarResponsavelPorId(id);
		return responsavelSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(responsavelSalvo);
	}
	
	@PostMapping
	public ResponseEntity<Responsavel> criar(@Valid @RequestBody Responsavel responsavel, HttpServletResponse response) {
		Responsavel responsavelSalvo = responsavelRepository.save(responsavel);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, responsavelSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(responsavelSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Responsavel> atualizar(@PathVariable Long id, @Valid @RequestBody Responsavel responsavel) {
		Responsavel responsavelAtualizado = responsavelService.atualizar(id, responsavel);
		return ResponseEntity.ok(responsavelAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		responsavelRepository.deleteById(id);
	}
	

	
}
