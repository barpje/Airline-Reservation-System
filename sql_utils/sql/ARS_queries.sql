
--loty z danego do danego miasta

SELECT
  l.id_lot,
  l.kod_lotu,
  sl.nazwa as nazwa1,
  el.nazwa as nazwa2,
  l.czas_odlotu,
  l.czas_przylotu

FROM
  lot  l
  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko
  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko
  JOIN miasto sc  ON sl.id_miasto = sc.id_miasto
  JOIN miasto ec  ON el.id_miasto = ec.id_miasto
  WHERE
	sc.nazwa = 'Warszawa' AND ec.nazwa = 'Los Angeles'
ORDER BY l.czas_odlotu;

--loty z danego miasta
SELECT
  l.id_lot,
  l.kod_lotu,
  sl.nazwa as nazwa1,
  el.nazwa as nazwa2,
  l.czas_odlotu,
  l.czas_przylotu

FROM
  lot  l
  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko
  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko
  JOIN miasto sc  ON sl.id_miasto = sc.id_miasto
  JOIN miasto ec  ON el.id_miasto = ec.id_miasto
  WHERE
	sc.nazwa = 'Warszawa'
ORDER BY nazwa2, l.czas_odlotu;


--informacje o locie o podanym kodzie

SELECT
  sl.nazwa as nazwa1,
  el.nazwa as nazwa2,
  l.czas_odlotu,
  l.czas_przylotu,
  s.rejestracja,
  m.liczba_miejsc,
  m.nazwa,
  p.nazwa,
  ll.nazwa

FROM
  lot  l
  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko
  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko
  JOIN samolot s  ON l.id_samolot = s.id_samolot 
  JOIN linia_lotnicza ll ON s.id_linia = ll.id_linia
  JOIN model m  ON s.id_model = m.id_model
  JOIN producent p ON m.id_producent = p.id_producent
  WHERE
	l.kod_lotu = 'LO9'
ORDER BY l.czas_odlotu;

--uzytkownik
SELECT k.id, k.email, k.haslo from konto k WHERE k.email = ? AND k.haslo =?;

--rezerwacje
SELECT
  r.id_rezerwacja,
  l.kod_lotu,
  sl.nazwa as nazwaSA,
  el.nazwa as nazwaEA,
  l.czas_odlotu,
  p.imie,
  p.nazwisko,
  r.status,
  b.klasa_podrozy

FROM
  konto k
  JOIN pasazer p ON p.id_konto = k.id_konto
  JOIN rezerwacja r ON r.id_konto = k.id_konto
  JOIN bilet b ON b.id_rezerwacja = r.id_rezerwacja
  JOIN lot l ON l.id_lot = b.id_lot
  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko
  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko
  WHERE
	k.email = ?
ORDER BY l.czas_odlotu;

--funkcja usuwajaca uzytkownika i jego dane
CREATE OR REPLACE FUNCTION usun_uzytkownika_i_dane(id INTEGER) RETURNS VOID AS
$$
BEGIN
	DELETE 
	FROM 
      	bilet b WHERE b.id_rezerwacja IN (SELECT r.id_rezerwacja FROM rezerwacja r WHERE r.id_konto = id);
	DELETE 
	FROM 
      	rezerwacja r
	WHERE 
      	r.id_konto = id;
	DELETE 
	FROM 
      	pasazer p
	WHERE 
      	p.id_konto = id;
	DELETE 
	FROM 
      	konto k
	WHERE 
      	k.id_konto = id;

END;
$$ LANGUAGE plpgsql;
--polecenie listujace uzytnikow i liczbe ich rezerwacji
SELECT
  k.id_konto,
  k.email,
  p.imie,
  p.nazwisko,
  COUNT (DISTINCT r.id_rezerwacja) AS liczba_rezerwacji

--loty powrotne
FROM
  konto k
  LEFT JOIN pasazer p ON k.id_konto = p.id_konto
  LEFT JOIN rezerwacja r ON r.id_konto = k.id_konto
  WHERE k.rola = 'user'
  GROUP BY p.nazwisko, k.id_konto,p.imie
  ORDER BY p.nazwisko;

SELECT
  l.id_lot,
  l.kod_lotu,
  sl.nazwa as nazwa1,
  el.nazwa as nazwa2,
  l.czas_odlotu,
  l.czas_przylotu

FROM
  lot  l
  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko
  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko
  JOIN miasto sc  ON sl.id_miasto = sc.id_miasto
  JOIN miasto ec  ON el.id_miasto = ec.id_miasto
  WHERE
	l.id_lotnisko_przylotu = (SELECT l1.id_lotnisko_odlotu FROM lot l1 WHERE l1.id_lot = ?) 
    AND l.id_lotnisko_odlotu = (SELECT l1.id_lotnisko_przylotu FROM lot l1 WHERE l1.id_lot = ?) 
    AND l.czas_odlotu > (SELECT l1.czas_przylotu FROM lot l1 WHERE l1.id_lot = ?)

ORDER BY l.czas_odlotu;

SELECT\n" +
        "  sl.nazwa as nazwa1,\n" +
        "  el.nazwa as nazwa2,\n" +
        "  l.czas_odlotu,\n" +
        "  l.czas_przylotu,\n" +
        "  s.rejestracja,\n" +
        "  m.liczba_miejsc,\n" +
        "  m.nazwa as nazwa3,\n" +
        "  p.nazwa as nazwa4,\n" +
        "  ll.nazwa as nazwa5\n" +
        "\n" +
        "FROM\n" +
        "  lot  l\n" +
        "  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko\n" +
        "  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko\n" +
        "  JOIN samolot s  ON l.id_samolot = s.id_samolot \n" +
        "  JOIN linia_lotnicza ll ON s.id_linia = ll.id_linia\n" +
        "  JOIN model m  ON s.id_model = m.id_model\n" +
        "  JOIN producent p ON m.id_producent = p.id_producent\n" +
        "  WHERE\n" +
        "\tll.nazwa = ?\n" +
        "ORDER BY l.czas_odlotu;\n

SELECT\n" +
        "  k.id_konto,\n" +
        "  k.email,\n" +
        "  p.imie,\n" +
        "  p.nazwisko,\n" +
        "  COUNT (DISTINCT r.id_rezerwacja) AS liczba_rezerwacji\n" +
        "\n" +
        "FROM\n" +
        "  konto k\n" +
        "  LEFT JOIN pasazer p ON k.id_konto = p.id_konto\n" +
        "  LEFT JOIN rezerwacja r ON r.id_konto = k.id_konto\n" +
        "  WHERE k.rola = 'user'\n" +
        "  GROUP BY p.nazwisko, k.id_konto,p.imie\n" +
        "  ORDER BY p.nazwisko;




