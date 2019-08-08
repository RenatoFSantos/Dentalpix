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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "perfil")
public class Perfil extends EntityBase {
	
	private String perf_nm_perfil;
	private String perf_sg_perfil;
	private Set<Permissao> permissaos = new HashSet<Permissao>();

	
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

	@OneToMany(mappedBy="perfil", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonManagedReference
	public Set<Permissao> getPermissaos() {
		return permissaos;
	}

	public void setPermissaos(Set<Permissao> permissaos) {
		this.permissaos = permissaos;
	}

	
}
