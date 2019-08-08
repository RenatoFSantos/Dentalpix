package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "processo")
public class Processo extends EntityBase {

	private String proc_nm_processo;
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="proc_sq_id")
	public Long getId() {
		return super.getId();
	}

	@NotNull
	public String getProc_nm_processo() {
		return proc_nm_processo;
	}
	public void setProc_nm_processo(String proc_nm_processo) {
		this.proc_nm_processo = proc_nm_processo;
	}

}
