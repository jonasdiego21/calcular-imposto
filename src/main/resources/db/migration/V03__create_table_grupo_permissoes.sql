CREATE TABLE grupo_permissoes (
  codigo_grupo bigint(20) NOT NULL,
  codigo_permissao bigint(20) NOT NULL,
  FOREIGN KEY (codigo_grupo) REFERENCES grupo (codigo),
  FOREIGN KEY (codigo_permissao) REFERENCES permissao (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 1);
INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 2);
INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 3);
INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 4);
INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 5);
INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 6);
INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 7);
INSERT INTO grupo_permissoes (codigo_grupo, codigo_permissao) VALUES (1, 8);