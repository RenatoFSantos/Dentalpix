package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="responsavel")
public class Responsavel extends EntityBase {


	private static final long serialVersionUID = 1L;
	
	private String resp_nm_responsavel;
	private String resp_ds_celular;
	private String resp_ds_email;
	private Endereco endereco;
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
		
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resp_sq_id")
	public Long getId() {
		return super.getId();
	}	
	
	@NotNull
	public String getResp_nm_responsavel() {
		return resp_nm_responsavel;
	}
	public void setResp_nm_responsavel(String resp_nm_responsavel) {
		this.resp_nm_responsavel = resp_nm_responsavel;
	}
	
	public String getResp_ds_celular() {
		return resp_ds_celular;
	}
	public void setResp_ds_celular(String resp_ds_celular) {
		this.resp_ds_celular = resp_ds_celular;
	}
	
	public String getResp_ds_email() {
		return resp_ds_email;
	}
	public void setResp_ds_email(String resp_ds_email) {
		this.resp_ds_email = resp_ds_email;
	}
	
	@OneToOne
	@JoinColumn(name = "ende_sq_id", nullable=false)
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
