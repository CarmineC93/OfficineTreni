-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 21, 2023 alle 14:41
-- Versione del server: 10.4.11-MariaDB
-- Versione PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
-- Struttura della tabella `cargo`
--

CREATE TABLE `cargo` (
  `idVagone` int(11) NOT NULL,
  `scopo` varchar(45) DEFAULT NULL,
  `spazio` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `cargo`
--

INSERT INTO `cargo` (`idVagone`, `scopo`, `spazio`) VALUES
(1, 'Posta', 5000),
(5, 'Frigo', 5000),
(11, 'Frigo', 7000),
(16, 'Merce', 4000);

-- --------------------------------------------------------

--
-- Struttura della tabella `composizione`
--

CREATE TABLE `composizione` (
  `treno` int(11) NOT NULL,
  `vagone` int(11) NOT NULL,
  `posizione` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `composizione`
--

INSERT INTO `composizione` (`treno`, `vagone`, `posizione`) VALUES
(1, 4, 1),
(1, 7, 2),
(1, 7, 3),
(1, 7, 4),
(1, 7, 5),
(1, 7, 6),
(1, 12, 7),
(1, 12, 8),
(1, 12, 9),
(2, 6, 1),
(2, 11, 2),
(2, 11, 3),
(2, 11, 4),
(2, 11, 5),
(3, 4, 1),
(3, 7, 2),
(3, 7, 3),
(3, 12, 4),
(3, 13, 5),
(3, 12, 6),
(3, 7, 7),
(3, 7, 8),
(4, 10, 1),
(4, 11, 2),
(4, 16, 3),
(4, 11, 4),
(4, 16, 5),
(4, 11, 6),
(4, 16, 7),
(4, 11, 8),
(4, 16, 9);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `datitreno`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `datitreno` (
`idTreno` int(11)
,`pesoTotale` double
,`lunghezzaTotale` double
,`costoComplessivo` double
);

-- --------------------------------------------------------

--
-- Struttura della tabella `locomotiva`
--

CREATE TABLE `locomotiva` (
  `idVagone` int(11) NOT NULL,
  `pesoTrainante` double NOT NULL,
  `numTecnici` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `locomotiva`
--

INSERT INTO `locomotiva` (`idVagone`, `pesoTrainante`, `numTecnici`) VALUES
(4, 40000, 2),
(6, 20000, 2),
(10, 50000, 3),
(15, 10000, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
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
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordine` (`idOrdine`, `treno`, `utente`, `data`, `stato`, `pagamento`, `importo`) VALUES
(1, 4, 10, '2023-07-19', 'Ordinato', 'Effettuato', 19900),
(2, 1, 12, '2023-07-16', 'Costruzione', 'Effettuato', 13500),
(3, 3, 11, '2022-12-26', 'Consegnato', 'Effettuato', 13300);

-- --------------------------------------------------------

--
-- Struttura della tabella `passeggeri`
--

CREATE TABLE `passeggeri` (
  `idVagone` int(11) NOT NULL,
  `postiDisponibili` int(11) DEFAULT NULL,
  `prezzoPosto` double DEFAULT NULL,
  `cuccetteDisponibili` int(11) DEFAULT NULL,
  `prezzoCuccetta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `passeggeri`
--

INSERT INTO `passeggeri` (`idVagone`, `postiDisponibili`, `prezzoPosto`, `cuccetteDisponibili`, `prezzoCuccetta`) VALUES
(7, 55, 40, 0, 0),
(9, 40, 59, 3, 100),
(12, 25, 69, 4, 120),
(14, 65, 70, 0, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `ristorante`
--

CREATE TABLE `ristorante` (
  `idVagone` int(11) NOT NULL,
  `tavoli` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `ristorante`
--

INSERT INTO `ristorante` (`idVagone`, `tavoli`) VALUES
(2, 12),
(3, 15),
(8, 20),
(13, 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `ruolo`
--

CREATE TABLE `ruolo` (
  `idRuolo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `ruolo`
--

INSERT INTO `ruolo` (`idRuolo`, `nome`) VALUES
(0, 'user'),
(1, 'admin');

-- --------------------------------------------------------

--
-- Struttura della tabella `treno`
--

CREATE TABLE `treno` (
  `idTreno` int(11) NOT NULL,
  `utente` int(11) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `compagnia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `treno`
--

INSERT INTO `treno` (`idTreno`, `utente`, `sigla`, `nome`, `compagnia`) VALUES
(1, 3, 'HPPPPPPP', 'Cittanotte', 'TrenItalia'),
(2, 1, 'HCCCC', 'Freezer', 'Italo'),
(3, 2, 'HPPPRPPP', 'VIP Party', 'TrenItalia'),
(4, 10, 'HCCCCCCCC', 'Trainsport', 'Italo');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `idUtente` int(11) NOT NULL,
  `ruolo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(135) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`idUtente`, `ruolo`, `nome`, `cognome`, `email`, `password`) VALUES
(1, 1, 'Carmine', 'Caglia', 'cc@idm.it', 'ccidm'),
(2, 1, 'Antonino', 'Irrera', 'ai@idm.it', 'aiidm'),
(3, 1, 'Giuseppe', 'Visconti', 'gv@idm.it', 'gvidm'),
(10, 0, 'Salvatore', 'Mazza', 'sm@idm.it', 'smidm'),
(11, 0, 'Sara', 'Brogin', 'sb@idm.it', 'sbidm'),
(12, 0, 'Eleonora', 'Leuci', 'el@idm.it', 'elidm'),
(13, 0, 'Marco', 'Velluso', 'mv@idm.it', 'mvidm'),
(14, 0, 'Eugenio', 'Sgobba', 'es@idm.it', 'esidm'),
(15, 0, 'Federico', 'Mascali', 'fm@idm.it', 'fmidm');

-- --------------------------------------------------------

--
-- Struttura della tabella `vagone`
--

CREATE TABLE `vagone` (
  `idVagone` int(11) NOT NULL,
  `peso` float NOT NULL,
  `lunghezza` float NOT NULL,
  `colore` varchar(45) DEFAULT NULL,
  `compagnia` varchar(45) DEFAULT NULL,
  `costo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `vagone`
--

INSERT INTO `vagone` (`idVagone`, `peso`, `lunghezza`, `colore`, `compagnia`, `costo`) VALUES
(1, 5000, 20, 'Rosso', 'Trenitalia', 1500),
(2, 4000, 15, 'Azzurro', 'Trenitalia', 2000),
(3, 3000, 75, 'Verde', 'Italo', 1550),
(4, 5500, 42, 'Verde', 'Trenitalia', 3000),
(5, 5000, 50, 'Azzurro', 'Trenitalia', 2200),
(6, 4000, 20, 'Rosso', 'Italo', 1400),
(7, 2000, 15, 'Rosso', 'Trenitalia', 1200),
(8, 3000, 12, 'Giallo', 'Italo', 1500),
(9, 4000, 30, 'Bianco', 'Italo', 1500),
(10, 2000, 10, 'Verde', 'Italo', 1900),
(11, 4000, 35, 'Nero', 'Italo', 2500),
(12, 7000, 50, 'Verde', 'Trenitalia', 1900),
(13, 7000, 35, 'Bianco', 'Trenitalia', 1700),
(14, 5000, 40, 'Nero', 'Italo', 2000),
(15, 7000, 50, 'Verde', 'Trenitalia', 1900),
(16, 7500, 50, 'Azzurro', 'Italo', 2000);

-- --------------------------------------------------------

--
-- Struttura per vista `datitreno`
--
DROP TABLE IF EXISTS `datitreno`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `datitreno`  AS  select `treno`.`idTreno` AS `idTreno`,sum(`vagone`.`peso`) AS `pesoTotale`,sum(`vagone`.`lunghezza`) AS `lunghezzaTotale`,sum(`vagone`.`costo`) AS `costoComplessivo` from ((`treno` left join `composizione` on(`composizione`.`treno` = `treno`.`idTreno`)) left join `vagone` on(`composizione`.`vagone` = `vagone`.`idVagone`)) group by `treno`.`idTreno` ;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idVagone`),
  ADD KEY `fk_Cargo_Vagone1_idx` (`idVagone`);

--
-- Indici per le tabelle `composizione`
--
ALTER TABLE `composizione`
  ADD KEY `fk_Composizione_Treno1_idx` (`treno`),
  ADD KEY `fk_Composizione_Vagone1_idx` (`vagone`);

--
-- Indici per le tabelle `locomotiva`
--
ALTER TABLE `locomotiva`
  ADD PRIMARY KEY (`idVagone`),
  ADD KEY `fk_Locomotiva_Vagone1_idx` (`idVagone`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`idOrdine`),
  ADD KEY `fk_Ordine_Treno1_idx` (`treno`),
  ADD KEY `fk_Ordine_Utente1_idx` (`utente`);

--
-- Indici per le tabelle `passeggeri`
--
ALTER TABLE `passeggeri`
  ADD PRIMARY KEY (`idVagone`),
  ADD KEY `fk_Passeggeri_Vagone1_idx` (`idVagone`);

--
-- Indici per le tabelle `ristorante`
--
ALTER TABLE `ristorante`
  ADD PRIMARY KEY (`idVagone`),
  ADD KEY `fk_Ristorante_Vagone1_idx` (`idVagone`);

--
-- Indici per le tabelle `ruolo`
--
ALTER TABLE `ruolo`
  ADD PRIMARY KEY (`idRuolo`);

--
-- Indici per le tabelle `treno`
--
ALTER TABLE `treno`
  ADD PRIMARY KEY (`idTreno`,`utente`),
  ADD KEY `fk_Treno_Utente1_idx` (`utente`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`idUtente`,`ruolo`),
  ADD KEY `fk_Utente_Ruolo1_idx` (`ruolo`);

--
-- Indici per le tabelle `vagone`
--
ALTER TABLE `vagone`
  ADD PRIMARY KEY (`idVagone`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `idOrdine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `treno`
--
ALTER TABLE `treno`
  MODIFY `idTreno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `idUtente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT per la tabella `vagone`
--
ALTER TABLE `vagone`
  MODIFY `idVagone` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `cargo`
--
ALTER TABLE `cargo`
  ADD CONSTRAINT `fk_Cargo_Vagone1` FOREIGN KEY (`idVagone`) REFERENCES `vagone` (`idVagone`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `composizione`
--
ALTER TABLE `composizione`
  ADD CONSTRAINT `fk_Composizione_Treno1` FOREIGN KEY (`treno`) REFERENCES `treno` (`idTreno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Composizione_Vagone1` FOREIGN KEY (`vagone`) REFERENCES `vagone` (`idVagone`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `locomotiva`
--
ALTER TABLE `locomotiva`
  ADD CONSTRAINT `fk_Locomotiva_Vagone1` FOREIGN KEY (`idVagone`) REFERENCES `vagone` (`idVagone`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `fk_Ordine_Treno1` FOREIGN KEY (`treno`) REFERENCES `treno` (`idTreno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Ordine_Utente1` FOREIGN KEY (`utente`) REFERENCES `utente` (`idUtente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `passeggeri`
--
ALTER TABLE `passeggeri`
  ADD CONSTRAINT `fk_Passeggeri_Vagone1` FOREIGN KEY (`idVagone`) REFERENCES `vagone` (`idVagone`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ristorante`
--
ALTER TABLE `ristorante`
  ADD CONSTRAINT `fk_Ristorante_Vagone1` FOREIGN KEY (`idVagone`) REFERENCES `vagone` (`idVagone`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `treno`
--
ALTER TABLE `treno`
  ADD CONSTRAINT `fk_Treno_Utente1` FOREIGN KEY (`utente`) REFERENCES `utente` (`idUtente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `utente`
--
ALTER TABLE `utente`
  ADD CONSTRAINT `fk_Utente_Ruolo1` FOREIGN KEY (`ruolo`) REFERENCES `ruolo` (`idRuolo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
