package com.ARSproject.models;

public class Model {
    private long id;
    private String name;
    private int seatsNumber;
    private long idManufacturer;

    public Model(long id, String name, int seatsNumber, long idManufacturer) {
        this.id = id;
        this.name = name;
        this.seatsNumber = seatsNumber;
        this.idManufacturer = idManufacturer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public long getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }
}