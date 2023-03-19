package com.spring.aop.model;

import java.util.List;

public class Flight {

    private String id;
    private String company;
    private List<Passenger> passengers;

    public Flight() {}

    public Flight(String id, String company, List<Passenger> passengers) {
        this.id = id;
        this.company = company;
        this.passengers = passengers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void print() {
        for(Passenger passenger: passengers) {
            System.out.println(passenger);
        }
    }
}
