package com.midilabs.dentech.api.model.domain;

public enum TipoEndereco {
	C("Clínica"), 
	D("Dentista"), 
	P("Paciente"), 
	R("Responsável");
	
	private String tipo;

	TipoEndereco(String tipo) {
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
