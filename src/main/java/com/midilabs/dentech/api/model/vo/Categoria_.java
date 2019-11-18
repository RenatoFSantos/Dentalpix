package com.midilabs.dentech.api.model.vo;

import com.midilabs.dentech.api.model.domain.TipoCategoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, Long> id;
	public static volatile SingularAttribute<Categoria, TipoCategoria> cate_in_tipo;
	public static volatile SingularAttribute<Categoria, String> cate_nm_categoria;

	public static final String ID = "id";
	public static final String CATE_IN_TIPO = "cate_in_tipo";
	public static final String CATE_NM_CATEGORIA = "cate_nm_categoria";

}

