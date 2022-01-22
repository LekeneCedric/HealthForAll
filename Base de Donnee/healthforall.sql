-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 22 jan. 2022 à 21:11
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `healthforall`
--

-- --------------------------------------------------------

--
-- Structure de la table `bilan`
--

CREATE TABLE `bilan` (
  `IDBILAN` int(1) NOT NULL,
  `CODEP` varchar(8) NOT NULL,
  `DATE` varchar(150) DEFAULT NULL,
  `CONSULTER` varchar(3) DEFAULT NULL,
  `DESCRIPTIONBILAN` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bilan`
--

INSERT INTO `bilan` (`IDBILAN`, `CODEP`, `DATE`, `CONSULTER`, `DESCRIPTIONBILAN`) VALUES
(16, '20V2060', '2022/01/11 02:38:48', 'oui', 'Douleur a la poitrine '),
(17, '20R2018', '2022/01/11 02:41:19', 'oui', 'Fortes douleurs au niveau du tube digestif , impossibilite a dormir , fatigue excessive '),
(18, '20V2060', '2022/01/12 10:41:24', 'oui', 'Douleur au niveau de la poitrine'),
(19, '20V2060', '2022/01/13 00:29:34', 'oui', 'Maux de tetes intenses'),
(20, '20V2060', '2022/01/13 04:58:40', 'oui', 'Maux de tete , Paludisme '),
(21, '20V2060', '2022/01/14 01:48:46', 'oui', 'Toux grave , Perte de l\'appetit '),
(22, '20V2060', '2022/01/14 01:57:10', 'oui', 'Tester Positif au covid 19 '),
(23, '20V2060', '2022/01/14 02:09:05', 'oui', 'Tester Positif au covid - 19 ! '),
(24, '20V2060', '2022/01/14 02:50:24', 'oui', 'Maux de tete , fievre , temperature eleve ,frissons'),
(25, '20V2060', '2022/01/14 02:58:08', 'non', 'Tester Positif au covid - 19 ! '),
(26, '20V2060', '2022/01/18 10:34:16', 'non', 'Tester Positif au covid - 19 ! '),
(27, '20V2060', '2022/01/21 01:31:55', 'non', 'Maux de tetes , fievre ');

-- --------------------------------------------------------

--
-- Structure de la table `docteur`
--

CREATE TABLE `docteur` (
  `CODEDOC` varchar(5) NOT NULL,
  `NOMDOC` varchar(18) DEFAULT NULL,
  `PRENOMDOC` varchar(8) DEFAULT NULL,
  `NUMERODOC` int(11) DEFAULT NULL,
  `SPECIALITEDOC` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `docteur`
--

INSERT INTO `docteur` (`CODEDOC`, `NOMDOC`, `PRENOMDOC`, `NUMERODOC`, `SPECIALITEDOC`) VALUES
('DOC01', 'NDONFAE', 'Florent', 650225213, 'Generaliste'),
('DOC02', 'AkaZon', 'stephan', 652121536, 'Dentiste');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `CODEP` varchar(8) NOT NULL,
  `NOMP` varchar(18) DEFAULT NULL,
  `PRENOMP` varchar(8) DEFAULT NULL,
  `AGEP` int(11) DEFAULT NULL,
  `TAILLEP` float DEFAULT NULL,
  `POIDSP` float DEFAULT NULL,
  `ETATCOVIDP` varchar(7) DEFAULT NULL,
  `PASSWORD` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`CODEP`, `NOMP`, `PRENOMP`, `AGEP`, `TAILLEP`, `POIDSP`, `ETATCOVIDP`, `PASSWORD`) VALUES
('20I2085', 'Kuemo', 'Leticia', 18, 200, 40, 'Non', 'leticia'),
('20R2018', 'Fouba', 'Alain', 18, 185, 70, 'oui', '20ddd5'),
('20V2060', 'Lekene', 'cedric', 10, 85, 85, 'oui', 'hacker-man'),
('42hgf', 'Abada', 'Imele', 10, 150, 60, 'Non', 'abada2010'),
('Allain13', 'Alain', 'Fouba', 15, 1.65, 83, 'Non', 'Gta');

-- --------------------------------------------------------

--
-- Structure de la table `prescription`
--

CREATE TABLE `prescription` (
  `IDPRESCRIPTION` int(1) NOT NULL,
  `CODEDOC` varchar(5) NOT NULL,
  `CODEP` varchar(8) NOT NULL,
  `DESCRIPTIONPRESCRIPTION` text DEFAULT NULL,
  `DATE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `prescription`
--

INSERT INTO `prescription` (`IDPRESCRIPTION`, `CODEDOC`, `CODEP`, `DESCRIPTIONPRESCRIPTION`, `DATE`) VALUES
(1, 'DOC01', '20V2060', '-Paracetamol 300mg\n-Quinine 250mg', ''),
(3, 'DOC01', '20R2018', 'la mort vous attend', ''),
(4, 'DOC01', '20R2018', 'la mort vous attend', ''),
(5, 'DOC01', '20V2060', 'La mort vous attend ,,,, vous allez bientot mourir ! Dites aurevoir a votre Famille', '2022/01/12 10:44:29'),
(6, 'DOC01', '20V2060', '- parcetamol 250 mg \n- doliprane 500mg', '2022/01/13 00:30:39'),
(7, 'DOC01', '20V2060', '-Paracetamol\n-Doliprane 500mg', '2022/01/13 04:59:16'),
(8, 'DOC01', '20V2060', '-Prenez une tasse de djinja avec de l\'eau sucree \n- Prenez l\'asurgininine 250mg', '2022/01/14 01:49:52'),
(10, 'DOC01', '20V2060', 'Tester Positif au covid 19 ', '2022/01/14 02:05:09'),
(11, 'DOC01', '20V2060', 'Tester Positif au covid 19 ', '2022/01/14 02:09:05'),
(12, 'DOC01', '20v2060', 'buvez le paracetamol 250mg pendant 5 jours , 1 prise 3 fois par jours ', '2022/01/14 02:52:12'),
(13, 'DOC01', '20V2060', 'Tester Negatif au Covid-19', '2022/01/14 02:55:46'),
(14, 'DOC01', '20V2060', 'Tester Negatif au Covid-19', '2022/01/14 02:56:47'),
(15, 'DOC01', '20V2060', 'Tester Negatif au Covid-19', '2022/01/14 02:58:01'),
(16, 'DOC01', '20V2060', 'Tester Positif au covid 19 ', '2022/01/14 02:58:08'),
(17, 'DOC01', '20V2060', 'Tester Positif au covid 19 ', '2022/01/18 10:34:16');

-- --------------------------------------------------------

--
-- Structure de la table `traitement`
--

CREATE TABLE `traitement` (
  `IDTRAITEMENT` int(1) NOT NULL,
  `CODEDOC` varchar(5) NOT NULL,
  `NOMTRAITEMENT` varchar(18) DEFAULT NULL,
  `IMAGE` varchar(150) DEFAULT NULL,
  `DESCRIPTIONTRAITEMENT` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `traitement`
--

INSERT INTO `traitement` (`IDTRAITEMENT`, `CODEDOC`, `NOMTRAITEMENT`, `IMAGE`, `DESCRIPTIONTRAITEMENT`) VALUES
(1, 'DOC01', 'PALUDISME', 'images\\download.jpg', 'Traitement recommandé pour le paludisme grave :\r\n\r\nPosologie :\r\n\r\nArtésunate 2,4 mg/kg de poids corporel administré par voie intraveineuse (IV) ou intramusculaire (IM) au moment de l’admission (temps 0), à 12 h, à 24 h, et ensuite une fois par jour jusqu’à ce que le patient soit capable de prendre les médicaments par voie orale.\r\nLes enfants pesant <20 kg doivent recevoir une dose plus élevée d’artésunate (3 mg/kg/dose), contre 2,4 mg/kg/dose pour les enfants plus grands et les adultes, pour assurer une exposition équivalente au médicament.'),
(3, 'DOC01', 'Typhoide', '', '- Buvez une petite guiness avec l\'huile de la Sardine\n- Bien melanger le tout');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bilan`
--
ALTER TABLE `bilan`
  ADD PRIMARY KEY (`IDBILAN`),
  ADD KEY `FK_FAIRE` (`CODEP`);

--
-- Index pour la table `docteur`
--
ALTER TABLE `docteur`
  ADD PRIMARY KEY (`CODEDOC`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`CODEP`);

--
-- Index pour la table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`IDPRESCRIPTION`),
  ADD KEY `FK_PRESCRIRE` (`CODEDOC`),
  ADD KEY `FK_RECEVOIR` (`CODEP`);

--
-- Index pour la table `traitement`
--
ALTER TABLE `traitement`
  ADD PRIMARY KEY (`IDTRAITEMENT`),
  ADD KEY `FK_AJOUTER` (`CODEDOC`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bilan`
--
ALTER TABLE `bilan`
  MODIFY `IDBILAN` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `IDPRESCRIPTION` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `traitement`
--
ALTER TABLE `traitement`
  MODIFY `IDTRAITEMENT` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bilan`
--
ALTER TABLE `bilan`
  ADD CONSTRAINT `FK_FAIRE` FOREIGN KEY (`CODEP`) REFERENCES `patient` (`CODEP`);

--
-- Contraintes pour la table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `FK_PRESCRIRE` FOREIGN KEY (`CODEDOC`) REFERENCES `docteur` (`CODEDOC`),
  ADD CONSTRAINT `FK_RECEVOIR` FOREIGN KEY (`CODEP`) REFERENCES `patient` (`CODEP`);

--
-- Contraintes pour la table `traitement`
--
ALTER TABLE `traitement`
  ADD CONSTRAINT `FK_AJOUTER` FOREIGN KEY (`CODEDOC`) REFERENCES `docteur` (`CODEDOC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
