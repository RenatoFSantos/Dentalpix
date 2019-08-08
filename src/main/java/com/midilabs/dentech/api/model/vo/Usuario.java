package com.midilabs.dentech.api.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="usuario")
public class Usuario extends EntityBase {

	private static final long serialVersionUID = 1L;

	private String usua_nm_usuario;
	private String usua_ds_email;
	private String usua_ds_senha;
	private Clinica clinica;
	private Perfil perfil;
	private String email;
	
	
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usua_sq_id")
	public Long getId() {
		return super.getId();
	}

	@NotNull
	@Size(min=3, max=50)
	public String getUsua_nm_usuario() {
		return usua_nm_usuario;
	}
	public void setUsua_nm_usuario(String usua_nm_usuario) {
		this.usua_nm_usuario = usua_nm_usuario;
	}
	
	public String getUsua_ds_email() {
		return usua_ds_email;
	}
	public void setUsua_ds_email(String usua_ds_email) {
		this.usua_ds_email = usua_ds_email;
	}

	public String getUsua_ds_senha() {
		return usua_ds_senha;
	}
	public void setUsua_ds_senha(String usua_ds_senha) {
		this.usua_ds_senha = usua_ds_senha;
	}

	@ManyToOne
	@JoinColumn(name = "clin_sq_id", nullable = false)
	public Clinica getClinica() {
		return clinica;
	}
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	@ManyToOne
	@JoinColumn(name = "perf_sq_id", nullable = false)
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	
	@Column(name="usua_ds_email", insertable=false, updatable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
