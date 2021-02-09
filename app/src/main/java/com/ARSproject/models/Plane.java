package com.ARSproject.models;

public class Plane {
    private long id;
    private String register;
    private long idModel;
    private long idAirline;

    public Plane(long id, String register, long idModel, long idAirline) {
        this.id = id;
        this.register = register;
        this.idModel = idModel;
        this.idAirline = idAirline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public long getIdModel() {
        return idModel;
    }

    public void setIdModel(long idModel) {
        this.idModel = idModel;
    }

    public long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(long idAirline) {
        this.idAirline = idAirline;
    }
}
