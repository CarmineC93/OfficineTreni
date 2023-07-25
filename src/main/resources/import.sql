-- Creazione tabella "utente" e inserimento dati
CREATE TABLE utente (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  cognome VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL
);

INSERT INTO utente (email, nome, cognome, password) VALUES ('pino@email.it', 'Pino', 'Rossi', '{noop}gino123');
INSERT INTO utente (email, nome, cognome, password) VALUES ('pluto@email.it', 'Pluto', 'Plutino', '{noop}pluto123');

-- Creazione tabella "ruolo" e inserimento dati
CREATE TABLE ruolo (
  id INT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

INSERT INTO ruolo (id, nome) VALUES (1, 'ADMIN');
INSERT INTO ruolo (id, nome) VALUES (2, 'USER');

-- Creazione tabella "utente_ruolo" e inserimento dati
CREATE TABLE utente_ruolo (
  id_utente INT NOT NULL,
  id_ruolo INT NOT NULL,
  PRIMARY KEY (id_utente, id_ruolo),
  FOREIGN KEY (id_utente) REFERENCES utente (id),
  FOREIGN KEY (id_ruolo) REFERENCES ruolo (id)
);

INSERT INTO utente_ruolo (id_utente, id_ruolo) VALUES (1, 1);
INSERT INTO utente_ruolo (id_utente, id_ruolo) VALUES (2, 2);

