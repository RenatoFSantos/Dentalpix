package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clinica")
public class Clinica extends EntityBase {

	private static final long serialVersionUID = 1L;

	private String		clin_nm_clinica;
	
	private Endereco 	endereco;
	
	private String		clin_ds_celular;
	private String		clin_ds_email;
	private String		clin_in_documento;
	private String		clin_cd_documento;
	
	private Boolean		clin_in_ativo;

	// ***************************************************
	// --- Método não interpretado pelo conversor Jackson
	// --- e também não será interpretado pelo Hibernate
	// ***************************************************
	
	@JsonIgnore
	@Transient
	public boolean isInativo() {
		return !this.clin_in_ativo;
	}
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************


	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clin_sq_id")
	public Long getId() {
		return super.getId();
	}
	
	
	@NotNull
	@Size(min=3, max=100)
	public String getClin_nm_clinica() {
		return clin_nm_clinica;
	}
	public void setClin_nm_clinica(String clin_nm_clinica) {
		this.clin_nm_clinica = clin_nm_clinica;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "ende_sq_id")
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getClin_ds_celular() {
		return clin_ds_celular;
	}
	public void setClin_ds_celular(String clin_ds_celular) {
		this.clin_ds_celular = clin_ds_celular;
	}
	
	public String getClin_ds_email() {
		return clin_ds_email;
	}
	public void setClin_ds_email(String clin_ds_email) {
		this.clin_ds_email = clin_ds_email;
	}
	
	public String getClin_in_documento() {
		return clin_in_documento;
	}
	public void setClin_in_documento(String clin_in_documento) {
		this.clin_in_documento = clin_in_documento;
	}
	
	public String getClin_cd_documento() {
		return clin_cd_documento;
	}
	public void setClin_cd_documento(String clin_cd_documento) {
		this.clin_cd_documento = clin_cd_documento;
	}
	
	@NotNull
	public Boolean getClin_in_ativo() {
		return clin_in_ativo;
	}
	public void setClin_in_ativo(Boolean clin_in_ativo) {
		this.clin_in_ativo = clin_in_ativo;
	}

}
