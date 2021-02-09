package com.ARSproject.models;

public class Airport {
    private long id;
    private String name;
    private String code;
    private long idCity;

    public Airport(long id, String name, String code, long idCity) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.idCity = idCity;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getIdCity() {
        return idCity;
    }

    public void setIdCity(long idCity) {
        this.idCity = idCity;
    }
}
