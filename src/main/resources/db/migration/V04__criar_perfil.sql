CREATE TABLE IF NOT EXISTS perfil (
  perf_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  perf_nm_perfil			VARCHAR(20) NULL COMMENT 'Nome do Perfil',
  perf_sg_perfil			VARCHAR(3) NULL COMMENT 'Sigla do Perfil'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('Administrador', 'ADM');
INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('Gerente', 'GER');
INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('Auditor', 'AUD');
INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('Consultor', 'CON');
INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('Visitante', 'VIS');
