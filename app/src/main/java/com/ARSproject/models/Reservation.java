package com.ARSproject.models;

import java.sql.Timestamp;

public class Reservation {
    private long id;
    private String status;
    private Timestamp date;
    private long idAccount;

    public Reservation(long id, String status, Timestamp date, long idAccount) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.idAccount = idAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }
}
