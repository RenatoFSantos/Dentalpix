package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabela_preco")
public class TabelaPreco extends EntityBase {

	
	private static final long serialVersionUID = 1L;
	
	private String tapr_nm_tabela;
	private String tapr_ds_tabela;
	private Double tapr_pr_reajuste;
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tapr_sq_id")
	public Long getId() {
		return super.getId();
	}

	public String getTapr_nm_tabela() {
		return tapr_nm_tabela;
	}

	public void setTapr_nm_tabela(String tapr_nm_tabela) {
		this.tapr_nm_tabela = tapr_nm_tabela;
	}

	public String getTapr_ds_tabela() {
		return tapr_ds_tabela;
	}

	public void setTapr_ds_tabela(String tapr_ds_tabela) {
		this.tapr_ds_tabela = tapr_ds_tabela;
	}

	public Double getTapr_pr_reajuste() {
		return tapr_pr_reajuste;
	}

	public void setTapr_pr_reajuste(Double tapr_pr_reajuste) {
		this.tapr_pr_reajuste = tapr_pr_reajuste;
	}
	

}
