CREATE TABLE IF NOT EXISTS usuario (
  usua_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  usua_nm_usuario 			VARCHAR(50) NULL COMMENT 'Nome',
  usua_ds_email 			VARCHAR(100) NULL COMMENT 'email',
  usua_ds_senha 			VARCHAR(150) NULL COMMENT 'Senha',
  perf_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Perfil',
  clin_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Clínica',
  INDEX fk_Usuario_Perfil1_idx (perf_sq_id ASC),
  INDEX fk_Usuario_Clinica1_idx (clin_sq_id ASC),
  CONSTRAINT fk_Usuario_Perfil1
    FOREIGN KEY (perf_sq_id)
    REFERENCES perfil (perf_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Usuario_Clinica1
    FOREIGN KEY (clin_sq_id)
    REFERENCES clinica (clin_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id, clin_sq_id) VALUES ('Administrador', 'admin@email.com', '$2a$10$7X2bU..t8H66caweSa/PK.aivRsSubtQkWFtZf72qiUCLnlviC0gq', 1, 1);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id, clin_sq_id) VALUES ('Usuario-2', 'usuario02@email.com', '$2a$10$7X2bU..t8H66caweSa/PK.aivRsSubtQkWFtZf72qiUCLnlviC0gq', 3, 2);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id, clin_sq_id) VALUES ('Usuario-3', 'usuario03@email.com', '$2a$10$7X2bU..t8H66caweSa/PK.aivRsSubtQkWFtZf72qiUCLnlviC0gq', 1, 3);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id, clin_sq_id) VALUES ('Usuario-4', 'usuario04@email.com', '$2a$10$7X2bU..t8H66caweSa/PK.aivRsSubtQkWFtZf72qiUCLnlviC0gq', 3, 1);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id, clin_sq_id) VALUES ('Usuario-5', 'usuario05@email.com', '$2a$10$7X2bU..t8H66caweSa/PK.aivRsSubtQkWFtZf72qiUCLnlviC0gq', 1, 2);