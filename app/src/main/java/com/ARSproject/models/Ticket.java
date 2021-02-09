package com.ARSproject.models;

public class Ticket {
    private  long id;
    private String travelClass;
    private long idFlight;
    private long idReservation;

    public Ticket(long id, String travelClass, long idFlight, long idReservation) {
        this.id = id;
        this.travelClass = travelClass;
        this.idFlight = idFlight;
        this.idReservation = idReservation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(long idFlight) {
        this.idFlight = idFlight;
    }

    public long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }
}
