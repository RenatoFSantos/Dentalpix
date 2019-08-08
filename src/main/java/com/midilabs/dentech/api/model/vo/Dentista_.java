package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dentista.class)
public abstract class Dentista_ {

	public static volatile SingularAttribute<Dentista, Endereco> endereco;
	public static volatile SingularAttribute<Dentista, String> dett_cd_cro;
	public static volatile SingularAttribute<Dentista, String> dett_nm_dentista;
	public static volatile SingularAttribute<Dentista, String> dett_ds_email;
	public static volatile SingularAttribute<Dentista, Long> id;
	public static volatile SingularAttribute<Dentista, String> dett_ds_celular;

	public static final String ENDERECO = "endereco";
	public static final String DETT_CD_CRO = "dett_cd_cro";
	public static final String DETT_NM_DENTISTA = "dett_nm_dentista";
	public static final String DETT_DS_EMAIL = "dett_ds_email";
	public static final String ID = "id";
	public static final String DETT_DS_CELULAR = "dett_ds_celular";

}

