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
import javax.validation.constraints.Size;

@Entity
@Table(name = "dentista")
public class Dentista extends EntityBase {
	

	private static final long serialVersionUID = 1L;

	private String dett_nm_dentista;
	private String dett_cd_cro;
	private Endereco endereco;
	private String dett_ds_celular;
	private String dett_ds_email;
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
		
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dett_sq_id")
	public Long getId() {
		return super.getId();
	}

	@NotNull
	@Size(min=3, max=100)
	public String getDett_nm_dentista() {
		return dett_nm_dentista;
	}
	public void setDett_nm_dentista(String dett_nm_dentista) {
		this.dett_nm_dentista = dett_nm_dentista;
	}

	@OneToOne
	@JoinColumn(name = "ende_sq_id", nullable=false)
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getDett_cd_cro() {
		return dett_cd_cro;
	}
	public void setDett_cd_cro(String dett_cd_cro) {
		this.dett_cd_cro = dett_cd_cro;
	}
	
	public String getDett_ds_celular() {
		return dett_ds_celular;
	}
	public void setDett_ds_celular(String dett_ds_celular) {
		this.dett_ds_celular = dett_ds_celular;
	}
	
	public String getDett_ds_email() {
		return dett_ds_email;
	}
	public void setDett_ds_email(String dett_ds_email) {
		this.dett_ds_email = dett_ds_email;
	}
	
}
