CREATE TABLE IF NOT EXISTS perfil (
  perf_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  perf_nm_perfil 			VARCHAR(20) NULL COMMENT 'Nome',
  perf_sg_perfil 			VARCHAR(3) NULL COMMENT 'Sigla'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('ADMINISTRADOR', 'ADM');
INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('VISITANTE', 'VST');
INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('GERENTE', 'GER');
INSERT INTO perfil (perf_nm_perfil, perf_sg_perfil) VALUES ('EDITOR', 'EDT');