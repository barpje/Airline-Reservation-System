package com.ARSproject.DAO;

import com.ARSproject.exceptions.IncorrectCityException;
import com.ARSproject.exceptions.IncorrectFlightCodeException;
import com.ARSproject.wrappers.FlightInfoWrapper;
import com.ARSproject.wrappers.FlightWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FlightDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FlightWrapper> searchFlights(String startCity, String endCity) throws IncorrectCityException {
        String sql = "SELECT\n" +
                "  l.id_lot,\n" +
                "  l.kod_lotu,\n" +
                "  sl.nazwa as nazwa1,\n" +
                "  el.nazwa as nazwa2,\n" +
                "  l.czas_odlotu,\n" +
                "  l.czas_przylotu\n" +
                "\n" +
                "FROM\n" +
                "  lot  l\n" +
                "  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko\n" +
                "  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko\n" +
                "  JOIN miasto sc  ON sl.id_miasto = sc.id_miasto\n" +
                "  JOIN miasto ec  ON el.id_miasto = ec.id_miasto\n" +
                "  WHERE\n" +
                "\tsc.nazwa = ? AND ec.nazwa = ?\n" +
                "ORDER BY l.czas_odlotu;\n";

        try {
            return jdbcTemplate.query(
                    sql,
                    new Object[]{startCity, endCity},
                    (rs, rowNum) ->
                            new FlightWrapper(
                                    rs.getLong("id_lot"),
                                    rs.getString("kod_lotu"),
                                    rs.getString("nazwa1"),
                                    rs.getString("nazwa2"),
                                    rs.getTimestamp("czas_odlotu"),
                                    rs.getTimestamp("czas_przylotu")
                            )
            );
        } catch (DataAccessException e) {
            throw new IncorrectCityException();
        }
    }
    public List<FlightWrapper> searchFlightsFromCity(String startCity) throws IncorrectCityException {
        String sql = "SELECT\n" +
                "  l.id_lot,\n" +
                "  l.kod_lotu,\n" +
                "  sl.nazwa as nazwa1,\n" +
                "  el.nazwa as nazwa2,\n" +
                "  l.czas_odlotu,\n" +
                "  l.czas_przylotu\n" +
                "\n" +
                "FROM\n" +
                "  lot  l\n" +
                "  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko\n" +
                "  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko\n" +
                "  JOIN miasto sc  ON sl.id_miasto = sc.id_miasto\n" +
                "  JOIN miasto ec  ON el.id_miasto = ec.id_miasto\n" +
                "  WHERE\n" +
                "\tsc.nazwa = ?\n" +
                "ORDER BY nazwa2, l.czas_odlotu;\n";

        try {
            return jdbcTemplate.query(
                    sql,
                    new Object[]{startCity},
                    (rs, rowNum) ->
                            new FlightWrapper(
                                    rs.getLong("id_lot"),
                                    rs.getString("kod_lotu"),
                                    rs.getString("nazwa1"),
                                    rs.getString("nazwa2"),
                                    rs.getTimestamp("czas_odlotu"),
                                    rs.getTimestamp("czas_przylotu")
                            )
            );
        } catch (DataAccessException e) {
            throw new IncorrectCityException();
        }
    }


    public List<FlightInfoWrapper> searchFlightInfo(String code) throws IncorrectFlightCodeException {
        String sql = "SELECT\n" +
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
                "\tl.kod_lotu = ?\n" +
                "ORDER BY l.czas_odlotu;\n";

        try {
            return jdbcTemplate.query(
                    sql,
                    new Object[]{code},
                    (rs, rowNum) ->
                            new FlightInfoWrapper(
                                    rs.getString("nazwa1"),
                                    rs.getString("nazwa2"),
                                    rs.getTimestamp("czas_odlotu"),
                                    rs.getTimestamp("czas_przylotu"),
                                    rs.getString("nazwa4"),
                                    rs.getString("nazwa3"),
                                    rs.getInt("liczba_miejsc"),
                                    rs.getString("rejestracja"),
                                    rs.getString("nazwa5")
                            )
            );
        } catch (DataAccessException e) {
            throw new IncorrectFlightCodeException();
        }
    }
    public List<FlightInfoWrapper> searchFlightsByAirline(String airlineName) {
        String sql = "SELECT\n" +
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
                "ORDER BY l.czas_odlotu;\n";

        try {
            return jdbcTemplate.query(
                    sql,
                    new Object[]{airlineName},
                    (rs, rowNum) ->
                            new FlightInfoWrapper(
                                    rs.getString("nazwa1"),
                                    rs.getString("nazwa2"),
                                    rs.getTimestamp("czas_odlotu"),
                                    rs.getTimestamp("czas_przylotu"),
                                    rs.getString("nazwa4"),
                                    rs.getString("nazwa3"),
                                    rs.getInt("liczba_miejsc"),
                                    rs.getString("rejestracja"),
                                    rs.getString("nazwa5")
                            )
            );
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<FlightWrapper> showReturnFlights(long idFlight) {
        String sql = "SELECT\n" +
                "  l.id_lot,\n" +
                "  l.kod_lotu,\n" +
                "  sl.nazwa as nazwa1,\n" +
                "  el.nazwa as nazwa2,\n" +
                "  l.czas_odlotu,\n" +
                "  l.czas_przylotu\n" +
                "\n" +
                "FROM\n" +
                "  lot  l\n" +
                "  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko\n" +
                "  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko\n" +
                "  JOIN miasto sc  ON sl.id_miasto = sc.id_miasto\n" +
                "  JOIN miasto ec  ON el.id_miasto = ec.id_miasto\n" +
                "  WHERE\n" +
                "\tl.id_lotnisko_przylotu = (SELECT l1.id_lotnisko_odlotu FROM lot l1 WHERE l1.id_lot = ?) \n" +
                "    AND l.id_lotnisko_odlotu = (SELECT l1.id_lotnisko_przylotu FROM lot l1 WHERE l1.id_lot = ?) \n" +
                "    AND l.czas_odlotu > (SELECT l1.czas_przylotu FROM lot l1 WHERE l1.id_lot = ?)\n" +
                "\n" +
                "ORDER BY l.czas_odlotu;";

        try {
            return jdbcTemplate.query(
                    sql,
                    new Object[]{idFlight, idFlight, idFlight},
                    (rs, rowNum) ->
                            new FlightWrapper(
                                    rs.getLong("id_lot"),
                                    rs.getString("kod_lotu"),
                                    rs.getString("nazwa1"),
                                    rs.getString("nazwa2"),
                                    rs.getTimestamp("czas_odlotu"),
                                    rs.getTimestamp("czas_przylotu")
                            )
            );
        } catch (DataAccessException e) {
            return null;
        }
    }
}
