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
import com.midilabs.dentech.api.model.vo.Paciente;
import com.midilabs.dentech.api.repository.PacienteRepository;
import com.midilabs.dentech.api.repository.filter.PacienteFilter;
import com.midilabs.dentech.api.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PacienteService pacienteService;
	
	
//	@GetMapping
//	public List<Paciente> listar() {
//		return pacienteRepository.findAll();
//	}
	
	@GetMapping
	public Page<Paciente> pesquisar(PacienteFilter pacienteFilter, Pageable pageable) {
		return pacienteRepository.filtrar(pacienteFilter, pageable);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id) {
		Paciente pacienteSalvo = pacienteService.buscaPacientePorId(id);
		return pacienteSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(pacienteSalvo);
	}
	
	@PostMapping
	public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente, HttpServletResponse response) {
		Paciente pacienteSalvo = pacienteRepository.save(paciente);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pacienteSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
		Paciente pacienteAtualizado = this.pacienteService.atualizar(id, paciente);
		return ResponseEntity.ok(pacienteAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.pacienteRepository.deleteById(id);
	}
	

}
