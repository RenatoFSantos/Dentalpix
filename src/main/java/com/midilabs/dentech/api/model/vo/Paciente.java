package com.midilabs.dentech.api.model.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente extends EntityBase {

	private static final long serialVersionUID = 1L;
	
	private String paci_nm_paciente;
	private String paci_ds_celular;
	private String paci_ds_email;
	private Endereco endereco;
	private Responsavel responsavel;
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
		
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paci_sq_id")
	public Long getId() {
		return super.getId();
	}	
		
	public String getPaci_nm_paciente() {
		return paci_nm_paciente;
	}
	public void setPaci_nm_paciente(String paci_nm_paciente) {
		this.paci_nm_paciente = paci_nm_paciente;
	}
	
	public String getPaci_ds_celular() {
		return paci_ds_celular;
	}
	public void setPaci_ds_celular(String paci_ds_celular) {
		this.paci_ds_celular = paci_ds_celular;
	}
	
	public String getPaci_ds_email() {
		return paci_ds_email;
	}
	public void setPaci_ds_email(String paci_ds_email) {
		this.paci_ds_email = paci_ds_email;
	}
	
	@OneToOne
	@JoinColumn(name="ende_sq_id", nullable=false)
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="resp_sq_id", nullable=true, insertable=false, updatable=false)
	public Responsavel getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

}
