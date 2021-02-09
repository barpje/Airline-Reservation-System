package com.ARSproject.models;

public class Passenger {
    private  long id;
    private String address;
    private long idCity;
    private long idAccount;
    private String name;
    private String surname;
    private String email;
    private String phone;

    public Passenger(long id, String address, long idCity, long idAccount, String name, String surname, String email, String phone) {
        this.id = id;
        this.address = address;
        this.idCity = idCity;
        this.idAccount = idAccount;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getIdCity() {
        return idCity;
    }

    public void setIdCity(long idCity) {
        this.idCity = idCity;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
