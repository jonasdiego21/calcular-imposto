CREATE TABLE grupo (
  codigo bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO grupo (codigo, nome) VALUES (1, 'ADMINISTRADOR');