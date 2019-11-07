   package com.midilabs.dentech.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.midilabs.dentech.api.event.RecursoCriadoEvent;
import com.midilabs.dentech.api.exceptionhandler.DentechExceptionHandler.Erro;
import com.midilabs.dentech.api.model.vo.Usuario;
import com.midilabs.dentech.api.repository.UsuarioRepository;
import com.midilabs.dentech.api.service.UsuarioService;
import com.midilabs.dentech.api.service.exception.ClinicaInexistenteOuInativaException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioService.salvar(usuario);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id) {
		Usuario objUsuario = usuarioRepository.findById(id).orElse(null);
		return objUsuario == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(objUsuario);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		Usuario objUsuario = usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(objUsuario);
	}
	
	@PutMapping("/{id}/senha")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeSenha(@PathVariable Long id, @Valid @RequestBody String senha) {
		usuarioService.atualizarSenha(id, senha);
	}
	
	@ExceptionHandler({ ClinicaInexistenteOuInativaException.class })
	public ResponseEntity<Object> handleClinicaInexistenteOuInativaException(ClinicaInexistenteOuInativaException ex) {
		String mensagemUsuario = messageSource.getMessage("mensagem.clinica-inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}

}
