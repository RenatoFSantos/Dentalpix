CREATE TABLE IF NOT EXISTS paciente (
  paci_sq_id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID - Paciente',
  paci_nm_paciente	    VARCHAR(100) DEFAULT NULL COMMENT 'Nome do paciente',
  paci_ds_celular       VARCHAR(20) DEFAULT NULL COMMENT 'Celular',
  paci_ds_email         VARCHAR(100) DEFAULT NULL COMMENT 'Email',
  ende_sq_id            BIGINT(20) NOT NULL COMMENT 'ID - Endereço',
  resp_sq_id			BIGINT(20) COMMENT 'ID - Responsavel',
  INDEX fk_Paciente_Endereco1_idx (ende_sq_id ASC),
  INDEX fk_Paciente_Responsavel1_idx (resp_sq_id ASC),
  CONSTRAINT fk_Paciente_Endereco1
    FOREIGN KEY (ende_sq_id)
    REFERENCES Dentalpix.Endereco (ende_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Paciente_Responsavel1
    FOREIGN KEY (resp_sq_id)
    REFERENCES Dentalpix.Responsavel (resp_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO paciente (paci_nm_paciente, paci_ds_celular, paci_ds_email, ende_sq_id, resp_sq_id)
VALUES ('Maura da Silva', '(32) 9 9987-1127', 'maura@gmail.com', 1, 1);
INSERT INTO paciente (paci_nm_paciente, paci_ds_celular, paci_ds_email, ende_sq_id, resp_sq_id)
VALUES ('Ana Paula Peixoto', '(32) 9 9934-2311', 'app@gmail.com', 1, 1);
INSERT INTO paciente (paci_nm_paciente, paci_ds_celular, paci_ds_email, ende_sq_id, resp_sq_id)
VALUES ('Ricardo Alvarenga', '(32) 9 9911-6534', 'ricalvarenga@gmail.com', 1, 1);
INSERT INTO paciente (paci_nm_paciente, paci_ds_celular, paci_ds_email, ende_sq_id)
VALUES ('Maria Dulce da Costa', '(32) 9 9932-2365', 'mariadulce@gmail.com', 1);
INSERT INTO paciente (paci_nm_paciente, paci_ds_celular, paci_ds_email, ende_sq_id)
VALUES ('Venice de Souza Alencar', '(32) 9 9956-6327', 'venice77@gmail.com', 1);
