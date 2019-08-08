package com.midilabs.dentech.api.resource;

import java.util.List;

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
import com.midilabs.dentech.api.model.vo.Dentista;
import com.midilabs.dentech.api.repository.DentistaRepository;
import com.midilabs.dentech.api.repository.filter.DentistaFilter;
import com.midilabs.dentech.api.service.DentistaService;

@RestController
@RequestMapping("/dentistas")
public class DentistaResource {
	
	@Autowired
	private DentistaRepository dentistaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private DentistaService dentistaService;
	

//	@GetMapping
//	public List<Dentista> listar() {
//		return dentistaRepository.findAll(); 
//	}
	
	@GetMapping
	public Page<Dentista> pesquisar(DentistaFilter dentistaFilter, Pageable pageable) {
		return dentistaRepository.filtrar(dentistaFilter, pageable);
	}
	
	@PostMapping
	public ResponseEntity<Dentista> criar(@Valid @RequestBody Dentista dentista, HttpServletResponse response) {
		Dentista dentistaSalvo = dentistaRepository.save(dentista);
		
		publisher.publishEvent(new RecursoCriadoEvent(dentistaSalvo, response, dentistaSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dentistaSalvo);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dentista> buscarDentistaPorId(@PathVariable Long id) {
		Dentista objDentista = dentistaService.buscaDentistaPorId(id);
		return objDentista == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(objDentista); 
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		dentistaRepository.deleteById(id);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Dentista> atualizar(@PathVariable Long id, @RequestBody Dentista dentista) {
		Dentista objDentista = dentistaService.atualizar(id, dentista);
		
		return ResponseEntity.ok(objDentista);
	}
	
}
