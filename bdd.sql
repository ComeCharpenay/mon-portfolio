-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 05 jan. 2026 à 14:50
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdd`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `numcat` int(5) NOT NULL,
  `nomcat` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`numcat`, `nomcat`) VALUES
(1, 'non renseigné'),
(2, 'ouvrier'),
(3, 'cadre'),
(4, 'sans-emploi'),
(5, 'autres');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `num` char(12) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `ville` varchar(20) NOT NULL,
  `categorie` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`num`, `nom`, `prenom`, `ville`, `categorie`) VALUES
('1', 'Quasi', 'Nathan', 'Paris', 1),
('10', 'Tuuji', 'Inès', 'Nanterre', 2),
('2', 'Vimif', 'Lucas', 'Paris', 3),
('3', 'Gulya', 'Enzo', 'Courbevoie', 3),
('4', 'Vetea', 'Léo', 'Nanterre', 4),
('5', 'Lossu', 'Louis', 'Paris', 4),
('6', 'Ebote', 'Emma', 'Paris', 2),
('7', 'Talam', 'Léa', 'Courbevoie', 3),
('8', 'Julyn', 'Chloé', 'Paris', 2),
('9', 'Voduk', 'Manon', 'Paris', 5);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vue_categories`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `vue_categories` (
`nomcat` varchar(35)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vue_clients_categories`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `vue_clients_categories` (
`nom` varchar(20)
,`prenom` varchar(20)
,`nomcat` varchar(35)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vue_villes_categories`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `vue_villes_categories` (
`ville` varchar(20)
,`numcat` int(5)
,`nomcat` varchar(35)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vue_villes_categories_distinct`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `vue_villes_categories_distinct` (
`ville` varchar(20)
,`numcat` int(5)
,`nomcat` varchar(35)
);

-- --------------------------------------------------------

--
-- Structure de la vue `vue_categories`
--
DROP TABLE IF EXISTS `vue_categories`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vue_categories`  AS SELECT `categorie`.`nomcat` AS `nomcat` FROM `categorie` ;

-- --------------------------------------------------------

--
-- Structure de la vue `vue_clients_categories`
--
DROP TABLE IF EXISTS `vue_clients_categories`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vue_clients_categories`  AS SELECT `c`.`nom` AS `nom`, `c`.`prenom` AS `prenom`, `ca`.`nomcat` AS `nomcat` FROM (`client` `c` join `categorie` `ca` on(`c`.`categorie` = `ca`.`numcat`)) ;

-- --------------------------------------------------------

--
-- Structure de la vue `vue_villes_categories`
--
DROP TABLE IF EXISTS `vue_villes_categories`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vue_villes_categories`  AS SELECT `c`.`ville` AS `ville`, `ca`.`numcat` AS `numcat`, `ca`.`nomcat` AS `nomcat` FROM (`client` `c` join `categorie` `ca` on(`c`.`categorie` = `ca`.`numcat`)) ;

-- --------------------------------------------------------

--
-- Structure de la vue `vue_villes_categories_distinct`
--
DROP TABLE IF EXISTS `vue_villes_categories_distinct`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vue_villes_categories_distinct`  AS SELECT DISTINCT `c`.`ville` AS `ville`, `ca`.`numcat` AS `numcat`, `ca`.`nomcat` AS `nomcat` FROM (`client` `c` join `categorie` `ca` on(`c`.`categorie` = `ca`.`numcat`)) ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`numcat`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
