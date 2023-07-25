-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 25, 2023 at 04:02 PM
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
-- Constraints for dumped tables
--

--
-- Constraints for table `composizione`
--
ALTER TABLE `composizione`
  ADD CONSTRAINT `fk_Composizione_Treno1` FOREIGN KEY (`treno`) REFERENCES `treno` (`idTreno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Composizione_Vagone1` FOREIGN KEY (`vagone`) REFERENCES `vagone` (`idVagone`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
