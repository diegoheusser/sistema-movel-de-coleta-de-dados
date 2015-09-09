CREATE DATABASE custodevida;

USE custodevida;

CREATE TABLE `grupo` (
  `grupoid` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `identificador` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`grupoid`)
);

CREATE TABLE `subgrupo` (
  `subgrupoid` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `identificador` varchar(255) DEFAULT NULL,
  `grupoid` int(11) NOT NULL,
  PRIMARY KEY (`subgrupoid`),
  KEY `FK_subgrupo_grupoid` (`grupoid`),
  CONSTRAINT `FK_subgrupo_grupoid` FOREIGN KEY (`grupoid`) REFERENCES `grupo` (`grupoid`)
);

CREATE TABLE `classe` (
  `classeid` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `identificador` varchar(255) DEFAULT NULL,
  `subgrupoid` int(11) NOT NULL,
  PRIMARY KEY (`classeid`),
  KEY `FK_classe_subgrupoid` (`subgrupoid`),
  CONSTRAINT `FK_classe_subgrupoid` FOREIGN KEY (`subgrupoid`) REFERENCES `subgrupo` (`subgrupoid`)
);

CREATE TABLE `produto` (
  `produtoid` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `identificador` varchar(255) DEFAULT NULL,
  `classeid` int(11) NOT NULL,
  PRIMARY KEY (`produtoid`),
  KEY `FK_produto_classeid` (`classeid`),
  CONSTRAINT `FK_produto_classeid` FOREIGN KEY (`classeid`) REFERENCES `classe` (`classeid`)
);

CREATE TABLE fonte (
	fonteid int(11) NOT NULL AUTO_INCREMENT,
	descricao varchar(255) DEFAULT NULL,
	localizacao varchar(255) DEFAULT NULL,
	PRIMARY KEY (fonteid)
);

CREATE TABLE item (
	itemid int(11) NOT NULL AUTO_INCREMENT,
	descricao varchar(255) DEFAULT NULL,
	identificador varchar(255) DEFAULT NULL,
	semanal tinyint(1) DEFAULT 0,
	produtoid int(11) NOT NULL,
	PRIMARY KEY (itemid),
	CONSTRAINT `FK_item_produtoid` FOREIGN KEY (`produtoid`) REFERENCES `produto` (`produtoid`)
);

CREATE TABLE tipousuario (
	tipoUsuarioid int(11) NOT NULL AUTO_INCREMENT,
	descricao varchar(255) DEFAULT NULL,
	PRIMARY KEY (tipoUsuarioid)
);

CREATE TABLE usuario (
	usuarioid int(11) NOT NULL AUTO_INCREMENT,
	ativo tinyint(1) NOT NULL DEFAULT 0,
	nick varchar(30) NOT NULL,
	nomecompleto varchar(50) NOT NULL,
	senha varchar(32) NOT NULL,
	tipoUsuarioid int(11) NOT NULL,
	PRIMARY KEY (usuarioid),
	CONSTRAINT UQ_usuario_nick UNIQUE (nick),
	CONSTRAINT FK_usuario_tipoUsuarioId FOREIGN KEY (tipoUsuarioid) REFERENCES tipousuario(tipoUsuarioid)	
);

CREATE TABLE fonteusuario (
	usuarioid int(11) NOT NULL,
	fonteid int(11) NOT NULL,
	PRIMARY KEY PK_fonteusuario (usuarioid,fonteid),
	CONSTRAINT FK_fonteusuario_usuarioid FOREIGN KEY (usuarioid) REFERENCES usuario(usuarioid),
	CONSTRAINT FK_fonteusuario_fonteid FOREIGN KEY (fonteid) REFERENCES fonte(fonteid)
);

CREATE TABLE pesquisa (
	pesquisaid int(11) NOT NULL AUTO_INCREMENT,
	ano int(11) DEFAULT NULL,
	data date DEFAULT NULL,
	especificacao varchar(255) DEFAULT NULL,
	marca varchar(255) DEFAULT NULL,
	mes int(11) DEFAULT NULL,
	mudoumarca varchar(255) DEFAULT NULL,
	semana int(11) DEFAULT NULL,
	valorlido double DEFAULT NULL,
	fonteid int(11) NOT NULL,
	itemid int(11) NOT NULL,
	usuarioid int(11) NOT NULL,
	PRIMARY KEY (pesquisaid),
	CONSTRAINT FK_pesquisa_fonteid FOREIGN KEY (fonteid) REFERENCES fonte(fonteid),
	CONSTRAINT FK_pesquisa_itemid FOREIGN KEY (itemid) REFERENCES item(itemid),
	CONSTRAINT FK_pesquisa_usuarioid FOREIGN KEY (usuarioid) REFERENCES usuario(usuarioid)
);

CREATE TABLE pesquisacontrole (
	pesquisacontroleid int(11) NOT NULL AUTO_INCREMENT,
	aberto tinyint(1) DEFAULT NULL,
	ano int(11) DEFAULT NULL,
	dataemissao date DEFAULT NULL,
	dataentrega date DEFAULT NULL,
	mes int(11) DEFAULT NULL,
	semana int(11) DEFAULT NULL,
	semanal tinyint(1) DEFAULT 0,
	fonteid int(11) NOT NULL,
	usuarioid int(11) NOT NULL,
	PRIMARY KEY (pesquisacontroleid),
	CONSTRAINT FK_pesquisacontrole_fonteid FOREIGN KEY (fonteid) REFERENCES fonte(fonteid),
	CONSTRAINT FK_pesquisacontrole_usuarioid FOREIGN KEY (usuarioid) REFERENCES usuario(usuarioid)
);