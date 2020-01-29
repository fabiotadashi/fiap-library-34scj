CREATE TABLE TB_AUTHOR(
     id integer NOT NULL AUTO_INCREMENT,
     name varchar(100) NOT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_BOOK (
  id integer NOT NULL AUTO_INCREMENT,
  title varchar(500) NOT NULL,
  page_number integer DEFAULT NULL,
  isbn varchar(50) DEFAULT NULL,
  release_date timestamp DEFAULT NULL,
  author_id integer DEFAULT NULL,
  created_date timestamp DEFAULT NULL,
  modified_date timestamp DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (author_id) REFERENCES TB_AUTHOR (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;