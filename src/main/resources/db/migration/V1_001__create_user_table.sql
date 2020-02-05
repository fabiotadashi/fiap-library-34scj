CREATE TABLE TB_USER(
     id integer NOT NULL AUTO_INCREMENT,
     username varchar(100) NOT NULL,
     password varchar(100) NOT NULL,
     data_criacao timestamp DEFAULT NULL,
    data_atualizacao timestamp DEFAULT NULL,
  PRIMARY KEY (id),
                         PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
