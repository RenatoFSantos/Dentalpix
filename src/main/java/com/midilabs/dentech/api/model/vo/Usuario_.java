package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, Clinica> clinica;
	public static volatile SingularAttribute<Usuario, String> usua_ds_senha;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, String> usua_nm_usuario;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> usua_ds_email;
	public static volatile SingularAttribute<Usuario, Perfil> perfil;

	public static final String CLINICA = "clinica";
	public static final String USUA_DS_SENHA = "usua_ds_senha";
	public static final String ID = "id";
	public static final String USUA_NM_USUARIO = "usua_nm_usuario";
	public static final String EMAIL = "email";
	public static final String USUA_DS_EMAIL = "usua_ds_email";
	public static final String PERFIL = "perfil";

}

