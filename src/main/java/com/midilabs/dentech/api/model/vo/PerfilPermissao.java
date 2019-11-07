package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "perfil_permissao")
public class PerfilPermissao extends EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Perfil perfil;
	private Permissao permissao;

	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pepe_sq_id")
	public Long getId() {
		return super.getId();
	}

	@ManyToOne
	@JoinColumn(name="perf_sq_id")
	@JsonBackReference
	public Perfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	@ManyToOne
	@JoinColumn(name="perm_sq_id")
	public Permissao getPermissao() {
		return permissao;
	}


	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}




}
