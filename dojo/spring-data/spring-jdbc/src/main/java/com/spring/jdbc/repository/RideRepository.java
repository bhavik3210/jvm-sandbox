package com.spring.jdbc.repository;

import com.spring.jdbc.model.Ride;

import java.util.List;

public interface RideRepository {

    List<Ride> getRides();

}