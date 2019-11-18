package com.midilabs.dentech.api.model.domain;

public enum TipoCategoria {
	R("Receita"),
	D("Despesa");
	
	private String Tipo;
	
	private TipoCategoria(String tipo) {
		this.Tipo = tipo;
	}

	public String getTipo() {
		return Tipo;
	}

}
