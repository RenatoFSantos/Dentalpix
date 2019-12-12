package com.midilabs.dentech.api.model.vo;

import com.midilabs.dentech.api.model.domain.TipoPagamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PlanoTratamento.class)
public abstract class PlanoTratamento_ {

	public static volatile SingularAttribute<PlanoTratamento, String> pltr_in_status;
	public static volatile SingularAttribute<PlanoTratamento, Integer> pltr_nr_totalparcelas;
	public static volatile SingularAttribute<PlanoTratamento, Date> pltr_dt_termino;
	public static volatile SingularAttribute<PlanoTratamento, TipoPagamento> pltr_in_pagamento;
	public static volatile SingularAttribute<PlanoTratamento, String> pltr_tx_observacao;
	public static volatile SingularAttribute<PlanoTratamento, DentistaPaciente> dentistaPaciente;
	public static volatile SingularAttribute<PlanoTratamento, Date> pltr_dt_inicio;
	public static volatile SingularAttribute<PlanoTratamento, Long> id;
	public static volatile SingularAttribute<PlanoTratamento, TabelaPreco> tabelaPreco;
	public static volatile SingularAttribute<PlanoTratamento, Date> pltr_dt_plano;
	public static volatile SingularAttribute<PlanoTratamento, Double> pltr_vr_tratamento;

	public static final String PLTR_IN_STATUS = "pltr_in_status";
	public static final String PLTR_NR_TOTALPARCELAS = "pltr_nr_totalparcelas";
	public static final String PLTR_DT_TERMINO = "pltr_dt_termino";
	public static final String PLTR_IN_PAGAMENTO = "pltr_in_pagamento";
	public static final String PLTR_TX_OBSERVACAO = "pltr_tx_observacao";
	public static final String DENTISTA_PACIENTE = "dentistaPaciente";
	public static final String PLTR_DT_INICIO = "pltr_dt_inicio";
	public static final String ID = "id";
	public static final String TABELA_PRECO = "tabelaPreco";
	public static final String PLTR_DT_PLANO = "pltr_dt_plano";
	public static final String PLTR_VR_TRATAMENTO = "pltr_vr_tratamento";

}

