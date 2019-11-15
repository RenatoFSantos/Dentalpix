CREATE TABLE IF NOT EXISTS dentista_paciente (
  depa_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  dett_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Dentista',
  paci_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Paciente',
  INDEX fk_DentistaPaciente_Dentista1_idx (dett_sq_id ASC),
  INDEX fk_DentistaPaciente_Paciente1_idx (paci_sq_id ASC),
  CONSTRAINT fk_DentistaPaciente_Dentista1
    FOREIGN KEY (dett_sq_id)
    REFERENCES dentista (dett_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_DentistaPaciente_Paciente1
    FOREIGN KEY (paci_sq_id)
    REFERENCES paciente (paci_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dentista_paciente (dett_sq_id, paci_sq_id) VALUES (1, 1);
INSERT INTO dentista_paciente (dett_sq_id, paci_sq_id) VALUES (1, 2);
INSERT INTO dentista_paciente (dett_sq_id, paci_sq_id) VALUES (1, 3);
INSERT INTO dentista_paciente (dett_sq_id, paci_sq_id) VALUES (2, 4);
INSERT INTO dentista_paciente (dett_sq_id, paci_sq_id) VALUES (2, 5);

