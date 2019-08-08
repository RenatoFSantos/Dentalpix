package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perfil.class)
public abstract class Perfil_ {

	public static volatile SingularAttribute<Perfil, String> perf_nm_perfil;
	public static volatile SetAttribute<Perfil, Permissao> permissaos;
	public static volatile SingularAttribute<Perfil, Long> id;
	public static volatile SingularAttribute<Perfil, String> perf_sg_perfil;

	public static final String PERF_NM_PERFIL = "perf_nm_perfil";
	public static final String PERMISSAOS = "permissaos";
	public static final String ID = "id";
	public static final String PERF_SG_PERFIL = "perf_sg_perfil";

}

