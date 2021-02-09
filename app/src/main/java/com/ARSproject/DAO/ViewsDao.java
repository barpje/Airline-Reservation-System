package com.ARSproject.DAO;

import com.ARSproject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViewsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ViewsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> showTableCountry() {

        String sql = "SELECT * FROM panstwo";

        try {
            List<Country> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Country(
                                    rs.getLong("id_panstwo"),
                                    rs.getString("nazwa")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<City> showTableCity() {

        String sql = "SELECT * FROM miasto";

        try {
            List<City> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new City(
                                    rs.getLong("id_miasto"),
                                    rs.getString("nazwa"),
                                    rs.getLong("id_panstwo")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Plane> showTablePlane() {

        String sql = "SELECT * FROM samolot";

        try {
            List<Plane> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Plane(
                                    rs.getLong("id_samolot"),
                                    rs.getString("rejestracja"),
                                    rs.getLong("id_model"),
                                    rs.getLong("id_linia")

                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Model> showTableModel() {

        String sql = "SELECT * FROM model";

        try {
            List<Model> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Model(
                                    rs.getLong("id_model"),
                                    rs.getString("nazwa"),
                                    rs.getInt("liczba_miejsc"),
                                    rs.getLong("id_producent")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Manufacturer> showTableManufacturer() {

        String sql = "SELECT * FROM producent";

        try {
            List<Manufacturer> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Manufacturer(
                                    rs.getLong("id_producent"),
                                    rs.getString("nazwa")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Flight> showTableFlight() {

        String sql = "SELECT * FROM lot";

        try {
            List<Flight> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Flight(
                                    rs.getLong("id_lot"),
                                    rs.getString("kod_lotu"),
                                    rs.getLong("id_samolot"),
                                    rs.getLong("id_lotnisko_odlotu"),
                                    rs.getLong("id_lotnisko_przylotu"),
                                    rs.getTimestamp("czas_odlotu"),
                                    rs.getTimestamp("czas_przylotu")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Airport> showTableAirport() {

        String sql = "SELECT * FROM lotnisko";

        try {
            List<Airport> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Airport(
                                    rs.getLong("id_lotnisko"),
                                    rs.getString("nazwa"),
                                    rs.getString("kod_lotniska"),
                                    rs.getLong("id_miasto")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Airline> showTableAirline() {

        String sql = "SELECT * FROM linia_lotnicza";

        try {
            List<Airline> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Airline(
                                    rs.getLong("id_linia"),
                                    rs.getString("nazwa"),
                                    rs.getLong("id_panstwo")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Account> showTableAccount() {

        String sql = "SELECT * FROM konto";

        try {
            List<Account> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Account(
                                    rs.getLong("id_konto"),
                                    rs.getString("email"),
                                    rs.getString("haslo"),
                                    rs.getString("rola")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Ticket> showTableTicket() {

        String sql = "SELECT * FROM bilet";

        try {
            List<Ticket> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Ticket(
                                    rs.getLong("id_bilet"),
                                    rs.getString("klasa_podrozy"),
                                    rs.getLong("id_lot"),
                                    rs.getLong("id_rezerwacja")

                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Reservation> showTableReservation() {

        String sql = "SELECT * FROM rezerwacja";

        try {
            List<Reservation> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Reservation(
                                    rs.getLong("id_rezerwacja"),
                                    rs.getString("status"),
                                    rs.getTimestamp("data"),
                                    rs.getLong("id_konto")
                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public List<Passenger> showTablePassenger() {

        String sql = "SELECT * FROM pasazer";

        try {
            List<Passenger> elements = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new Passenger(
                                    rs.getLong("id_pasazer"),
                                    rs.getString("adres"),
                                    rs.getLong("id_miasto"),
                                    rs.getLong("id_konto"),
                                    rs.getString("imie"),
                                    rs.getString("nazwisko"),
                                    rs.getString("email"),
                                    rs.getString("numer_telefonu")


                            )
            );
            return elements;
        } catch (DataAccessException e) {
            throw e;
        }
    }
}
