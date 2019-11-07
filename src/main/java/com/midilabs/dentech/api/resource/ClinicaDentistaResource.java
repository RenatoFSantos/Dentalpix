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
import com.midilabs.dentech.api.model.vo.ClinicaDentista;
import com.midilabs.dentech.api.repository.ClinicaDentistaRepository;
import com.midilabs.dentech.api.service.ClinicaDentistaService;

@RestController
@RequestMapping("/clinica_dentistas")
public class ClinicaDentistaResource {

	@Autowired
	private ClinicaDentistaRepository clinicaDentistaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ClinicaDentistaService clinicaDentistaService;
	
	@GetMapping
	public List<ClinicaDentista> listar() {
		return clinicaDentistaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClinicaDentista> buscarDentistaPorId(@PathVariable Long id) {
		ClinicaDentista clinicaDentistaSalvo = clinicaDentistaService.buscarClinicaDentistaPorId(id);
		return clinicaDentistaSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(clinicaDentistaSalvo);
	}
	
	@PostMapping
	public ResponseEntity<ClinicaDentista> criar(@Valid @RequestBody ClinicaDentista clinicaDentista, HttpServletResponse response) {
		ClinicaDentista clinicaDentistaSalvo = clinicaDentistaRepository.save(clinicaDentista);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clinicaDentistaSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clinicaDentistaSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClinicaDentista> atualizar(@PathVariable Long id, @Valid @RequestBody ClinicaDentista clinicaDentista) {
		ClinicaDentista clinicaDentistaAtualizado = clinicaDentistaService.atualizar(id, clinicaDentista);
		return ResponseEntity.ok(clinicaDentistaAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		clinicaDentistaRepository.deleteById(id);
	}
	
	
}
