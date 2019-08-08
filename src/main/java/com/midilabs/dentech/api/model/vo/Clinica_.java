package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Clinica.class)
public abstract class Clinica_ {

	public static volatile SingularAttribute<Clinica, String> clin_ds_email;
	public static volatile SingularAttribute<Clinica, Endereco> endereco;
	public static volatile SingularAttribute<Clinica, String> clin_ds_celular;
	public static volatile SingularAttribute<Clinica, Boolean> clin_in_ativo;
	public static volatile SingularAttribute<Clinica, String> clin_nm_clinica;
	public static volatile SingularAttribute<Clinica, Long> id;
	public static volatile SingularAttribute<Clinica, String> clin_cd_documento;
	public static volatile SingularAttribute<Clinica, String> clin_in_documento;

	public static final String CLIN_DS_EMAIL = "clin_ds_email";
	public static final String ENDERECO = "endereco";
	public static final String CLIN_DS_CELULAR = "clin_ds_celular";
	public static final String CLIN_IN_ATIVO = "clin_in_ativo";
	public static final String CLIN_NM_CLINICA = "clin_nm_clinica";
	public static final String ID = "id";
	public static final String CLIN_CD_DOCUMENTO = "clin_cd_documento";
	public static final String CLIN_IN_DOCUMENTO = "clin_in_documento";

}

