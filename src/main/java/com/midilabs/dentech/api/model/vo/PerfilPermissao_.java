package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PerfilPermissao.class)
public abstract class PerfilPermissao_ {

	public static volatile SingularAttribute<PerfilPermissao, Long> id;
	public static volatile SingularAttribute<PerfilPermissao, Permissao> permissao;
	public static volatile SingularAttribute<PerfilPermissao, Perfil> perfil;

	public static final String ID = "id";
	public static final String PERMISSAO = "permissao";
	public static final String PERFIL = "perfil";

}

