package com.midilabs.dentech.api.model.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="perfil")
public class Perfil extends EntityBase {


	private static final long serialVersionUID = 1L;

	private String perf_nm_perfil;
	private String perf_sg_perfil;
	private Set<Perfil_Permissao> permissaos = new HashSet<Perfil_Permissao>();

	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perf_sq_id")
	public Long getId() {
		return super.getId();
	}

	@NotNull
	public String getPerf_nm_perfil() {
		return perf_nm_perfil;
	}

	public void setPerf_nm_perfil(String perf_nm_perfil) {
		this.perf_nm_perfil = perf_nm_perfil;
	}
	
	public String getPerf_sg_perfil() {
		return perf_sg_perfil;
	}

	public void setPerf_sg_perfil(String perf_sg_perfil) {
		this.perf_sg_perfil = perf_sg_perfil;
	}

	@OneToMany(mappedBy="perfil", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Perfil_Permissao> getPermissaos() {
		return permissaos;
	}

	public void setPermissaos(Set<Perfil_Permissao> permissaos) {
		this.permissaos = permissaos;
	}
}
