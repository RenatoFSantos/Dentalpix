CREATE TABLE IF NOT EXISTS permissao (
  perm_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  perf_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Perfil',
  proc_sq_id 				BIGINT(20) NOT NULL COMMENT 'ID - Processo',
  perm_ds_permissao			VARCHAR(5) NOT NULL COMMENT 'Permissão: pode ter mais de uma opção, sendo VEDI = T\nV - Visualização\n E - Edição\nD - Deleção\nI - Inserção\nT - Total',
  INDEX fk_Permissao_Perfil1_idx (perf_sq_id ASC),
  INDEX fk_Permissao_Processo1_idx (proc_sq_id ASC),
  CONSTRAINT fk_Permissao_Perfil1
    FOREIGN KEY (perf_sq_id)
    REFERENCES perfil (perf_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Permissao_Processo1
    FOREIGN KEY (proc_sq_id)
    REFERENCES processo (proc_sq_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO permissao (perf_sq_id, proc_sq_id, perm_ds_permissao) VALUES (1, 1, 'T');
INSERT INTO permissao (perf_sq_id, proc_sq_id, perm_ds_permissao) VALUES (1, 2, 'T');
INSERT INTO permissao (perf_sq_id, proc_sq_id, perm_ds_permissao) VALUES (1, 3, 'T');
INSERT INTO permissao (perf_sq_id, proc_sq_id, perm_ds_permissao) VALUES (1, 4, 'T');
INSERT INTO permissao (perf_sq_id, proc_sq_id, perm_ds_permissao) VALUES (1, 5, 'T');
