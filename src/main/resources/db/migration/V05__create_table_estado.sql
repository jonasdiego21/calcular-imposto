CREATE TABLE estado (
  codigo bigint(20) NOT NULL PRIMARY KEY,
  nome varchar(255) DEFAULT NULL,
  sigla varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into estado (codigo, nome, sigla) values (1, 'Acre', 'AC');
insert into estado (codigo, nome, sigla) values (2, 'Alagoas', 'AL');
insert into estado (codigo, nome, sigla) values (3, 'Amapá', 'AP');
insert into estado (codigo, nome, sigla) values (4, 'Amazonas', 'AM');
insert into estado (codigo, nome, sigla) values (5, 'Bahia', 'BA');
insert into estado (codigo, nome, sigla) values (6, 'Ceará', 'CE');
insert into estado (codigo, nome, sigla) values (7, 'Distrito Federal', 'DF');
insert into estado (codigo, nome, sigla) values (8, 'Espírito Santo', 'ES');
insert into estado (codigo, nome, sigla) values (9, 'Goiás', 'GO');
insert into estado (codigo, nome, sigla) values (10, 'Maranhão', 'MA');
insert into estado (codigo, nome, sigla) values (11, 'Mato Grosso', 'MT');
insert into estado (codigo, nome, sigla) values (12, 'Mato Grosso do Sul',  'MS');
insert into estado (codigo, nome, sigla) values (13, 'Minas Gerais', 'MG');
insert into estado (codigo, nome, sigla) values (14, 'Pará', 'PA');
insert into estado (codigo, nome, sigla) values (15, 'Paraíba', 'PB');
insert into estado (codigo, nome, sigla) values (16, 'Paraná', 'PR');
insert into estado (codigo, nome, sigla) values (17, 'Pernambuco', 'PE');
insert into estado (codigo, nome, sigla) values (18, 'Piauí', 'PI');
insert into estado (codigo, nome, sigla) values (19, 'Rio de Janeiro', 'RJ');
insert into estado (codigo, nome, sigla) values (20, 'Rio Grande do Norte', 'RN');
insert into estado (codigo, nome, sigla) values (21, 'Rio Grande do Sul', 'RS');
insert into estado (codigo, nome, sigla) values (22, 'Rondônia', 'RO');
insert into estado (codigo, nome, sigla) values (23, 'Roraima', 'RR');
insert into estado (codigo, nome, sigla) values (24, 'Santa Catarina', 'SC');
insert into estado (codigo, nome, sigla) values (25, 'São Paulo', 'SP');
insert into estado (codigo, nome, sigla) values (26, 'Sergipe', 'SE');
insert into estado (codigo, nome, sigla) values (27, 'Tocantins', 'TO');