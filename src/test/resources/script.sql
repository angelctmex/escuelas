/** SCRIPT PARA CREAR LA TABLA ESCUELAS **/
CREATE TABLE `escuelas`.`escuelas` (
  `id_escuela` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_escuela` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `especialidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_escuela`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

/** SCRIPT PARA CREAR LA TABLA ALUMNOS **/
CREATE  TABLE IF NOT EXISTS `escuelas`.`alumnos` (
  `id_alumno` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `apellido_paterno` VARCHAR(45) NULL ,
  `apellido_materno` VARCHAR(45) NULL ,
  `matricula` VARCHAR(45) NULL ,
  `grado_estudios` INT NULL ,
  `edad` INT NULL ,
  `sexo` CHAR NULL ,
  `id_escuela` INT NOT NULL ,
  PRIMARY KEY (`id_alumno`) ,
  INDEX `fk_alumnos_escuelas_idx` (`id_escuela` ASC) ,
  CONSTRAINT `fk_alumnos_escuelas`
    FOREIGN KEY (`id_escuela` )
    REFERENCES `escuelas`.`escuelas` (`id_escuela` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

/** SCRIPT PARA CREAR LA TABLA PROFESORES **/
CREATE  TABLE `escuelas`.`profesores` (
  `id_profesor` INT NOT NULL AUTO_INCREMENT,
  `nombre_profesor` VARCHAR(45) NULL ,
  `apellido_paterno_profesor` VARCHAR(45) NULL ,
  `apellido_materno_profesor` VARCHAR(45) NULL ,
  `especialidad` VARCHAR(45) NULL ,
  `escuelas_id_escuela` INT NOT NULL ,
  PRIMARY KEY (`id_profesor`, `escuelas_id_escuela`) ,
  INDEX `fk_profesores_escuelas1_idx` (`escuelas_id_escuela` ASC) ,
  CONSTRAINT `fk_profesores_escuelas1`
    FOREIGN KEY (`escuelas_id_escuela` )
    REFERENCES `escuelas`.`escuelas` (`id_escuela` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    

