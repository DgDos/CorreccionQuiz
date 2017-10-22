
CREATE DATABASE IF NOT EXISTS `esquemadb` 




CREATE TABLE IF NOT EXISTS `esquema` (
  `id_esquema` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_esquema` varchar(30) NOT NULL,
  PRIMARY KEY (`id_esquema`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `tabla` (
  `id_tabla` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tabla` varchar(30) NOT NULL,
  `id_esquema` int(3) NOT NULL,
  PRIMARY KEY (`id_tabla`),
  KEY `id_esquema` (`id_esquema`),
  CONSTRAINT `tabla_ibfk_1` FOREIGN KEY (`id_esquema`) REFERENCES `esquema` (`id_esquema`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `columna` (
  `id_columna` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_columna` varchar(30) NOT NULL,
  `data_type` varchar(30) NOT NULL,
  `id_tabla` int(3) NOT NULL,
  PRIMARY KEY (`id_columna`),
  KEY `id_tabla` (`id_tabla`),
  CONSTRAINT `columna_ibfk_1` FOREIGN KEY (`id_tabla`) REFERENCES `tabla` (`id_tabla`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `modelonavegacion` (
`ID` INT(10) NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(30) NOT NULL,
PRIMARY KEY (`ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

CREATE TABLE `contextonavegacion` (
`ID` INT(10) NOT NULL AUTO_INCREMENT,
`link` VARCHAR(30) NOT NULL,
`ID_Modelo` INT(10) NULL DEFAULT NULL,
PRIMARY KEY (`ID`),
INDEX `ID_Modelo` (`ID_Modelo`),
CONSTRAINT `contextonavegacion_ibfk_1` FOREIGN KEY (`ID_Modelo`) REFERENCES `modelonavegacion` (`ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

CREATE TABLE `unidadabstractainformacion` (
`ID` INT(10) NOT NULL AUTO_INCREMENT,
`ID_Contexto` INT(10) NOT NULL,
`ID_Tabla` INT(11) NOT NULL,
PRIMARY KEY (`ID`),
INDEX `ID_Contexto` (`ID_Contexto`),
INDEX `ID_Tabla` (`ID_Tabla`),
CONSTRAINT `unidadabstractainformacion_ibfk_1` FOREIGN KEY (`ID_Contexto`) REFERENCES `contextonavegacion` (`ID`),
CONSTRAINT `unidadabstractainformacion_ibfk_2` FOREIGN KEY (`ID_Tabla`) REFERENCES `tabla` (`id_tabla`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB


