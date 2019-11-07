package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> ende_ds_telefone;
	public static volatile SingularAttribute<Endereco, String> ende_nm_cidade;
	public static volatile SingularAttribute<Endereco, String> ende_nm_bairro;
	public static volatile SingularAttribute<Endereco, String> ende_sg_uf;
	public static volatile SingularAttribute<Endereco, Long> id;
	public static volatile SingularAttribute<Endereco, String> ende_cd_cep;
	public static volatile SingularAttribute<Endereco, String> ende_ds_logradouro;
	public static volatile SingularAttribute<Endereco, String> ende_ds_complemento;
	public static volatile SingularAttribute<Endereco, String> ende_ds_numero;

	public static final String ENDE_DS_TELEFONE = "ende_ds_telefone";
	public static final String ENDE_NM_CIDADE = "ende_nm_cidade";
	public static final String ENDE_NM_BAIRRO = "ende_nm_bairro";
	public static final String ENDE_SG_UF = "ende_sg_uf";
	public static final String ID = "id";
	public static final String ENDE_CD_CEP = "ende_cd_cep";
	public static final String ENDE_DS_LOGRADOURO = "ende_ds_logradouro";
	public static final String ENDE_DS_COMPLEMENTO = "ende_ds_complemento";
	public static final String ENDE_DS_NUMERO = "ende_ds_numero";

}

