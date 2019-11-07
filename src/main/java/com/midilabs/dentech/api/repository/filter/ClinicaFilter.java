package com.midilabs.dentech.api.repository.filter;

public class ClinicaFilter {
	
	private String nome;
	private String documento;
	private Boolean ativa;
	
	// *********************************************
	// --- GETs, SETs
	// *********************************************

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}
	

}
