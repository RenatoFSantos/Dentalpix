package com.midilabs.dentech.api.model.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "permissao")
public class Permissao extends EntityBase {

	private static final long serialVersionUID = 1L;
	private String perm_ds_permissao;
//	private List<PerfilPermissao> perfil = new ArrayList<>();
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="perm_sq_id")
	public Long getId() {
		return super.getId();
	}

	public String getPerm_ds_permissao() {
		return perm_ds_permissao;
	}

	public void setPerm_ds_permissao(String perm_ds_permissao) {
		this.perm_ds_permissao = perm_ds_permissao;
	}

//	@OneToMany(mappedBy="permissao", cascade=CascadeType.ALL)
//	@JsonBackReference
//	public List<PerfilPermissao> getPerfil() {
//		return perfil;
//	}
//
//	public void setPerfil(List<PerfilPermissao> perfil) {
//		this.perfil = perfil;
//	}

}
