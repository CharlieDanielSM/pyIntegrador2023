SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

DROP DATABASE IF EXISTS `bdservitec`;
CREATE DATABASE IF NOT EXISTS `bdservitec` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdservitec`;

CREATE TABLE `calificacion` (
  `idCalificacion` char(11) NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `fk_codiTrab` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `contrato` (
  `codiCont` char(11) NOT NULL,
  `fechCont` date NOT NULL,
  `fechInicCont` date NOT NULL,
  `fechFinCont` date NOT NULL,
  `estaCont` varchar(20) NOT NULL,
  `descCont` varchar(255) NOT NULL,
  `fk_codiNego` char(11) DEFAULT NULL,
  `fk_codiTrab` char(11) DEFAULT NULL,
  `fk_codiEmpl` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `empleador` (
  `codiEmpl` char(11) NOT NULL,
  `dniRucEmpl` varchar(15) NOT NULL,
  `nombEmpl` varchar(50) NOT NULL,
  `teleEmpl` varchar(15) NOT NULL,
  `emailEmpl` varchar(100) NOT NULL,
  `fk_codiTipoEmpl` char(11) DEFAULT NULL,
  `fk_codiUsua` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `empleador` (`codiEmpl`, `dniRucEmpl`, `nombEmpl`, `teleEmpl`, `emailEmpl`, `fk_codiTipoEmpl`, `fk_codiUsua`) VALUES
('E001', '12345678901', 'InnovateTech Solutions', '987654321', 'innovate@example.com', '20', 'useremp1'),
('E002', '98765432109', 'EcoHarmony Ventures', '123456789', 'ecoharmony@example.com', '10', 'useremp2'),
('E003', '65432109807', 'NexGen Dynamics', '555555555', 'nexgen@example.com', '10', 'useremp3'),
('E004', '78901234506', 'Quantum Innovations', '111111111', 'quantum@example.com', '20', 'useremp4'),
('E005', '54321098704', 'VistaGlobal Solutions', '222222222', 'vistaglobal@example.com', '10', 'useremp5'),
('E006', '87654321012', 'Zenith Innovations', '333333333', 'zenith@example.com', '10', 'useremp6'),
('E007', '10987654320', 'GreenScape Enterprises', '444444444', 'greenscape@example.com', '20', 'useremp7'),
('E008', '21098765430', 'Pinnacle Solutions', '999999999', 'pinnacle@example.com', '10', 'useremp8'),
('E009', '32109876540', 'FutureSynergy Corp', '888888888', 'futuresynergy@example.com', '20', 'useremp9'),
('E010', '43210987650', 'HarborVista Technologies', '777777777', 'harborvista@example.com', '10', 'useremp10');

CREATE TABLE `especialidad` (
  `codiEspe` char(11) NOT NULL,
  `nombEspe` varchar(100) NOT NULL,
  `precBaseEspe` decimal(10,2) NOT NULL,
  `descEspe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `especialidad` (`codiEspe`, `nombEspe`, `precBaseEspe`, `descEspe`) VALUES
('ALB01', 'Albañil', 80.00, 'Especialidad en construcción y albañilería'),
('CAR01', 'Carpintero', 90.00, 'Especialidad en trabajos de carpintería'),
('CER01', 'Cerrajero', 30.00, 'Servicio de cerrajería para solucionar problemas con cerraduras y llaves.'),
('DIN01', 'Diseñador de Interiores', 90.00, 'Servicio de diseño de interiores para planificar y decorar espacios residenciales y comerciales.'),
('ELE01', 'Electricista', 100.00, 'Especialidad en instalaciones eléctricas'),
('FON01', 'Fontanero', 90.00, 'Especialidad en instalaciones de fontanería y sistemas de agua'),
('JAR01', 'Jardinero', 65.00, 'Especialidad en diseño y mantenimiento de jardines'),
('LIM01', 'Limpieza Profesional', 80.00, 'Servicio de limpieza para hogares y empresas, que incluye limpieza profunda y mantenimiento de espacios.'),
('MEC01', 'Mecánico', 120.00, 'Especialidad en reparación de maquinaria'),
('ORG01', 'Organizador de Eventos', 100.00, 'Servicio de planificación y coordinación de eventos, como bodas, conferencias y fiestas, asegurando que todo salga perfecto.'),
('PNT01', 'Pintor', 70.00, 'Especialidad en trabajos de pintura y decoración'),
('REP01', 'Reparador de Electrodomésticos', 40.00, 'Servicio de reparación y mantenimiento de electrodomésticos en hogares y empresas.'),
('TEC01', 'Técnico de PC', 110.00, 'Especialidad en reparación y mantenimiento de computadoras'),
('TEC02', 'Técnico en Informática', 110.00, 'Especialidad en reparación y mantenimiento de equipos informáticos'),
('YTB01', 'Youtuber', 60.00, 'Creador de contenido de videos para plataformas en línea.');

