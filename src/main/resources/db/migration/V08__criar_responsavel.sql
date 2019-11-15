CREATE TABLE IF NOT EXISTS responsavel (
  resp_sq_id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID - Responsavel',
  resp_nm_responsavel   VARCHAR(100) DEFAULT NULL COMMENT 'Nome do responsavel',
  ende_sq_id            BIGINT(20) NOT NULL COMMENT 'ID - Endereço',
  resp_ds_celular       VARCHAR(20) DEFAULT NULL COMMENT 'Celular',
  resp_ds_email         VARCHAR(100) DEFAULT NULL COMMENT 'Email',
  INDEX fk_Responsavel_Endereco1_idx (ende_sq_id ASC),
  CONSTRAINT fk_Responsavel_Endereco1
    FOREIGN KEY (ende_sq_id)
    REFERENCES Dentalpix.Endereco (ende_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO responsavel (resp_nm_responsavel, ende_sq_id, resp_ds_celular, resp_ds_email)
VALUES ('Pai Adriano Peixoto', 1, '(32) 9 9987-6587', 'adriano@gmail.com');
INSERT INTO responsavel (resp_nm_responsavel, ende_sq_id, resp_ds_celular, resp_ds_email)
VALUES ('Pai Moacyr de Souza', 1, '(32) 9 8857-5486', 'moacyr@gmail.com');
INSERT INTO responsavel (resp_nm_responsavel, ende_sq_id, resp_ds_celular, resp_ds_email)
VALUES ('Mãe Joice Amorim da Silva', 1, '(32) 9 9898-5655', 'joice@gmail.com');
INSERT INTO responsavel (resp_nm_responsavel, ende_sq_id, resp_ds_celular, resp_ds_email)
VALUES ('Pai Evandro de Souza Castro', 1, '(21) 9 9965-4455', 'evandro@gmail.com');
INSERT INTO responsavel (resp_nm_responsavel, ende_sq_id, resp_ds_celular, resp_ds_email)
VALUES ('Mãe Amanda Anunes Mitra', 1, '(21) 9 9965-3332', 'amanda@gmail.com');
