package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Permissao.class)
public abstract class Permissao_ {

	public static volatile SingularAttribute<Permissao, Processo> processo;
	public static volatile SingularAttribute<Permissao, String> perm_ds_permissao;
	public static volatile SingularAttribute<Permissao, Long> id;
	public static volatile SingularAttribute<Permissao, Perfil> perfil;

	public static final String PROCESSO = "processo";
	public static final String PERM_DS_PERMISSAO = "perm_ds_permissao";
	public static final String ID = "id";
	public static final String PERFIL = "perfil";

}