CREATE TABLE `negociacion` (
  `codiNego` char(11) NOT NULL,
  `fechNego` date NOT NULL,
  `estaNego` varchar(20) NOT NULL,
  `montNego` decimal(10,2) NOT NULL,
  `descNego` varchar(255) NOT NULL,
  `fk_codiTrab` char(11) DEFAULT NULL,
  `fk_codiEmpl` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `pagoservicio` (
  `codiPagoServ` char(11) NOT NULL,
  `fechPagoServ` date NOT NULL,
  `tipoCompPagoServ` varchar(20) NOT NULL,
  `fk_codiCont` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `tipoempleador` (
  `codiTipoEmpl` char(11) NOT NULL,
  `nombTipoEmpl` varchar(50) NOT NULL,
  `descTipoEmple` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tipoempleador` (`codiTipoEmpl`, `nombTipoEmpl`, `descTipoEmple`) VALUES
('10', 'Persona Natural', ''),
('20', 'Persona Juridica', '');

CREATE TABLE `trabajador` (
  `codiTrab` char(11) NOT NULL,
  `dniTrab` varchar(15) NOT NULL,
  `nombTrab` varchar(50) NOT NULL,
  `ApelTrab` varchar(50) NOT NULL,
  `teleTrab` varchar(15) NOT NULL,
  `sexoTrab` char(1) NOT NULL,
  `emailTrab` varchar(100) NOT NULL,
  `fk_codiEspe` char(11) DEFAULT NULL,
  `fk_codiUsua` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `trabajador` (`codiTrab`, `dniTrab`, `nombTrab`, `ApelTrab`, `teleTrab`, `sexoTrab`, `emailTrab`, `fk_codiEspe`, `fk_codiUsua`) VALUES
('T001', '12345678', 'Juan', 'Perez', '987654321', 'M', 'juan.perez@email.com', 'ALB01', '123juan'),
('T002', '23456789', 'Maria', 'Gomez', '987654322', 'F', 'maria.gomez@email.com', 'DIN01', '123maria'),
('T003', '34567890', 'Carlos', 'Lopez', '987654323', 'M', 'carlos.lopez@email.com', 'CAR01', '123carlos'),
('T004', '45678901', 'Ana', 'Martinez', '987654324', 'F', 'ana.martinez@email.com', 'LIM01', '123ana'),
('T005', '56789012', 'Luis', 'Rodriguez', '987654325', 'M', 'luis.rodriguez@email.com', 'CER01', '123luis');

CREATE TABLE `usuario` (
  `codiUsua` char(11) NOT NULL,
  `passUsua` varchar(255) NOT NULL,
  `tipoUsua` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `usuario` (`codiUsua`, `passUsua`, `tipoUsua`) VALUES
('123ana', 'Ana', 'trabajador'),
('123carlos', 'Carlos', 'trabajador'),
('123juan', 'Juan', 'trabajador'),
('123luis', 'Luis', 'trabajador'),
('123maria', 'Maria', 'trabajador'),
('admin', 'admin', 'admin'),
('cliente', 'cliente', 'cliente'),
('trabajador', 'trabajador', 'trabajador'),
('useremp1', 'claveuseremp1', 'empleador'),
('useremp10', 'claveuseremp10', 'empleador'),
('useremp2', 'claveuseremp2', 'empleador'),
('useremp3', 'claveuseremp3', 'empleador'),
('useremp4', 'claveuseremp4', 'empleador'),
('useremp5', 'claveuseremp5', 'empleador'),
('useremp6', 'claveuseremp6', 'empleador'),
('useremp7', 'claveuseremp7', 'empleador'),
('useremp8', 'claveuseremp8', 'empleador'),
('useremp9', 'claveuseremp9', 'empleador');


ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`idCalificacion`),
  ADD KEY `fk_codiTrab` (`fk_codiTrab`);

ALTER TABLE `contrato`
  ADD PRIMARY KEY (`codiCont`),
  ADD KEY `fk_codiNego` (`fk_codiNego`),
  ADD KEY `fk_codiTrab` (`fk_codiTrab`),
  ADD KEY `fk_codiEmpl` (`fk_codiEmpl`);

ALTER TABLE `empleador`
  ADD PRIMARY KEY (`codiEmpl`),
  ADD UNIQUE KEY `dniRucEmpl` (`dniRucEmpl`),
  ADD KEY `fk_codiTipoEmpl` (`fk_codiTipoEmpl`),
  ADD KEY `fk_codiUsua` (`fk_codiUsua`);

ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`codiEspe`);

ALTER TABLE `negociacion`
  ADD PRIMARY KEY (`codiNego`),
  ADD KEY `fk_codiTrab` (`fk_codiTrab`),
  ADD KEY `fk_codiEmpl` (`codiNego`) USING BTREE;

ALTER TABLE `pagoservicio`
  ADD PRIMARY KEY (`codiPagoServ`),
  ADD KEY `fk_codiCont` (`fk_codiCont`);

ALTER TABLE `tipoempleador`
  ADD PRIMARY KEY (`codiTipoEmpl`);

ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`codiTrab`),
  ADD UNIQUE KEY `dniTrab` (`dniTrab`),
  ADD KEY `fk_codiEspe` (`fk_codiEspe`),
  ADD KEY `fk_codiUsua` (`fk_codiUsua`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codiUsua`);


ALTER TABLE `calificacion`
  ADD CONSTRAINT `calificacion_ibfk_1` FOREIGN KEY (`fk_codiTrab`) REFERENCES `trabajador` (`codiTrab`);

ALTER TABLE `contrato`
  ADD CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`fk_codiNego`) REFERENCES `negociacion` (`codiNego`),
  ADD CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`fk_codiTrab`) REFERENCES `trabajador` (`codiTrab`),
  ADD CONSTRAINT `contrato_ibfk_3` FOREIGN KEY (`fk_codiEmpl`) REFERENCES `empleador` (`codiEmpl`);

ALTER TABLE `empleador`
  ADD CONSTRAINT `empleador_ibfk_1` FOREIGN KEY (`fk_codiTipoEmpl`) REFERENCES `tipoempleador` (`codiTipoEmpl`),
  ADD CONSTRAINT `empleador_ibfk_2` FOREIGN KEY (`fk_codiUsua`) REFERENCES `usuario` (`codiUsua`);

ALTER TABLE `negociacion`
  ADD CONSTRAINT `negociacion_ibfk_1` FOREIGN KEY (`fk_codiTrab`) REFERENCES `trabajador` (`codiTrab`);

ALTER TABLE `pagoservicio`
  ADD CONSTRAINT `pagoservicio_ibfk_1` FOREIGN KEY (`fk_codiCont`) REFERENCES `contrato` (`codiCont`);

ALTER TABLE `trabajador`
  ADD CONSTRAINT `trabajador_ibfk_1` FOREIGN KEY (`fk_codiEspe`) REFERENCES `especialidad` (`codiEspe`),
  ADD CONSTRAINT `trabajador_ibfk_2` FOREIGN KEY (`fk_codiUsua`) REFERENCES `usuario` (`codiUsua`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
