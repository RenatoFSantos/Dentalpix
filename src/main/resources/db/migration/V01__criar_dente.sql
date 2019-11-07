CREATE TABLE IF NOT EXISTS dente (
  dent_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  dent_cd_dente 			VARCHAR(5) NULL COMMENT 'Código do Dente',
  dent_nm_dente 			VARCHAR(50) NULL COMMENT 'Nome do dente',
  dent_in_tipo				VARCHAR(1) NULL COMMENT 'Tipo do dente',
  dent_tx_img				VARCHAR(100) NULL COMMENT 'Link da imagem'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dente (dent_cd_dente, dent_nm_dente, dent_in_tipo, dent_tx_img) VALUES ('10', 'Dente - 10', '1', '');
INSERT INTO dente (dent_cd_dente, dent_nm_dente, dent_in_tipo, dent_tx_img) VALUES ('20', 'Dente - 20', '2', '');
INSERT INTO dente (dent_cd_dente, dent_nm_dente, dent_in_tipo, dent_tx_img) VALUES ('30', 'Dente - 30', '3', '');
INSERT INTO dente (dent_cd_dente, dent_nm_dente, dent_in_tipo, dent_tx_img) VALUES ('40', 'Dente - 40', '4', '');
INSERT INTO dente (dent_cd_dente, dent_nm_dente, dent_in_tipo, dent_tx_img) VALUES ('50', 'Dente - 50', '5', '');
