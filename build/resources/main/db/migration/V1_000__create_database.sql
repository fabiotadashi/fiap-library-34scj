CREATE TABLE TB_AUTHOR(
     id integer NOT NULL AUTO_INCREMENT,
     name varchar(100) NOT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_BOOK (
  id integer NOT NULL AUTO_INCREMENT,
  titulo varchar(500) NOT NULL,
  quantidade_de_paginas integer DEFAULT NULL,
  isbn varchar(50) DEFAULT NULL,
  data_lancamento timestamp DEFAULT NULL,
  autor_id integer DEFAULT NULL,
  data_criacao timestamp DEFAULT NULL,
  data_atualizacao timestamp DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (autor_id) REFERENCES TB_AUTHOR (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;