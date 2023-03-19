package com.spring.aop.model;

public class Ticket {

    private String number;
    private Passenger passenger;

    public Ticket(){}

    public Ticket(String number, Passenger passenger) {
        this.number = number;
        this.passenger = passenger;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String emittingCountry() {
        return passenger.getCountry();
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "number='" + number + '\'' +
                ", passenger=" + passenger +
                '}';
    }
}
