CREATE TABLE imovel (
  codigo bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  alicota decimal(12,2) NOT NULL,
  area_construida decimal(12,2) NOT NULL,
  area_terreno decimal(12,2) NOT NULL,
  data_hora_cadastro datetime DEFAULT NULL,
  bairro varchar(255) DEFAULT NULL,
  logradouro varchar(255) DEFAULT NULL,
  numero varchar(255) DEFAULT NULL,
  valor_venal_construcao decimal(12,2) NOT NULL,
  valor_venal_terreno decimal(12,2) NOT NULL,
  codigo_cidade bigint(20) DEFAULT NULL,
  codigo_estado bigint(20) DEFAULT NULL,
  codigo_proprietario bigint(20) NOT NULL,
  FOREIGN KEY (codigo_estado) REFERENCES estado (codigo),
  FOREIGN KEY (codigo_proprietario) REFERENCES proprietario (codigo),
  FOREIGN KEY (codigo_cidade) REFERENCES cidade (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;