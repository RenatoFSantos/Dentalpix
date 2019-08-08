CREATE TABLE IF NOT EXISTS processo (
  proc_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  proc_nm_processo 			VARCHAR(100) NULL COMMENT 'Nome'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Usuário');
INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Dente');
INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Procedimento');
INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Processos');
INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Dentista');
INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Clínica');
INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Tratamento');
INSERT INTO processo (proc_nm_processo) VALUES ('Cadastro de Responsável');