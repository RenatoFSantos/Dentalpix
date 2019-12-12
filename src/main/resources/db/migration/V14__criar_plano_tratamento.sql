CREATE TABLE IF NOT EXISTS plano_tratamento (
  pltr_sq_id 			BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  pltr_dt_plano 		DATETIME NULL COMMENT 'Data de registro do Plano de Tratamento',
  pltr_dt_inicio 		DATETIME NULL COMMENT 'Data de início do tratamento',
  pltr_dt_termino 		DATETIME NULL COMMENT 'Data de término de tratamento',
  pltr_in_pagamento 	VARCHAR(1) NOT NULL COMMENT 'Indicador de Plano de Pagamento\nV - Vista\nP - Prazo',
  pltr_nr_totalparcelas BIGINT(20) NULL COMMENT 'Número total de parcelas para pagamento',
  pltr_vl_tratamento 	DECIMAL(10,2) NULL COMMENT 'Valor Total do Tratamento',
  pltr_in_status 		VARCHAR(1) NOT NULL COMMENT 'Status do Tratamento:\nO - Orçamento\nA - Andamento\nS - Suspenso\nC - Concluído\nP - Pendente',
  pltr_tx_observacao 	VARCHAR(250) NULL COMMENT 'Observação',
  tapr_sq_id 			BIGINT(20) NOT NULL COMMENT 'ID - Tabela de Preço',
  depa_sq_id 			BIGINT(20) NOT NULL COMMENT 'ID - Dentista Paciente',
  INDEX fk_PlanoTratamento_TabelaPreco1_id (tapr_sq_id ASC),
  INDEX fk_PlanoTratamento_Dentista_Paciente1_idx (depa_sq_id ASC),
  CONSTRAINT fk_PlanoTratamento_TabelaPreco1
    FOREIGN KEY (tapr_sq_id)
    REFERENCES tabela_preco (tapr_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_PlanoTratamento_Dentista_Paciente1
    FOREIGN KEY (depa_sq_id)
    REFERENCES dentista_paciente (depa_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO plano_tratamento (pltr_dt_plano, pltr_dt_inicio, pltr_dt_termino, pltr_in_pagamento, pltr_nr_totalparcelas, pltr_vl_tratamento, pltr_in_status, pltr_tx_observacao, 
tapr_sq_id, depa_sq_id) VALUES ('2019-05-08', '2019-07-12', '2019-10-14', 'P', 5, 1500.00, 'O', '', 1, 1);
INSERT INTO plano_tratamento (pltr_dt_plano, pltr_dt_inicio, pltr_dt_termino, pltr_in_pagamento, pltr_nr_totalparcelas, pltr_vl_tratamento, pltr_in_status, pltr_tx_observacao, 
tapr_sq_id, depa_sq_id) VALUES ('2019-06-28', '2019-07-24', null, 'P', 4, 850.25, 'O', '', 1, 2);
INSERT INTO plano_tratamento (pltr_dt_plano, pltr_dt_inicio, pltr_dt_termino, pltr_in_pagamento, pltr_nr_totalparcelas, pltr_vl_tratamento, pltr_in_status, pltr_tx_observacao, 
tapr_sq_id, depa_sq_id) VALUES ('2019-07-14', '2019-09-04', null, 'P', 6, 2000.50, 'O', '', 1, 1);
INSERT INTO plano_tratamento (pltr_dt_plano, pltr_dt_inicio, pltr_dt_termino, pltr_in_pagamento, pltr_nr_totalparcelas, pltr_vl_tratamento, pltr_in_status, pltr_tx_observacao, 
tapr_sq_id, depa_sq_id) VALUES ('2019-08-03', '2019-10-11', null, 'P', 2, 1854.50, 'O', '', 1, 2);
INSERT INTO plano_tratamento (pltr_dt_plano, pltr_dt_inicio, pltr_dt_termino, pltr_in_pagamento, pltr_nr_totalparcelas, pltr_vl_tratamento, pltr_in_status, pltr_tx_observacao, 
tapr_sq_id, depa_sq_id) VALUES ('2019-09-05', '2019-12-10', null, 'V', 1, 2400.50, 'O', '', 1, 1);