-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: db:3306
-- Temps de generació: 01-02-2024 a les 12:07:54
-- Versió del servidor: 5.7.44
-- Versió de PHP: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `movies`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `administrator`
--

CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcament de dades per a la taula `administrator`
--

INSERT INTO `administrator` (`id`, `password`, `username`) VALUES
(1, '12345', 'acarrascod');

-- --------------------------------------------------------

--
-- Estructura de la taula `country`
--

CREATE TABLE `country` (
  `country_id` int(10) NOT NULL,
  `country_iso_code` varchar(10) DEFAULT NULL,
  `country_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `department`
--

CREATE TABLE `department` (
  `department_id` int(10) NOT NULL,
  `department_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `gender`
--

CREATE TABLE `gender` (
  `gender_id` int(10) NOT NULL,
  `gender` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `genre`
--

CREATE TABLE `genre` (
  `genre_id` int(10) NOT NULL,
  `genre_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `keyword`
--

CREATE TABLE `keyword` (
  `keyword_id` int(10) NOT NULL,
  `keyword_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `language`
--

CREATE TABLE `language` (
  `language_id` int(10) NOT NULL,
  `language_code` varchar(10) DEFAULT NULL,
  `language_name` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `language_role`
--

CREATE TABLE `language_role` (
  `role_id` int(10) NOT NULL,
  `language_role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `movie`
--

CREATE TABLE `movie` (
  `movie_id` int(10) NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `budget` int(10) DEFAULT NULL,
  `homepage` varchar(1000) DEFAULT NULL,
  `overview` varchar(1000) DEFAULT NULL,
  `popularity` decimal(38,2) DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `revenue` bigint(20) DEFAULT NULL,
  `runtime` int(5) DEFAULT NULL,
  `movie_status` varchar(50) DEFAULT NULL,
  `tagline` varchar(1000) DEFAULT NULL,
  `vote_average` double DEFAULT NULL,
  `vote_count` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `movie_cast`
--

CREATE TABLE `movie_cast` (
  `movie_id` int(10) DEFAULT NULL,
  `person_id` int(10) DEFAULT NULL,
  `character_name` varchar(400) DEFAULT NULL,
  `gender_id` int(10) DEFAULT NULL,
  `cast_order` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `movie_company`
--

CREATE TABLE `movie_company` (
  `movie_id` int(10) DEFAULT NULL,
  `company_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `movie_crew`
--

CREATE TABLE `movie_crew` (
  `movie_id` int(10) DEFAULT NULL,
  `person_id` int(10) DEFAULT NULL,
  `department_id` int(10) DEFAULT NULL,
  `job` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `movie_genres`
--

CREATE TABLE `movie_genres` (
  `movie_id` int(10) DEFAULT NULL,
  `genre_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `movie_keywords`
--

CREATE TABLE `movie_keywords` (
  `movie_id` int(10) DEFAULT NULL,
  `keyword_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `movie_languages`
--

CREATE TABLE `movie_languages` (
  `movie_id` int(10) DEFAULT NULL,
  `language_id` int(10) DEFAULT NULL,
  `language_role_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `person`
--

CREATE TABLE `person` (
  `person_id` int(10) NOT NULL,
  `person_name` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `production_company`
--

CREATE TABLE `production_company` (
  `company_id` int(10) NOT NULL,
  `company_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de la taula `production_country`
--

CREATE TABLE `production_country` (
  `movie_id` int(10) DEFAULT NULL,
  `country_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`);

--
-- Índexs per a la taula `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`);

--
-- Índexs per a la taula `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`department_id`);

--
-- Índexs per a la taula `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`gender_id`);

--
-- Índexs per a la taula `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`genre_id`);

--
-- Índexs per a la taula `keyword`
--
ALTER TABLE `keyword`
  ADD PRIMARY KEY (`keyword_id`);

--
-- Índexs per a la taula `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`language_id`);

--
-- Índexs per a la taula `language_role`
--
ALTER TABLE `language_role`
  ADD PRIMARY KEY (`role_id`);

--
-- Índexs per a la taula `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_id`);

--
-- Índexs per a la taula `movie_cast`
--
ALTER TABLE `movie_cast`
  ADD KEY `fk_mca_movie` (`movie_id`),
  ADD KEY `fk_mca_per` (`person_id`),
  ADD KEY `fk_mca_gender` (`gender_id`);

--
-- Índexs per a la taula `movie_company`
--
ALTER TABLE `movie_company`
  ADD KEY `fk_mc_movie` (`movie_id`),
  ADD KEY `fk_mc_comp` (`company_id`);

--
-- Índexs per a la taula `movie_crew`
--
ALTER TABLE `movie_crew`
  ADD KEY `fk_mcr_movie` (`movie_id`),
  ADD KEY `fk_mcr_per` (`person_id`),
  ADD KEY `fk_mcr_dept` (`department_id`);

--
-- Índexs per a la taula `movie_genres`
--
ALTER TABLE `movie_genres`
  ADD KEY `fk_mg_movie` (`movie_id`),
  ADD KEY `fk_mg_genre` (`genre_id`);

--
-- Índexs per a la taula `movie_keywords`
--
ALTER TABLE `movie_keywords`
  ADD KEY `fk_mk_movie` (`movie_id`),
  ADD KEY `fk_mk_keyword` (`keyword_id`);

--
-- Índexs per a la taula `movie_languages`
--
ALTER TABLE `movie_languages`
  ADD KEY `fk_ml_movie` (`movie_id`),
  ADD KEY `fk_ml_lang` (`language_id`),
  ADD KEY `fk_ml_role` (`language_role_id`);

--
-- Índexs per a la taula `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`person_id`);

--
-- Índexs per a la taula `production_company`
--
ALTER TABLE `production_company`
  ADD PRIMARY KEY (`company_id`);

--
-- Índexs per a la taula `production_country`
--
ALTER TABLE `production_country`
  ADD KEY `fk_pc_movie` (`movie_id`),
  ADD KEY `fk_pc_country` (`country_id`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `administrator`
--
ALTER TABLE `administrator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la taula `country`
--
ALTER TABLE `country`
  MODIFY `country_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la taula `department`
--
ALTER TABLE `department`
  MODIFY `department_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la taula `language`
--
ALTER TABLE `language`
  MODIFY `language_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la taula `movie`
--
ALTER TABLE `movie`
  MODIFY `movie_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `movie_cast`
--
ALTER TABLE `movie_cast`
  ADD CONSTRAINT `fk_mca_gender` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`),
  ADD CONSTRAINT `fk_mca_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  ADD CONSTRAINT `fk_mca_per` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`);

--
-- Restriccions per a la taula `movie_company`
--
ALTER TABLE `movie_company`
  ADD CONSTRAINT `fk_mc_comp` FOREIGN KEY (`company_id`) REFERENCES `production_company` (`company_id`),
  ADD CONSTRAINT `fk_mc_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

--
-- Restriccions per a la taula `movie_crew`
--
ALTER TABLE `movie_crew`
  ADD CONSTRAINT `fk_mcr_dept` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  ADD CONSTRAINT `fk_mcr_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  ADD CONSTRAINT `fk_mcr_per` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`);

--
-- Restriccions per a la taula `movie_genres`
--
ALTER TABLE `movie_genres`
  ADD CONSTRAINT `fk_mg_genre` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`),
  ADD CONSTRAINT `fk_mg_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

--
-- Restriccions per a la taula `movie_keywords`
--
ALTER TABLE `movie_keywords`
  ADD CONSTRAINT `fk_mk_keyword` FOREIGN KEY (`keyword_id`) REFERENCES `keyword` (`keyword_id`),
  ADD CONSTRAINT `fk_mk_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

--
-- Restriccions per a la taula `movie_languages`
--
ALTER TABLE `movie_languages`
  ADD CONSTRAINT `fk_ml_lang` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`),
  ADD CONSTRAINT `fk_ml_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  ADD CONSTRAINT `fk_ml_role` FOREIGN KEY (`language_role_id`) REFERENCES `language_role` (`role_id`);

--
-- Restriccions per a la taula `production_country`
--
ALTER TABLE `production_country`
  ADD CONSTRAINT `fk_pc_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`),
  ADD CONSTRAINT `fk_pc_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
