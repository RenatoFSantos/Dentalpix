CREATE TABLE IF NOT EXISTS endereco (
  ende_sq_id 				BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID',
  ende_ds_logradouro 		VARCHAR(100) NULL COMMENT 'Logradouro',
  ende_ds_complemento 		VARCHAR(50) NULL COMMENT 'Complemento Logradouro',
  ende_ds_numero 			VARCHAR(10) NULL COMMENT 'Número',
  ende_nm_bairro 			VARCHAR(20) NULL COMMENT 'Bairro',
  ende_nm_cidade 			VARCHAR(20) NULL COMMENT 'Cidade',
  ende_sg_uf 				VARCHAR(2) NULL COMMENT 'UF',
  ende_cd_cep 				VARCHAR(8) NULL COMMENT 'CEP',
  ende_ds_telefone 			VARCHAR(15) NULL COMMENT 'Telefone Fixo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO endereco (ende_ds_logradouro, ende_ds_complemento, ende_ds_numero, ende_nm_bairro, ende_nm_cidade, ende_sg_uf, ende_cd_cep, ende_ds_telefone) 
VALUES ('Rua Espírito Santo', 'Fundos', '1032', 'Centro', 'Juiz de Fora', 'MG', '36600100', '(32) 2543-3421');
INSERT INTO endereco (ende_ds_logradouro, ende_ds_complemento, ende_ds_numero, ende_nm_bairro, ende_nm_cidade, ende_sg_uf, ende_cd_cep, ende_ds_telefone) 
VALUES ('Rua Raimundo Sodré', 'Casa', '111', 'Centro', 'Maringá', 'PR', '25468921', '(24) 3245-5685');
INSERT INTO endereco (ende_ds_logradouro, ende_ds_complemento, ende_ds_numero, ende_nm_bairro, ende_nm_cidade, ende_sg_uf, ende_cd_cep, ende_ds_telefone) 
VALUES ('Rua Castro Alves', '', '12', 'Castro Alves', 'Salvador', 'BA', '24466200', '(33) 5486-6589');
INSERT INTO endereco (ende_ds_logradouro, ende_ds_complemento, ende_ds_numero, ende_nm_bairro, ende_nm_cidade, ende_sg_uf, ende_cd_cep, ende_ds_telefone) 
VALUES ('Rua José Simão', '', '343', 'Vilarejo', 'Rio de Janeiro', 'RJ', '22250080', '(21) 2548-6597');
INSERT INTO endereco (ende_ds_logradouro, ende_ds_complemento, ende_ds_numero, ende_nm_bairro, ende_nm_cidade, ende_sg_uf, ende_cd_cep, ende_ds_telefone) 
VALUES ('Av. Faria Lima', 'Perto da banca', '5563', 'Centro', 'São Paulo', 'SP', '25468080', '(11) 3548-5263');
