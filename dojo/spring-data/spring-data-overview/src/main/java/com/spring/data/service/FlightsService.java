package com.spring.data.service;

import com.spring.data.model.Flight;
import com.spring.data.repository.FlightRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FlightsService {
    private final FlightRepository flightRepository;

    public FlightsService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
        // some other queries and method calls here maybe
        throw new RuntimeException("I failed");
    }

    @Transactional
    public void saveFlightTransactional(Flight flight) {
        flightRepository.save(flight);
        // some other queries and method calls here maybe
        throw new RuntimeException("I failed");
    }
}
