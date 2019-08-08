package com.midilabs.dentech.api.model.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "permissao")
public class Permissao extends EntityBase {

	private Perfil perfil;
	private Processo processo;
	private String perm_ds_permissao;

	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perm_sq_id")
	public Long getId() {
		return super.getId();
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="perf_sq_id")
	@JsonBackReference
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="proc_sq_id")
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	@NotNull
	public String getPerm_ds_permissao() {
		return perm_ds_permissao;
	}
	public void setPerm_ds_permissao(String perm_ds_permissao) {
		this.perm_ds_permissao = perm_ds_permissao;
	}

}
