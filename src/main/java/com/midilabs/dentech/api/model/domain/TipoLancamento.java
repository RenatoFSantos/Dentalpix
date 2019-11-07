package com.midilabs.dentech.api.model.domain;

public enum TipoLancamento {
	C("Crédito"),
	D("Débito");
	
	private String Tipo;
	
	private TipoLancamento(String tipo) {
		this.Tipo = tipo;
	}

	public String getTipo() {
		return Tipo;
	}

}
