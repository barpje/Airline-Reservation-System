package com.ARSproject.models;

import java.sql.Timestamp;

public class Flight {
    private long id;
    private String code;
    private long idPlane;
    private long idStartAirport;
    private long idEndAirport;
    private Timestamp departureTime;
    private Timestamp arrivalTime;

    public Flight(long id, String code, long idPlane, long idStartAirport, long idEndAirport, Timestamp departureTime, Timestamp arrivalTime) {
        this.id = id;
        this.code = code;
        this.idPlane = idPlane;
        this.idStartAirport = idStartAirport;
        this.idEndAirport = idEndAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(long idPlane) {
        this.idPlane = idPlane;
    }

    public long getIdStartAirport() {
        return idStartAirport;
    }

    public void setIdStartAirport(long idStartAirport) {
        this.idStartAirport = idStartAirport;
    }

    public long getIdEndAirport() {
        return idEndAirport;
    }

    public void setIdEndAirport(long idEndAirport) {
        this.idEndAirport = idEndAirport;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

