package com.ARSproject.wrappers;

import java.sql.Timestamp;

public class ReservationWrapper {
    private long id;
    private String flight_code;
    private String startAirport;
    private String endAirport;
    private Timestamp departureTime;
    private String name;
    private String surname;
    private String status;
    private String travel_class;
    private Timestamp date;
    private long idFlight;

    public ReservationWrapper(long id, long idFlight, String flight_code, String startAirport, String endAirport, Timestamp departureTime, String name, String surname, String status, String travel_class, Timestamp date) {
        this.id = id;
        this.idFlight = idFlight;
        this.flight_code = flight_code;
        this.startAirport = startAirport;
        this.endAirport = endAirport;
        this.departureTime = departureTime;
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.travel_class = travel_class;
        this.date = date;
    }

    public long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(long idFlight) {
        this.idFlight = idFlight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(String flight_code) {
        this.flight_code = flight_code;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTravel_class() {
        return travel_class;
    }

    public void setTravel_class(String travel_class) {
        this.travel_class = travel_class;
    }
}
