CREATE TABLE IF NOT EXISTS usuario (
  usua_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  usua_nm_usuario 			VARCHAR(50) NULL COMMENT 'Nome',
  usua_ds_email 			VARCHAR(100) NULL COMMENT 'email',
  usua_ds_senha 			VARCHAR(150) NULL COMMENT 'Senha',
  perf_sq_id				BIGINT(20) NOT NULL COMMENT 'ID - Perfil',
  INDEX fk_Usuario_Perfil1_idx (perf_sq_id ASC),
  CONSTRAINT fk_Usuario_Perfil1
    FOREIGN KEY (perf_sq_id)
    REFERENCES perfil (perf_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id) VALUES ('Administrador', 'admin@email.com', '$2a$10$pNKRUNcDgJ02/q5CKZH1Yet.Q/dQHHc7SunoGoN.6osBrM3zpoaGO', 1);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id) VALUES ('Usuario-2', 'usuario02@email.com', '$2a$10$pNKRUNcDgJ02/q5CKZH1Yet.Q/dQHHc7SunoGoN.6osBrM3zpoaGO', 1);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id) VALUES ('Usuario-3', 'usuario03@email.com', '$2a$10$pNKRUNcDgJ02/q5CKZH1Yet.Q/dQHHc7SunoGoN.6osBrM3zpoaGO', 1);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id) VALUES ('Usuario-4', 'usuario04@email.com', '$2a$10$pNKRUNcDgJ02/q5CKZH1Yet.Q/dQHHc7SunoGoN.6osBrM3zpoaGO', 1);
INSERT INTO usuario (usua_nm_usuario, usua_ds_email, usua_ds_senha, perf_sq_id) VALUES ('Usuario-5', 'usuario05@email.com', '$2a$10$pNKRUNcDgJ02/q5CKZH1Yet.Q/dQHHc7SunoGoN.6osBrM3zpoaGO', 1);