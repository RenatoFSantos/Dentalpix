package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Responsavel.class)
public abstract class Responsavel_ {

	public static volatile SingularAttribute<Responsavel, String> resp_ds_celular;
	public static volatile SingularAttribute<Responsavel, Endereco> endereco;
	public static volatile SingularAttribute<Responsavel, String> resp_nm_responsavel;
	public static volatile SingularAttribute<Responsavel, String> resp_ds_email;
	public static volatile SingularAttribute<Responsavel, Long> id;

	public static final String RESP_DS_CELULAR = "resp_ds_celular";
	public static final String ENDERECO = "endereco";
	public static final String RESP_NM_RESPONSAVEL = "resp_nm_responsavel";
	public static final String RESP_DS_EMAIL = "resp_ds_email";
	public static final String ID = "id";

}

