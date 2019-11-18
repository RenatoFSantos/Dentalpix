CREATE TABLE IF NOT EXISTS procedimento (
  proc_sq_id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID - Procedimento',
  proc_cd_procedimento  VARCHAR(100) DEFAULT NULL COMMENT 'Código do procedimento',
  proc_ds_procedimento  VARCHAR(100) DEFAULT NULL COMMENT 'Descrição do procedimento',
  proc_vl_referencia	DECIMAL(10,2) DEFAULT NULL COMMENT 'Valor em R$ de referência do serviço'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO procedimento (proc_cd_procedimento, proc_ds_procedimento, proc_vl_referencia) VALUES ('81000014', 'Condicionamento em Odontologia', '100.00');
INSERT INTO procedimento (proc_cd_procedimento, proc_ds_procedimento, proc_vl_referencia) VALUES ('81000030', 'Consulta odontológica', '100.00');
INSERT INTO procedimento (proc_cd_procedimento, proc_ds_procedimento, proc_vl_referencia) VALUES ('81000049', 'Consulta odontológica de Urgência', '200.00');
INSERT INTO procedimento (proc_cd_procedimento, proc_ds_procedimento, proc_vl_referencia) VALUES ('81000057', 'Consulta odontológica de Urgência 24 hs', '300.00');
INSERT INTO procedimento (proc_cd_procedimento, proc_ds_procedimento, proc_vl_referencia) VALUES ('81000065', 'Consulta odontológica inicial', '150.00');

