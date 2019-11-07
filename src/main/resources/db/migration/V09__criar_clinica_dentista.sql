CREATE TABLE IF NOT EXISTS clinica_dentista (
  clde_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  clin_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Clínica',
  dett_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Dentista',
  INDEX fk_ClinicaDentista_Clinica1_idx (clin_sq_id ASC),
  INDEX fk_ClinicaDentista_Dentista1_idx (dett_sq_id ASC),
  CONSTRAINT fk_ClinicaDentista_Clinica1
    FOREIGN KEY (clin_sq_id)
    REFERENCES clinica (clin_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ClinicaDentista_Dentista1
    FOREIGN KEY (dett_sq_id)
    REFERENCES dentista (dett_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO clinica_dentista (clin_sq_id, dett_sq_id) VALUES (1, 1);
INSERT INTO clinica_dentista (clin_sq_id, dett_sq_id) VALUES (1, 2);
INSERT INTO clinica_dentista (clin_sq_id, dett_sq_id) VALUES (1, 3);
INSERT INTO clinica_dentista (clin_sq_id, dett_sq_id) VALUES (1, 4);
INSERT INTO clinica_dentista (clin_sq_id, dett_sq_id) VALUES (1, 5);