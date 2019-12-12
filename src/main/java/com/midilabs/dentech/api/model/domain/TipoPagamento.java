package com.midilabs.dentech.api.model.domain;

public enum TipoPagamento {
	V("a Vista"),
	P("a Prazo");
	
	private String tipo;
	
	TipoPagamento(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
