package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procedimento")
public class Procedimento extends EntityBase {
	

	private static final long serialVersionUID = 1L;
	private String proc_cd_procedimento;
	private String proc_ds_procedimento;
	private Double proc_vl_referencia;

	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proc_sq_id")
	public Long getId() {
		return super.getId();
	}

	public String getProc_cd_procedimento() {
		return proc_cd_procedimento;
	}

	public void setProc_cd_procedimento(String proc_cd_procedimento) {
		this.proc_cd_procedimento = proc_cd_procedimento;
	}

	public String getProc_ds_procedimento() {
		return proc_ds_procedimento;
	}

	public void setProc_ds_procedimento(String proc_ds_procedimento) {
		this.proc_ds_procedimento = proc_ds_procedimento;
	}

	public Double getProc_vl_referencia() {
		return proc_vl_referencia;
	}

	public void setProc_vl_referencia(Double proc_vl_referencia) {
		this.proc_vl_referencia = proc_vl_referencia;
	}
	
	
	
}
