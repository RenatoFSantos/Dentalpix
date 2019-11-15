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
import com.midilabs.dentech.api.model.vo.DentistaPaciente;
import com.midilabs.dentech.api.repository.DentistaPacienteRepository;
import com.midilabs.dentech.api.service.DentistaPacienteService;

@RestController
@RequestMapping("/dentista_pacientes")
public class DentistaPacienteResource {
	
	@Autowired
	private DentistaPacienteRepository dentistaPacienteRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private DentistaPacienteService dentistaPacienteService;
	
	@GetMapping
	public List<DentistaPaciente> listar() {
		return dentistaPacienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DentistaPaciente> buscarDentistaPacientePorId(@PathVariable Long id) {
		DentistaPaciente dentistaPacienteSalvo = dentistaPacienteService.buscarDentistaPacientePorId(id);
		return dentistaPacienteSalvo == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(dentistaPacienteSalvo); 
	}

	@PostMapping
	public ResponseEntity<DentistaPaciente> criar(@Valid @RequestBody DentistaPaciente dentistaPaciente, HttpServletResponse response) {
		DentistaPaciente dentistaPacienteSalvo = dentistaPacienteRepository.save(dentistaPaciente);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, dentistaPacienteSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(dentistaPacienteSalvo);
	}	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<DentistaPaciente> atualizar(@PathVariable Long id, @Valid @RequestBody DentistaPaciente dentistaPaciente) {
		DentistaPaciente dentistaPacienteAtualizado = dentistaPacienteService.atualizar(id, dentistaPaciente);
		return ResponseEntity.ok(dentistaPacienteAtualizado);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		dentistaPacienteRepository.deleteById(id);
	}

}
