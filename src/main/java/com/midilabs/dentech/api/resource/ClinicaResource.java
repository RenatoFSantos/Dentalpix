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
import com.midilabs.dentech.api.model.vo.Clinica;
import com.midilabs.dentech.api.repository.ClinicaRepository;
import com.midilabs.dentech.api.repository.filter.ClinicaFilter;
import com.midilabs.dentech.api.resource.projection.ResumoClinica;
import com.midilabs.dentech.api.service.ClinicaService;

@RestController
@RequestMapping("/clinicas")
public class ClinicaResource {
	
	@Autowired
	private ClinicaRepository clinicaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ClinicaService clinicaService;
	
	@GetMapping
//	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CLINICA')")
	public Page<Clinica> pesquisar(ClinicaFilter clinicaFilter, Pageable pageable) {
		return clinicaRepository.filtrar(clinicaFilter, pageable);
		
	}
	
	@GetMapping(params = "resumo")
	public Page<ResumoClinica> resumir(ClinicaFilter clinicaFilter, Pageable pageable) {
		return clinicaRepository.resumir(clinicaFilter, pageable);
		
	}
	
	@PostMapping
	public ResponseEntity<Clinica> criar(@Valid @RequestBody Clinica clinica, HttpServletResponse response) {
		Clinica clinicaSalvo = clinicaRepository.save(clinica);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, clinicaSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clinicaSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clinica> buscarPeloId(@PathVariable Long id) {
		Clinica objClinica = clinicaRepository.findById(id).orElse(null);
		return objClinica == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(objClinica);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		clinicaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Clinica> atualizar(@PathVariable Long id, @Valid @RequestBody Clinica clinica) {
		Clinica objClinica = clinicaService.atualizar(id, clinica);
		return ResponseEntity.ok(objClinica);
	}
	

}
