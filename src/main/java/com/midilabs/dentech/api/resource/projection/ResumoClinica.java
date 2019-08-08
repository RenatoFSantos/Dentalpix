package com.midilabs.dentech.api.resource.projection;

public class ResumoClinica {

	private Long   rcli_sq_id;
	private String rcli_nm_clinica;
	private Boolean rcli_in_ativo;
	
	// *********************************************
	// --- Construtor
	// *********************************************
	
	public ResumoClinica(Long rcli_sq_id, String rcli_nm_clinica, Boolean rcli_in_ativo) {
		super();
		this.rcli_sq_id = rcli_sq_id;
		this.rcli_nm_clinica = rcli_nm_clinica;
		this.rcli_in_ativo = rcli_in_ativo;
	}
	
	// *********************************************
	// --- GETs, SETs
	// *********************************************
	
	public Long getRcli_sq_id() {
		return rcli_sq_id;
	}
	public void setRcli_sq_id(Long rcli_sq_id) {
		this.rcli_sq_id = rcli_sq_id;
	}
	public String getRcli_nm_clinica() {
		return rcli_nm_clinica;
	}
	public void setRcli_nm_clinica(String rcli_nm_clinica) {
		this.rcli_nm_clinica = rcli_nm_clinica;
	}
	public Boolean getRcli_in_ativo() {
		return rcli_in_ativo;
	}
	public void setRcli_in_ativo(Boolean rcli_in_ativo) {
		this.rcli_in_ativo = rcli_in_ativo;
	}
	
	
}
