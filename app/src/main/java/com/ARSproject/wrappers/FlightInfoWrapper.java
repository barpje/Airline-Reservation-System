package com.ARSproject.wrappers;

import java.sql.Timestamp;

public class FlightInfoWrapper {
    private String startAirport;
    private String stopAirport;
    private String time;
    private String manufacturer;
    private String model;
    private String register;
    private String airline;
    private int seatsNumber;
    private Timestamp arrTime;

    public FlightInfoWrapper(String startAirport, String stopAirport, Timestamp arrTime, Timestamp depTime, String manufacturer, String model, int seatsNumber, String register, String airline) {
        this.startAirport = startAirport;
        this.stopAirport = stopAirport;
        this.manufacturer = manufacturer;
        this.model = model;
        this.arrTime = arrTime;
        this.register = register;
        this.airline = airline;
        this.seatsNumber = seatsNumber;
        this.time = calculateTime(depTime, arrTime);
    }

    private String calculateTime(Timestamp t1, Timestamp t2) {
        long milliseconds = t1.getTime() - t2.getTime();
        int seconds = (int) milliseconds / 1000;

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        return hours + ":" + minutes;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Timestamp getArrTime() {
        return arrTime;
    }

    public void setArrTime(Timestamp arrTime) {
        this.arrTime = arrTime;
    }
}
