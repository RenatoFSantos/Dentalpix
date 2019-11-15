package com.midilabs.dentech.api.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DentistaPaciente.class)
public abstract class DentistaPaciente_ {

	public static volatile SingularAttribute<DentistaPaciente, Paciente> paciente;
	public static volatile SingularAttribute<DentistaPaciente, Dentista> dentista;
	public static volatile SingularAttribute<DentistaPaciente, Long> id;

	public static final String PACIENTE = "paciente";
	public static final String DENTISTA = "dentista";
	public static final String ID = "id";

}

