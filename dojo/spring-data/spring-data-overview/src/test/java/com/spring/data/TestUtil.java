package com.spring.data;

import com.spring.data.model.Flight;

import java.time.LocalDateTime;

public class TestUtil {

    public static Flight createFlight(String origin, String destination) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduledAt(LocalDateTime.parse("2044-12-13T12:12:00"));
        return flight;
    }

    public static Flight createFlight(String destination, LocalDateTime scheduledAt) {
        Flight flight = new Flight();
        flight.setDestination(destination);
        flight.setOrigin("London");
        flight.setScheduledAt(scheduledAt);
        return flight;
    }
}
