package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClinicaDentista.class)
public abstract class ClinicaDentista_ {

	public static volatile SingularAttribute<ClinicaDentista, Clinica> clinica;
	public static volatile SingularAttribute<ClinicaDentista, Dentista> dentista;
	public static volatile SingularAttribute<ClinicaDentista, Long> id;

	public static final String CLINICA = "clinica";
	public static final String DENTISTA = "dentista";
	public static final String ID = "id";

}

