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
import com.midilabs.dentech.api.model.vo.PlanoTratamento;
import com.midilabs.dentech.api.repository.PlanoTratamentoRepository;
import com.midilabs.dentech.api.service.PlanoTratamentoService;

@RestController
@RequestMapping("/plano_tratamentos")
public class PlanoTratamentoResource {
	
	@Autowired
	private PlanoTratamentoRepository planoTratamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PlanoTratamentoService planoTratamentoService;
	
	@GetMapping
	public List<PlanoTratamento> listar() {
		return planoTratamentoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PlanoTratamento> buscaPlanoTratamentoPorId(@PathVariable Long id) {
		PlanoTratamento planoTratamentoSalvo = planoTratamentoService.buscaPlanoTratamentoPorId(id);
		return planoTratamentoSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(planoTratamentoSalvo);
	}

	@PostMapping
	public ResponseEntity<PlanoTratamento> criar(@Valid @RequestBody PlanoTratamento planoTratamento, HttpServletResponse response) {
		PlanoTratamento planoTratamentoSalvo = planoTratamentoRepository.save(planoTratamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, planoTratamentoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(planoTratamentoSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PlanoTratamento> atualizar(@PathVariable Long id, PlanoTratamento planoTratamento) {
		PlanoTratamento planoTratamentoSalvo = planoTratamentoService.atualizar(id, planoTratamento);
		return ResponseEntity.ok(planoTratamentoSalvo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		planoTratamentoRepository.deleteById(id);
	}
	
	
	
}
