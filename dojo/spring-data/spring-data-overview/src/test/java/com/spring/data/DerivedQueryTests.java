package com.spring.data;

import com.spring.data.model.Flight;
import com.spring.data.repository.FlightRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.spring.data.TestUtil.createFlight;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DerivedQueryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Before("")
    public void setup() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldFindFlightsFromLondon() {
        final Flight flight1 = createFlight("London", "Madrid");
        final Flight flight2 = createFlight("Chicago", "Madrid");
        final Flight flight3 = createFlight("New York", "Madrid");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flightsToLondon = flightRepository.findByOrigin("London");

        Assertions.assertThat(flightsToLondon).hasSize(1);
        Assertions.assertThat(flightsToLondon).first().isEqualTo(flight1);
    }
}
