package com.ARSproject.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class InsertsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InsertsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCountry(String name) throws DataAccessException {

        String sql = "INSERT INTO panstwo(nazwa) VALUES(?)";
        try {
            jdbcTemplate.update(sql, name);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void addCity(String name, long idCountry) throws DataAccessException {

        String sql = "INSERT INTO miasto(nazwa, id_panstwo) VALUES(?, ?)";
        try {
            jdbcTemplate.update(sql, name, idCountry);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void addManufacturer(String name) throws DataAccessException {

        String sql = "INSERT INTO producent(nazwa) VALUES(?)";
        try {
            jdbcTemplate.update(sql, name);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void addModel(String name, int seatsNumber, long idManufacturer) throws DataAccessException {

        String sql = "INSERT INTO model(nazwa, liczba_miejsc, id_producent) VALUES(?, ?, ?)";
        try {
            jdbcTemplate.update(sql, name, seatsNumber, idManufacturer);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void addPlane(String register, long idModel, long idAirline) throws DataAccessException {

        String sql = "INSERT INTO samolot(rejestracja, id_model, id_linia) VALUES(?, ?, ?)";
        try {
            jdbcTemplate.update(sql, register, idModel, idAirline);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void addAirport(String name, String code, long idCity) throws DataAccessException {

        String sql = "INSERT INTO lotnisko(nazwa, kod_lotniska, id_miasto) VALUES(?, ?, ?)";
        try {
            jdbcTemplate.update(sql, name, code, idCity);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void addAirline(String name, long idCountry) throws DataAccessException {

        String sql = "INSERT INTO linia_lotnicza(nazwa, id_panstwo) VALUES(?, ?)";
        try {
            jdbcTemplate.update(sql, name, idCountry);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void addFlight(String code, long idPlane,
                          long idStartAirport, long idStopAirport,
                          Timestamp departureTime, Timestamp arrivalTime) throws DataAccessException {

        String sql = "INSERT INTO lot(kod_lotu, id_samolot, id_lotnisko_odlotu, id_lotnisko_przylotu, czas_odlotu, czas_przylotu) VALUES(?, ?, ? ,? , ?, ?)";
        try {
            jdbcTemplate.update(sql, code, idPlane, idStartAirport, idStopAirport, departureTime, arrivalTime);
        } catch (DataAccessException e) {
            throw e;
        }
    }
}
