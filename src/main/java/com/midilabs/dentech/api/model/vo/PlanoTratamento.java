package com.midilabs.dentech.api.model.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.midilabs.dentech.api.model.domain.TipoPagamento;

@Entity
@Table(name="plano_tratamento")
public class PlanoTratamento extends EntityBase {

	private static final long serialVersionUID = 1L;
	
	private Date pltr_dt_plano;
	private Date pltr_dt_inicio;
	private Date pltr_dt_termino;
	private TipoPagamento pltr_in_pagamento;
	private Integer pltr_nr_totalparcelas;
	private Double pltr_vr_tratamento;
	private String pltr_in_status;
	private String pltr_tx_observacao;
	private TabelaPreco tabelaPreco;
	private DentistaPaciente dentistaPaciente;
		
	// *********************************************
	// --- GETs, SETs e HashCode
	// *********************************************
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pltr_sq_id")
	public Long getId() {
		return super.getId();
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPltr_dt_plano() {
		return pltr_dt_plano;
	}

	public void setPltr_dt_plano(Date pltr_dt_plano) {
		this.pltr_dt_plano = pltr_dt_plano;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pltr_dt_inicio")
	public Date getPltr_dt_inicio() {
		return pltr_dt_inicio;
	}

	public void setPltr_dt_inicio(Date pltr_dt_inicio) {
		this.pltr_dt_inicio = pltr_dt_inicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pltr_dt_termino")
	public Date getPltr_dt_termino() {
		return pltr_dt_termino;
	}

	public void setPltr_dt_termino(Date pltr_dt_termino) {
		this.pltr_dt_termino = pltr_dt_termino;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "pltr_in_pagamento")
	public TipoPagamento getPltr_in_pagamento() {
		return pltr_in_pagamento;
	}

	public void setPltr_in_pagamento(TipoPagamento pltr_in_pagamento) {
		this.pltr_in_pagamento = pltr_in_pagamento;
	}

	@Column(name = "pltr_nr_totalparcelas")
	public Integer getPltr_nr_totalparcelas() {
		return pltr_nr_totalparcelas;
	}

	public void setPltr_nr_totalparcelas(Integer pltr_nr_totalparcelas) {
		this.pltr_nr_totalparcelas = pltr_nr_totalparcelas;
	}

	@Column(name = "pltr_vr_tratamento")
	public Double getPltr_vr_tratamento() {
		return pltr_vr_tratamento;
	}

	public void setPltr_vr_tratamento(Double pltr_vr_tratamento) {
		this.pltr_vr_tratamento = pltr_vr_tratamento;
	}

	@Column(name = "pltr_in_status")
	public String getPltr_in_status() {
		return pltr_in_status;
	}

	public void setPltr_in_status(String pltr_in_status) {
		this.pltr_in_status = pltr_in_status;
	}

	@Column(name = "pltr_tx_observacao")
	public String getPltr_tx_observacao() {
		return pltr_tx_observacao;
	}

	public void setPltr_tx_observacao(String pltr_tx_observacao) {
		this.pltr_tx_observacao = pltr_tx_observacao;
	}

	@ManyToOne
	@JoinColumn(name = "tapr_sq_id")
	public TabelaPreco getTabelaPreco() {
		return tabelaPreco;
	}

	public void setTabelaPreco(TabelaPreco tabelaPreco) {
		this.tabelaPreco = tabelaPreco;
	}
	
	@ManyToOne
	@JoinColumn(name = "depa_sq_id")
	public DentistaPaciente getDentistaPaciente() {
		return dentistaPaciente;
	}

	public void setDentistaPaciente(DentistaPaciente dentistaPaciente) {
		this.dentistaPaciente = dentistaPaciente;
	}
	
	
}
