package com.midilabs.dentech.api.repository.filter;

public class PacienteFilter {

	private String nome;
	private String celular;
	private String email;
	
	// *********************************************
	// --- GETs, SETs
	// *********************************************
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
