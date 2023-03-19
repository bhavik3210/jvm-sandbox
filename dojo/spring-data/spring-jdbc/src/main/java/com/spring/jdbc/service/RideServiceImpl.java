package com.spring.jdbc.service;

import com.spring.jdbc.model.Ride;
import com.spring.jdbc.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rideService")
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Override
    public List<Ride> getRides() {
        return rideRepository.getRides();
    }
}
