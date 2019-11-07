CREATE TABLE IF NOT EXISTS perfil_permissao (
  pepe_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  perf_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Perfil',
  perm_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Permissao',
  INDEX fk_PerfilPermissao_Perfil1_idx (perf_sq_id ASC),
  INDEX fk_PerfilPermissao_Permissao1_idx (perm_sq_id ASC),
  CONSTRAINT fk_PerfilPermissao_Perfil1
    FOREIGN KEY (perf_sq_id)
    REFERENCES perfil (perf_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_PerfilPermissao_Permissao1
    FOREIGN KEY (perm_sq_id)
    REFERENCES permissao (perm_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (1, 1);
INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (1, 2);
INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (1, 3);
INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (1, 4);
INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (1, 5);
INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (2, 2);
INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (2, 3);
INSERT INTO perfil_permissao (perf_sq_id, perm_sq_id) VALUES (2, 4);
