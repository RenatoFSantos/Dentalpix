CREATE TABLE IF NOT EXISTS clinica (
  clin_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  clin_nm_clinica 			VARCHAR(100) NOT NULL COMMENT 'Nome da clínica',
  clin_in_documento 		VARCHAR(1) NULL COMMENT 'F - CPF\nJ -  CNPJ',
  clin_cd_documento		 	VARCHAR(14) NULL COMMENT 'Número do documento informado',
  ende_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Endereço',
  clin_ds_celular 			VARCHAR(20) NULL COMMENT 'Celular',
  clin_ds_email 			VARCHAR(100) NULL COMMENT 'Email de contato',
  clin_in_ativo 			TINYINT(1) NOT NULL COMMENT 'Indicador se clínica está ativa: 0-True/1-False',
  INDEX fk_Clinica_Endereco1_idx (ende_sq_id ASC),
  CONSTRAINT fk_Clinica_Endereco1
    FOREIGN KEY (ende_sq_id)
    REFERENCES Dentech.Endereco (ende_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO clinica (clin_nm_clinica, clin_in_documento, clin_cd_documento, ende_sq_id, clin_ds_celular, clin_ds_email, clin_in_ativo)
VALUES ('Clinica Adriano Peixoto', 'F', '60168935600', 1, '(32) 9 9987-6587', 'adriano@clinica.com.br', 1);
INSERT INTO clinica (clin_nm_clinica, clin_in_documento, clin_cd_documento, ende_sq_id, clin_ds_celular, clin_ds_email, clin_in_ativo)
VALUES ('Clinica Vasconcelos', 'F', '25489562154', 2, '(32) 9 8787-6544', 'contato@clinica.com.br', 0);
INSERT INTO clinica (clin_nm_clinica, clin_in_documento, clin_cd_documento, ende_sq_id, clin_ds_celular, clin_ds_email, clin_in_ativo)
VALUES ('Clinica Adriana Pires', 'F', '82035621544', 3, '(32) 9 9954-8977', 'adriana@clinica.com.br', 0);
INSERT INTO clinica (clin_nm_clinica, clin_in_documento, clin_cd_documento, ende_sq_id, clin_ds_celular, clin_ds_email, clin_in_ativo)
VALUES ('Clinica Lara Rezende', 'J', '28039364000102', 4, '(11) 9 8895-6985', 'lara@clinica.com.br', 0);
INSERT INTO clinica (clin_nm_clinica, clin_in_documento, clin_cd_documento, ende_sq_id, clin_ds_celular, clin_ds_email, clin_in_ativo)
VALUES ('Clinica Dental', 'J', '43056364260102', 5, '(11) 9 9922-1185', 'dental@clinica.com.br', 0);