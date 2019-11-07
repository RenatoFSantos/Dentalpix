package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perfil_Permissao.class)
public abstract class Perfil_Permissao_ {

	public static volatile SingularAttribute<Perfil_Permissao, Long> id;
	public static volatile SingularAttribute<Perfil_Permissao, Permissao> permissao;
	public static volatile SingularAttribute<Perfil_Permissao, Perfil> perfil;

	public static final String ID = "id";
	public static final String PERMISSAO = "permissao";
	public static final String PERFIL = "perfil";

}

