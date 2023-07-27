-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 26, 2023 at 04:40 PM
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
  `vagone` int(11) NOT NULL,
  `posizione` int(11) NOT NULL,
  `tipologia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `composizione`
--

INSERT INTO `composizione` (`treno`, `vagone`, `posizione`, `tipologia`) VALUES
(1, 4, 1, 'Locomotiva'),
(1, 7, 2, 'Passeggeri'),
(1, 7, 3, 'Passeggeri'),
(1, 7, 4, 'Passeggeri'),
(1, 7, 5, 'Passeggeri'),
(1, 7, 6, 'Passeggeri'),
(1, 12, 7, 'Passeggeri'),
(1, 12, 8, 'Passeggeri'),
(1, 12, 9, 'Passeggeri'),
(2, 6, 1, 'Locomotiva'),
(2, 11, 2, 'Cargo'),
(2, 11, 3, 'Cargo'),
(2, 11, 4, 'Cargo'),
(2, 11, 5, 'Cargo'),
(3, 4, 1, 'Locomotiva'),
(3, 7, 2, 'Passeggeri'),
(3, 7, 3, 'Passeggeri'),
(3, 12, 4, 'Passeggeri'),
(3, 13, 5, 'Ristorante'),
(3, 12, 6, 'Passeggeri'),
(3, 7, 7, 'Passeggeri'),
(3, 7, 8, 'Passeggeri'),
(4, 10, 1, 'Locomotiva'),
(4, 11, 2, 'Cargo'),
(4, 16, 3, 'Cargo'),
(4, 11, 4, 'Cargo'),
(4, 16, 5, 'Cargo'),
(4, 11, 6, 'Cargo'),
(4, 16, 7, 'Cargo'),
(4, 11, 8, 'Cargo'),
(4, 16, 9, 'Cargo');

-- --------------------------------------------------------

--
-- Table structure for table `ordine`
--

CREATE TABLE `ordine` (
  `idOrdine` int(11) NOT NULL,
  `treno` int(11) NOT NULL,
  `utente` int(11) NOT NULL,
  `data` date NOT NULL,
  `stato` varchar(45) NOT NULL,
  `pagamento` varchar(45) NOT NULL,
  `importo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ordine`
--

INSERT INTO `ordine` (`idOrdine`, `treno`, `utente`, `data`, `stato`, `pagamento`, `importo`) VALUES
(1, 4, 10, '2023-07-19', 'Ordinato', 'Effettuato', 19900),
(2, 1, 12, '2023-07-16', 'Costruzione', 'Effettuato', 13500),
(3, 3, 11, '2022-12-26', 'Consegnato', 'Effettuato', 13300);

-- --------------------------------------------------------

--
-- Table structure for table `ruolo`
--

CREATE TABLE `ruolo` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ruolo`
--

INSERT INTO `ruolo` (`id`, `nome`) VALUES
(0, 'User'),
(1, 'Admin');

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
  `email` varchar(45) NOT NULL,
  `password` varchar(135) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utente`
--

INSERT INTO `utente` (`id`, `nome`, `cognome`, `email`, `password`) VALUES
(1, 'Carmine', 'Caglia', 'cc@idm.it', 'ccidm'),
(2, 'Antonino', 'Irrera', 'ai@idm.it', 'aiidm'),
(3, 'Giuseppe', 'Visconti', 'gv@idm.it', 'gvidm'),
(10, 'Salvatore', 'Mazza', 'sm@idm.it', 'smidm'),
(11, 'Sara', 'Brogin', 'sb@idm.it', 'sbidm'),
(12, 'Eleonora', 'Leuci', 'el@idm.it', 'elidm'),
(13, 'Marco', 'Velluso', 'mv@idm.it', 'mvidm'),
(14, 'Eugenio', 'Sgobba', 'es@idm.it', 'esidm'),
(15, 'Federico', 'Mascali', 'fm@idm.it', 'fmidm');

-- --------------------------------------------------------

--
-- Table structure for table `utente_ruolo`
--

CREATE TABLE `utente_ruolo` (
  `id_utente` int(11) NOT NULL,
  `id_ruolo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utente_ruolo`
--

INSERT INTO `utente_ruolo` (`id_utente`, `id_ruolo`) VALUES
(1, 1),
(2, 1),
(3, 1),
(10, 0),
(11, 0),
(12, 0),
(13, 0),
(14, 0),
(15, 0);

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
  `pesoTrainante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vagone`
--

INSERT INTO `vagone` (`id`, `tipologia`, `peso`, `lunghezza`, `colore`, `compagnia`, `costo`, `capienza`, `pesoTrainante`) VALUES
(1, 'C', 5000, 20, 'Rosso', 'Trenitalia', 1500, 500, 0),
(2, 'R', 4000, 15, 'Azzurro', 'Trenitalia', 2000, 20, 0),
(3, 'R', 3000, 75, 'Verde', 'Italo', 1550, 40, 0),
(4, 'H', 5500, 42, 'Verde', 'Trenitalia', 3000, 2, 40000),
(5, 'C', 5000, 50, 'Azzurro', 'Trenitalia', 2200, 600, 0),
(6, 'H', 4000, 20, 'Rosso', 'Italo', 1400, 2, 30000),
(7, 'P', 2000, 15, 'Rosso', 'Trenitalia', 1200, 60, 0),
(8, 'R', 3000, 12, 'Giallo', 'Italo', 1500, 15, 0),
(9, 'P', 4000, 30, 'Bianco', 'Italo', 1500, 30, 0),
(10, 'H', 2000, 10, 'Verde', 'Italo', 1900, 2, 15000),
(11, 'C', 4000, 35, 'Nero', 'Italo', 2500, 450, 0),
(12, 'P', 7000, 50, 'Verde', 'Trenitalia', 1900, 10, 0),
(13, 'R', 7000, 35, 'Bianco', 'Trenitalia', 1700, 10, 0),
(14, 'P', 5000, 40, 'Nero', 'Italo', 2000, 50, 0),
(15, 'H', 7000, 50, 'Verde', 'Trenitalia', 1900, 2, 50000),
(16, 'C', 7500, 50, 'Azzurro', 'Italo', 2000, 800, 0);

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
  ADD PRIMARY KEY (`idOrdine`),
  ADD KEY `fk_Ordine_Treno1_idx` (`treno`),
  ADD KEY `fk_Ordine_Utente1_idx` (`utente`);

--
-- Indexes for table `ruolo`
--
ALTER TABLE `ruolo`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `utente_ruolo`
--
ALTER TABLE `utente_ruolo`
  ADD KEY `id_utente` (`id_utente`),
  ADD KEY `id_ruolo` (`id_ruolo`);

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
  MODIFY `idOrdine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  ADD CONSTRAINT `fk_Ordine_Treno1` FOREIGN KEY (`treno`) REFERENCES `treno` (`idTreno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Ordine_Utente1` FOREIGN KEY (`utente`) REFERENCES `utente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `treno`
--
ALTER TABLE `treno`
  ADD CONSTRAINT `fk_Treno_Utente1` FOREIGN KEY (`utente`) REFERENCES `utente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `utente_ruolo`
--
ALTER TABLE `utente_ruolo`
  ADD CONSTRAINT `id_ruolo` FOREIGN KEY (`id_ruolo`) REFERENCES `ruolo` (`id`),
  ADD CONSTRAINT `id_utente` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
