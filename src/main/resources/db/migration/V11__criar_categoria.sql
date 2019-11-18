CREATE TABLE IF NOT EXISTS categoria (
  cate_sq_id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'ID - Categoria',
  cate_nm_categoria	    VARCHAR(50) DEFAULT NULL COMMENT 'Nome da categoria',
  cate_in_tipo			VARCHAR(1) DEFAULT NULL COMMENT 'R-Receita/D-Despesa'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (cate_nm_categoria, cate_in_tipo) VALUES ('Orçamento', 'R');
INSERT INTO categoria (cate_nm_categoria, cate_in_tipo) VALUES ('Limpeza', 'R');
INSERT INTO categoria (cate_nm_categoria, cate_in_tipo) VALUES ('Parcela tratamento', 'R');
INSERT INTO categoria (cate_nm_categoria, cate_in_tipo) VALUES ('Luz', 'D');
INSERT INTO categoria (cate_nm_categoria, cate_in_tipo) VALUES ('Aluguel', 'D');
INSERT INTO categoria (cate_nm_categoria, cate_in_tipo) VALUES ('Condomínio', 'D');
