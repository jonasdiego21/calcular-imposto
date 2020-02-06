CREATE TABLE proprietario (
  codigo bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data_hora_cadastro datetime DEFAULT NULL,
  bairro varchar(255) DEFAULT NULL,
  logradouro varchar(255) DEFAULT NULL,
  numero varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  codigo_cidade bigint(20) DEFAULT NULL,
  codigo_estado bigint(20) DEFAULT NULL,
  FOREIGN KEY (codigo_cidade) REFERENCES cidade (codigo),
  FOREIGN KEY (codigo_estado) REFERENCES estado (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;