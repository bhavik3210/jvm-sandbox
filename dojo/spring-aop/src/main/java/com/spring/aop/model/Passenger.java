package com.spring.aop.model;

public class Passenger {
    private String name;
    private String country;

    public Passenger(){}

    public Passenger(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
