package com.ARSproject.models;

public class City {
    private long id;
    private String name;
    private long idCountry;

    public City(long id, String name, long idCountry) {
        this.id = id;
        this.name = name;
        this.idCountry = idCountry;
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

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }
}
