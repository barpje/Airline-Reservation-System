package com.ARSproject.wrappers;

import java.sql.Timestamp;

public class FlightWrapper {
    private long id;
    private String code;
    private String startAirport;
    private String stopAirport;
    private Timestamp depTime;
    private Timestamp arrTime;

    public FlightWrapper(long id, String code, String startAirport, String stopAirport, Timestamp depTime, Timestamp arrTime) {
        this.id = id;
        this.code = code;
        this.startAirport = startAirport;
        this.stopAirport = stopAirport;
        this.depTime = depTime;
        this.arrTime = arrTime;
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

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getStopAirport() {
        return stopAirport;
    }

    public void setStopAirport(String stopAirport) {
        this.stopAirport = stopAirport;
    }

    public Timestamp getDepTime() {
        return depTime;
    }

    public void setDepTime(Timestamp depTime) {
        this.depTime = depTime;
    }

    public Timestamp getArrTime() {
        return arrTime;
    }

    public void setArrTime(Timestamp arrTime) {
        this.arrTime = arrTime;
    }
}