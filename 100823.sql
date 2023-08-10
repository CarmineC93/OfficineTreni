-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 10, 2023 at 10:03 AM
-- Server version: 5.7.24
-- PHP Version: 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `idm15`
--

-- --------------------------------------------------------

--
-- Table structure for table `composizione`
--

CREATE TABLE `composizione` (
  `treno` int(11) NOT NULL,
  `vagone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `composizione`
--

INSERT INTO `composizione` (`treno`, `vagone`) VALUES
(1, 4),
(1, 7),
(1, 7),
(1, 7),
(1, 7),
(1, 7),
(1, 12),
(1, 12),
(1, 12),
(2, 6),
(2, 11),
(2, 11),
(2, 11),
(2, 11),
(3, 4),
(3, 7),
(3, 7),
(3, 12),
(3, 13),
(3, 12),
(3, 7),
(3, 7),
(4, 10),
(4, 11),
(4, 16),
(4, 11),
(4, 16),
(4, 11),
(4, 16),
(4, 11),
(4, 16);

-- --------------------------------------------------------

--
-- Table structure for table `ordine`
--

CREATE TABLE `ordine` (
  `id` int(11) NOT NULL,
  `treno_id` int(11) NOT NULL,
  `utente_id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `stato` varchar(45) NOT NULL,
  `importo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ordine`
--

INSERT INTO `ordine` (`id`, `treno_id`, `utente_id`, `data`, `stato`, `importo`) VALUES
(1, 4, 10, '2023-07-19 00:00:00', 'Ordinato', 19900),
(2, 1, 12, '2023-07-16 00:00:00', 'Costruzione', 13500),
(3, 3, 11, '2022-12-26 00:00:00', 'Consegnato', 13300);

-- --------------------------------------------------------

--
-- Table structure for table `treno`
--

CREATE TABLE `treno` (
  `idTreno` int(11) NOT NULL,
  `utente` int(11) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `compagnia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `treno`
--

INSERT INTO `treno` (`idTreno`, `utente`, `sigla`, `nome`, `compagnia`) VALUES
(1, 3, 'HPPPPPPP', 'Cittanotte', 'TrenItalia'),
(2, 1, 'HCCCC', 'Freezer', 'Italo'),
(3, 2, 'HPPPRPPP', 'VIP Party', 'TrenItalia'),
(4, 10, 'HCCCCCCCC', 'Trainsport', 'Italo');

-- --------------------------------------------------------

--
-- Table structure for table `utente`
--

CREATE TABLE `utente` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `ruolo` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(135) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utente`
--

INSERT INTO `utente` (`id`, `nome`, `cognome`, `ruolo`, `email`, `password`) VALUES
(1, 'Carmine', 'Caglia', '', 'cc@idm.it', 'ccidm'),
(2, 'Antonino', 'Irrera', '', 'ai@idm.it', 'aiidm'),
(3, 'Giuseppe', 'Visconti', '', 'gv@idm.it', 'gvidm'),
(10, 'Salvatore', 'Mazza', '', 'sm@idm.it', 'smidm'),
(11, 'Sara', 'Brogin', '', 'sb@idm.it', 'sbidm'),
(12, 'Eleonora', 'Leuci', '', 'el@idm.it', 'elidm'),
(13, 'Marco', 'Velluso', '', 'mv@idm.it', 'mvidm'),
(14, 'Eugenio', 'Sgobba', '', 'es@idm.it', 'esidm'),
(15, 'Federico', 'Mascali', '', 'fm@idm.it', 'fmidm');

-- --------------------------------------------------------

--
-- Table structure for table `vagone`
--

CREATE TABLE `vagone` (
  `id` int(11) NOT NULL,
  `tipologia` char(1) NOT NULL,
  `peso` float NOT NULL,
  `lunghezza` float NOT NULL,
  `colore` varchar(45) DEFAULT NULL,
  `compagnia` varchar(45) DEFAULT NULL,
  `costo` float NOT NULL,
  `capienza` int(11) NOT NULL,
  `pesoTrainante` int(11) NOT NULL,
  `imgBytes` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vagone`
--

INSERT INTO `vagone` (`id`, `tipologia`, `peso`, `lunghezza`, `colore`, `compagnia`, `costo`, `capienza`, `pesoTrainante`, `imgBytes`) VALUES
(1, 'C', 5000, 20, 'Rosso', 'Trenitalia', 1500, 500, 0, ''),
(2, 'R', 4000, 15, 'Azzurro', 'Trenitalia', 2000, 20, 0, ''),
(3, 'R', 3000, 75, 'Verde', 'Italo', 1550, 40, 0, ''),
(4, 'H', 5500, 42, 'Verde', 'Trenitalia', 3000, 2, 40000, ''),
(5, 'C', 5000, 50, 'Azzurro', 'Trenitalia', 2200, 600, 0, ''),
(6, 'H', 4000, 20, 'Rosso', 'Italo', 1400, 2, 30000, ''),
(7, 'P', 2000, 15, 'Rosso', 'Trenitalia', 1200, 60, 0, ''),
(8, 'R', 3000, 12, 'Giallo', 'Italo', 1500, 15, 0, ''),
(9, 'P', 4000, 30, 'Bianco', 'Italo', 1500, 30, 0, ''),
(10, 'H', 2000, 10, 'Verde', 'Italo', 1900, 2, 15000, ''),
(11, 'C', 4000, 35, 'Nero', 'Italo', 2500, 450, 0, ''),
(12, 'P', 7000, 50, 'Verde', 'Trenitalia', 1900, 10, 0, ''),
(13, 'R', 7000, 35, 'Bianco', 'Trenitalia', 1700, 10, 0, ''),
(14, 'P', 5000, 40, 'Nero', 'Italo', 2000, 50, 0, ''),
(15, 'H', 7000, 50, 'Verde', 'Trenitalia', 1900, 2, 50000, ''),
(16, 'C', 7500, 50, 'Azzurro', 'Italo', 2000, 800, 0, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `composizione`
--
ALTER TABLE `composizione`
  ADD KEY `fk_Composizione_Treno1_idx` (`treno`),
  ADD KEY `fk_Composizione_Vagone1_idx` (`vagone`);

--
-- Indexes for table `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Ordine_Treno1_idx` (`treno_id`),
  ADD KEY `fk_Ordine_Utente1_idx` (`utente_id`);

--
-- Indexes for table `treno`
--
ALTER TABLE `treno`
  ADD PRIMARY KEY (`idTreno`,`utente`),
  ADD KEY `fk_Treno_Utente1_idx` (`utente`);

--
-- Indexes for table `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `vagone`
--
ALTER TABLE `vagone`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ordine`
--
ALTER TABLE `ordine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `treno`
--
ALTER TABLE `treno`
  MODIFY `idTreno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `vagone`
--
ALTER TABLE `vagone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `composizione`
--
ALTER TABLE `composizione`
  ADD CONSTRAINT `fk_Composizione_Treno1` FOREIGN KEY (`treno`) REFERENCES `treno` (`idTreno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Composizione_Vagone1` FOREIGN KEY (`vagone`) REFERENCES `vagone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `fk_Ordine_Treno1` FOREIGN KEY (`treno_id`) REFERENCES `treno` (`idTreno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Ordine_Utente1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `treno`
--
ALTER TABLE `treno`
  ADD CONSTRAINT `fk_Treno_Utente1` FOREIGN KEY (`utente`) REFERENCES `utente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
