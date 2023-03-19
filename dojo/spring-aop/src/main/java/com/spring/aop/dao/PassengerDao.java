package com.spring.aop.dao;

import com.spring.aop.model.Passenger;

public interface PassengerDao {
    Passenger getPassenger(int id);

    void insert(Passenger passenger);
}
