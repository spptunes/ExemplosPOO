create schema Agenda;
use Agenda;

DROP TABLE IF EXISTS contatos;
drop table if exists Compromissos;

CREATE TABLE contatos (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `APELIDO` varchar(15) NOT NULL,
  `DATA_NASCIMENTO` date NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NOME` (`NOME`)
);

LOCK TABLES contatos WRITE;

INSERT INTO contatos VALUES (1,'emmerson','emmsr','1972-12-07'),(2,'andre','dede5','2005-06-26');
UNLOCK TABLES;

create table Compromissos (
	id bigint primary key auto_increment,
    datCompromisso date not null,
    observ VARCHAR(100),
    horaCompromisso time not null,
    contato VARCHAR(100),
    foreign key(contato) references contatos(nome)
);

SELECT * FROM contatos;