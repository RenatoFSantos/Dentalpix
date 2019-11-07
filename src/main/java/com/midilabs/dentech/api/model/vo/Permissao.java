package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "permissao")
public class Permissao extends EntityBase {

	private static final long serialVersionUID = 1L;
	private String perm_ds_permissao;
	
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

	@NotNull
	public String getPerm_ds_permissao() {
		return perm_ds_permissao;
	}

	public void setPerm_ds_permissao(String perm_ds_permissao) {
		this.perm_ds_permissao = perm_ds_permissao;
	}



}
