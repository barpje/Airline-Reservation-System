CREATE TABLE panstwo (
 	id_panstwo SERIAL NOT NULL,
	nazwa VARCHAR NOT NULL,
	PRIMARY KEY (id_panstwo)
);

CREATE TABLE linia_lotnicza (
	id_linia SERIAL NOT NULL,
	nazwa VARCHAR NOT NULL,
	id_panstwo INTEGER NOT NULL,
	PRIMARY KEY(id_linia),
	FOREIGN KEY(id_panstwo)
	REFERENCES panstwo(id_panstwo)
   );

CREATE TABLE producent(
	id_producent SERIAL NOT NULL,
	nazwa VARCHAR NOT NULL,
	PRIMARY KEY(id_producent)
   );

CREATE TABLE model(
	id_model SERIAL NOT NULL,
	nazwa VARCHAR(70) NOT NULL,
	liczba_miejsc INTEGER NOT NULL,
	id_producent INTEGER NOT NULL,
	PRIMARY KEY(id_model),
	FOREIGN KEY(id_producent)
	REFERENCES producent(id_producent)
   );

CREATE TABLE samolot(
	id_samolot SERIAL NOT NULL,
	rejestracja VARCHAR(30) NOT NULL,
	id_model INTEGER NOT NULL,
	id_linia INTEGER NOT NULL,
	PRIMARY KEY(id_samolot),
	FOREIGN KEY(id_linia)
	REFERENCES linia_lotnicza(id_linia),
	FOREIGN KEY(id_model)
	REFERENCES model(id_model)
   );

CREATE TABLE miasto(
 	id_miasto SERIAL NOT NULL,
	nazwa VARCHAR NOT NULL,
	id_panstwo INTEGER NOT NULL,
	PRIMARY KEY (id_miasto),
	FOREIGN KEY(id_panstwo)
	REFERENCES panstwo(id_panstwo)
);

CREATE TABLE lotnisko(
 	id_lotnisko SERIAL NOT NULL,
	nazwa VARCHAR NOT NULL,
	kod_lotniska VARCHAR(3) NOT NULL,
	id_miasto INTEGER NOT NULL,
	PRIMARY KEY (id_lotnisko),
	FOREIGN KEY(id_miasto)
	REFERENCES miasto(id_miasto)
);

CREATE TABLE lot(
 	id_lot SERIAL NOT NULL,
	kod_lotu VARCHAR(20) NOT NULL,
	id_samolot INTEGER NOT NULL,
	id_lotnisko_odlotu INTEGER NOT NULL,
	id_lotnisko_przylotu INTEGER NOT NULL,
	czas_odlotu TIMESTAMP NOT NULL,
	czas_przylotu TIMESTAMP NOT NULL,
	PRIMARY KEY (id_lot),
	FOREIGN KEY(id_lotnisko_odlotu)
	REFERENCES lotnisko(id_lotnisko),
	FOREIGN KEY(id_lotnisko_przylotu)
	REFERENCES lotnisko(id_lotnisko),
	FOREIGN KEY(id_samolot)
	REFERENCES samolot(id_samolot)

);

CREATE TABLE konto(
 	id_konto SERIAL NOT NULL,
	email VARCHAR(40) NOT NULL,
	haslo VARCHAR(65) NOT NULL,
	rola VARCHAR(20) NOT NULL DEFAULT 'user',
	PRIMARY KEY (id_konto)
);

CREATE TABLE rezerwacja(
 	id_rezerwacja SERIAL NOT NULL,
	status VARCHAR(70) NOT NULL,
	data TIMESTAMP NOT NULL,
	id_konto INTEGER NOT NULL,
	PRIMARY KEY (id_rezerwacja),
	FOREIGN KEY(id_konto)
	REFERENCES konto(id_konto)

);

CREATE TABLE bilet(
 	id_bilet SERIAL NOT NULL,
	klasa_podrozy VARCHAR(30) NOT NULL,
	id_lot INTEGER NOT NULL,
	id_rezerwacja INTEGER NOT NULL,
	PRIMARY KEY (id_bilet),
	FOREIGN KEY(id_rezerwacja)
	REFERENCES rezerwacja(id_rezerwacja),
	FOREIGN KEY(id_lot)
	REFERENCES lot(id_lot)
);

CREATE TABLE pasazer(
 	id_pasazer SERIAL NOT NULL,
	adres VARCHAR(200) NOT NULL,
	id_miasto INTEGER NOT NULL,
	id_konto INTEGER NOT NULL,
	imie VARCHAR(50) NOT NULL,
	nazwisko VARCHAR(50) NOT NULL,
	email VARCHAR(40) NOT NULL,
	numer_telefonu VARCHAR(15) NOT NULL,
	PRIMARY KEY (id_pasazer),
	FOREIGN KEY(id_konto)
	REFERENCES konto(id_konto),
	FOREIGN KEY(id_miasto)
	REFERENCES miasto(id_miasto)
);







