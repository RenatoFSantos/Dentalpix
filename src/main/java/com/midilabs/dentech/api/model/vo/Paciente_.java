package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, String> paci_nm_paciente;
	public static volatile SingularAttribute<Paciente, Endereco> endereco;
	public static volatile SingularAttribute<Paciente, Long> id;
	public static volatile SingularAttribute<Paciente, String> paci_ds_celular;
	public static volatile SingularAttribute<Paciente, String> paci_ds_email;
	public static volatile SingularAttribute<Paciente, Responsavel> responsavel;

	public static final String PACI_NM_PACIENTE = "paci_nm_paciente";
	public static final String ENDERECO = "endereco";
	public static final String ID = "id";
	public static final String PACI_DS_CELULAR = "paci_ds_celular";
	public static final String PACI_DS_EMAIL = "paci_ds_email";
	public static final String RESPONSAVEL = "responsavel";

}

