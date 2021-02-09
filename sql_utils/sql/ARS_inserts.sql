--dodanie admina user: admin@admin.pl pass: DB1arsPROJECT2021
insert into konto (email, haslo, rola) VALUES ('admin@admin.pl', '$2a$04$9Lo2tHkRBINombePrPxFW.ilTnbyV1/6CkAeAHM.MSijaqkpT1nJe','admin');

--service
set idle_in_transaction_session_timeout to '1000';

--producent
INSERT INTO producent (nazwa) VALUES ('Boeing');
INSERT INTO producent (nazwa) VALUES ('Airbus');

-- model
    -- Boeing
    INSERT INTO model (nazwa, liczba_miejsc, id_producent) VALUES ('737 MAX', 162, 1);
INSERT INTO model (nazwa, liczba_miejsc, id_producent) VALUES ('Boeing 787-8 Dreamliner', 288, 1);
INSERT INTO model (nazwa, liczba_miejsc, id_producent) VALUES ('777-200ER', 263, 1);

    
    -- Airbus
INSERT INTO model (nazwa, liczba_miejsc, id_producent) VALUES ('A320', 132, 2);
INSERT INTO model (nazwa, liczba_miejsc, id_producent) VALUES ('A350', 302, 2);
INSERT INTO model (nazwa, liczba_miejsc, id_producent) VALUES ('A330-200', 235, 2);



-- panstwo
INSERT INTO panstwo (nazwa) VALUES ('Holandia');
INSERT INTO panstwo (nazwa) VALUES ('Polska');
INSERT INTO panstwo (nazwa) VALUES ('Wielka Brytania');
INSERT INTO panstwo (nazwa) VALUES ('Niemcy');
INSERT INTO panstwo (nazwa) VALUES ('Singapur');
INSERT INTO panstwo (nazwa) VALUES ('Stany Zjednoczone');

--linie lotnicze 

INSERT INTO linia_lotnicza (nazwa, id_panstwo) VALUES ('LOT', 2);
INSERT INTO linia_lotnicza (nazwa, id_panstwo) VALUES ('British Airways', 3);
INSERT INTO linia_lotnicza (nazwa, id_panstwo) VALUES ('Lufthansa', 4);
INSERT INTO linia_lotnicza (nazwa, id_panstwo) VALUES ('Singapore', 5);
INSERT INTO linia_lotnicza (nazwa, id_panstwo) VALUES ('American Airlines', 6);
INSERT INTO linia_lotnicza (nazwa, id_panstwo) VALUES ('KLM', 1);


--samoloty
--LOT
 INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('SP-LRC', 2, 1);
 INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('SP-LRD', 2, 1);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('SP-LRE', 2, 1);

--British
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('G-EUUB', 4, 2);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('G-EUUD', 5, 2);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('G-EUUC', 4, 2);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('G-EUUH', 5, 2);

--Lufthansa
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('D-AIXD', 4, 3);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('D-AIXF', 3, 3);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('D-AIXA', 5, 3);

--Singapore
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('9V-SGD', 5, 4);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('9V-SGB', 5, 4);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('9V-SGF', 2, 4);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('9V-SGP', 2, 4);

--American
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('N717AN', 1, 5);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('N718AN', 2, 5);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('N719AN', 1, 5);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('N711AN', 2, 5);

--KLM
 INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('PH-EXC', 6, 6);
 INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('PH-EXY', 3, 6);
INSERT INTO samolot (rejestracja, id_model, id_linia) VALUES ('PH-EXZ', 6, 6);


-- miasto
INSERT INTO miasto (nazwa, id_panstwo) VALUES ('Warszawa', 2);
INSERT INTO miasto (nazwa, id_panstwo) VALUES ('Londyn', 3);
INSERT INTO miasto (nazwa, id_panstwo) VALUES ('Frankfurt', 4);
INSERT INTO miasto (nazwa, id_panstwo) VALUES ('Singapur', 5);
INSERT INTO miasto (nazwa, id_panstwo) VALUES ('Los Angeles', 6);
INSERT INTO miasto (nazwa, id_panstwo) VALUES ('Amsterdam', 1);


--lotniska
INSERT INTO lotnisko (nazwa, kod_lotniska, id_miasto) VALUES ('Warsaw Chopin Airport', 'WAW', 1);
INSERT INTO lotnisko (nazwa, kod_lotniska, id_miasto) VALUES ('London Heathrow Airport', 'LHR', 2);
INSERT INTO lotnisko (nazwa, kod_lotniska, id_miasto) VALUES ('Frankfurt Airport', 'FRA', 3);
INSERT INTO lotnisko (nazwa, kod_lotniska, id_miasto) VALUES ('Singapore Changi Airport', 'SIN', 4);
INSERT INTO lotnisko (nazwa, kod_lotniska, id_miasto) VALUES ('Los Angeles International Airport', 'LAX', 5);
INSERT INTO lotnisko (nazwa, kod_lotniska, id_miasto) VALUES ('Amsterdam Airport Schiphol', 'AMS', 6);

--loty
INSERT INTO lot (kod_lotu, id_samolot, id_lotnisko_odlotu, id_lotnisko_przylotu, czas_odlotu, czas_przylotu) VALUES ('LO9', 3, 1, 5, '2021-12-25 12:00:00', '2021-12-26 2:25:00');
INSERT INTO lot (kod_lotu, id_samolot, id_lotnisko_odlotu, id_lotnisko_przylotu, czas_odlotu, czas_przylotu) VALUES ('LH669', 9, 3, 2, '2022-03-12 12:09:22', '2022-02-12 23:45:09');
INSERT INTO lot (kod_lotu, id_samolot, id_lotnisko_odlotu, id_lotnisko_przylotu, czas_odlotu, czas_przylotu) VALUES ('LO9', 3, 1, 5, '2021-08-25 12:00:00', '2021-08-26 2:25:00');
INSERT INTO lot (kod_lotu, id_samolot, id_lotnisko_odlotu, id_lotnisko_przylotu, czas_odlotu, czas_przylotu) VALUES ('LO9', 3, 1, 5, '2021-07-12 12:00:00', '2021-07-13 2:25:00');
INSERT INTO lot (kod_lotu, id_samolot, id_lotnisko_odlotu, id_lotnisko_przylotu, czas_odlotu, czas_przylotu) VALUES ('LO9', 3, 1, 5, '2021-08-22 12:00:00', '2021-08-23 2:25:00');
INSERT INTO lot (kod_lotu, id_samolot, id_lotnisko_odlotu, id_lotnisko_przylotu, czas_odlotu, czas_przylotu) VALUES ('DP455', 15, 1, 4, '2021-08-25 12:00:00', '2021-08-26 2:25:00');



