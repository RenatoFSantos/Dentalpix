CREATE TABLE IF NOT EXISTS tabela_preco (
  tapr_sq_id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID - Tabela de Preço',
  tapr_nm_tabela  		VARCHAR(50) DEFAULT NULL COMMENT 'Nome da tabela de preço',
  tapr_ds_tabela  		VARCHAR(100) DEFAULT NULL COMMENT 'Descrição da tabela de preço',
  tapr_pr_reajuste		DECIMAL(5,2) DEFAULT NULL COMMENT 'Percentual de reajuste da tabela sobre o valor de referência do procedimento'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tabela_preco (tapr_nm_tabela, tapr_ds_tabela, tapr_pr_reajuste) VALUES ('Tabela Preço 1', 'Tabela reajuste 0', '0.00');
INSERT INTO tabela_preco (tapr_nm_tabela, tapr_ds_tabela, tapr_pr_reajuste) VALUES ('Tabela Preço 2', 'Tabela reajuste 10%', '10.00');
INSERT INTO tabela_preco (tapr_nm_tabela, tapr_ds_tabela, tapr_pr_reajuste) VALUES ('Tabela Preço 3', 'Tabela reajuste 20%', '20.00');
INSERT INTO tabela_preco (tapr_nm_tabela, tapr_ds_tabela, tapr_pr_reajuste) VALUES ('Tabela Preço 4', 'Tabela reajuste 25%', '25.00');
INSERT INTO tabela_preco (tapr_nm_tabela, tapr_ds_tabela, tapr_pr_reajuste) VALUES ('Tabela Preço 5', 'Tabela reajuste 50%', '50.00');
