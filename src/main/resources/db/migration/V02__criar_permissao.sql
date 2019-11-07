CREATE TABLE IF NOT EXISTS permissao (
  perm_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  perm_ds_permissao			VARCHAR(150) NULL COMMENT 'Permissão'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Usuário');
INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Dente');
INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Procedimento');
INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Processos');
INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Dentista');
INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Clínica');
INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Tratamento');
INSERT INTO permissao (perm_ds_permissao) VALUES ('Cadastro de Responsável');