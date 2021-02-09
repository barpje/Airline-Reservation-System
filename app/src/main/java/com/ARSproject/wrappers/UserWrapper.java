package com.ARSproject.wrappers;

public class UserWrapper {
    private long id;
    private String email;
    private String name;
    private String surname;
    private int numberOfReservations;

    public UserWrapper(long id, String email, String name, String surname, int numberOfReservations) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.numberOfReservations = numberOfReservations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }
}