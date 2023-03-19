package com.spring.jdbc.repository;

import com.spring.jdbc.model.Ride;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {

    @Override
    public List<Ride> getRides() {
        Ride ride = new Ride();
        ride.setName("Corner Canyon");
        ride.setDuration(120);
        List<Ride> rides = new ArrayList<>();
        rides.add(ride);
        return rides;
    }

}
