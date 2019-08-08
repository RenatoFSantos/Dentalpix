CREATE TABLE IF NOT EXISTS dentista (
  dett_sq_id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID - Dentista',
  dett_nm_dentista      VARCHAR(100) DEFAULT NULL COMMENT 'Nome do dentista',
  dett_cd_cro           VARCHAR(14) DEFAULT NULL COMMENT 'Código do CRO',
  ende_sq_id            BIGINT(20) NOT NULL COMMENT 'ID - Endereço',
  dett_ds_celular       VARCHAR(20) DEFAULT NULL COMMENT 'Celular',
  dett_ds_email         VARCHAR(100) DEFAULT NULL COMMENT 'Email',
  INDEX fk_Dentista_Endereco1_idx (ende_sq_id ASC),
  CONSTRAINT fk_Dentista_Endereco1
    FOREIGN KEY (ende_sq_id)
    REFERENCES Dentech.Endereco (ende_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dentista (dett_nm_dentista, dett_cd_cro, ende_sq_id, dett_ds_celular, dett_ds_email)
VALUES ('Adriano Peixoto', '12526', 1, '(32) 9 9987-6587', 'adriano.dentista@clinica.com.br');
INSERT INTO dentista (dett_nm_dentista, dett_cd_cro, ende_sq_id, dett_ds_celular, dett_ds_email)
VALUES ('Moacyr de Souza', '14356', 1, '(32) 9 8857-5486', 'moacyr.dentista@clinica.com.br');
INSERT INTO dentista (dett_nm_dentista, dett_cd_cro, ende_sq_id, dett_ds_celular, dett_ds_email)
VALUES ('Joice Amorim da Silva', '55487', 1, '(32) 9 9898-5655', 'joice.dentista@clinica.com.br');
INSERT INTO dentista (dett_nm_dentista, dett_cd_cro, ende_sq_id, dett_ds_celular, dett_ds_email)
VALUES ('Evandro de Souza Castro', '58777', 1, '(21) 9 9965-4455', 'evandro.dentista@clinica.com.br');
INSERT INTO dentista (dett_nm_dentista, dett_cd_cro, ende_sq_id, dett_ds_celular, dett_ds_email)
VALUES ('Amanda Anunes Mitra', '55471', 1, '(21) 9 9965-3332', 'amanda.dentista@clinica.com.br');
