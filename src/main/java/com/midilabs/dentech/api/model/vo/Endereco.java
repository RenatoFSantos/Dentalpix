package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.midilabs.dentech.api.model.domain.TipoEndereco;

@Entity
@Table(name = "endereco")
public class Endereco extends EntityBase {


	private static final long serialVersionUID = 1L;

	private String ende_ds_logradouro;
	private String ende_ds_complemento;
	private String ende_ds_numero;
	private String ende_nm_bairro;
	private String ende_nm_cidade;
	private String ende_sg_uf;
	private String ende_cd_cep;
	private String ende_ds_telefone;

	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ende_sq_id")
	public Long getId() {
		return super.getId();
	}

	@NotNull
	@Size(min=3, max=100)
	public String getEnde_ds_logradouro() {
		return ende_ds_logradouro;
	}

	public void setEnde_ds_logradouro(String ende_ds_logradouro) {
		this.ende_ds_logradouro = ende_ds_logradouro;
	}

	public String getEnde_ds_complemento() {
		return ende_ds_complemento;
	}

	public void setEnde_ds_complemento(String ende_ds_complemento) {
		this.ende_ds_complemento = ende_ds_complemento;
	}

	public String getEnde_ds_numero() {
		return ende_ds_numero;
	}

	public void setEnde_ds_numero(String ende_ds_numero) {
		this.ende_ds_numero = ende_ds_numero;
	}

	public String getEnde_nm_bairro() {
		return ende_nm_bairro;
	}

	public void setEnde_nm_bairro(String ende_nm_bairro) {
		this.ende_nm_bairro = ende_nm_bairro;
	}

	public String getEnde_nm_cidade() {
		return ende_nm_cidade;
	}

	public void setEnde_nm_cidade(String ende_nm_cidade) {
		this.ende_nm_cidade = ende_nm_cidade;
	}

	public String getEnde_sg_uf() {
		return ende_sg_uf;
	}

	public void setEnde_sg_uf(String ende_sg_uf) {
		this.ende_sg_uf = ende_sg_uf;
	}

	public String getEnde_cd_cep() {
		return ende_cd_cep;
	}

	public void setEnde_cd_cep(String ende_cd_cep) {
		this.ende_cd_cep = ende_cd_cep;
	}

	public String getEnde_ds_telefone() {
		return ende_ds_telefone;
	}

	public void setEnde_ds_telefone(String ende_ds_telefone) {
		this.ende_ds_telefone = ende_ds_telefone;
	}
}
