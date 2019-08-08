package com.midilabs.dentech.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.midilabs.dentech.api.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {
		HttpServletResponse response = event.getResponse();
		Long codigo = event.getCodigo();
		
		adicionarHeaderLocaton(response, codigo);
		
	}

	protected void adicionarHeaderLocaton(HttpServletResponse response, Long codigo) {
		// *****************************************************************************
		// Criando uma variável de retorno que será inserida no cabeçalho de resposta
		// Esta variável conterá a uri de conexão para retorno do registro inserido
		// *****************************************************************************
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
