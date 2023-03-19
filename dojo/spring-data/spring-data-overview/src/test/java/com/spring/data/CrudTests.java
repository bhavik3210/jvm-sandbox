package com.spring.data;

import com.spring.data.model.Flight;
import com.spring.data.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CrudTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void shouldPerformCRUDOperations() {
        final Flight flight = new Flight();
        flight.setOrigin("London");
        flight.setDestination("New York");
        flight.setScheduledAt(LocalDateTime.parse("2043-12-13T12:12:00"));

        flightRepository.save(flight);

        assertThat(flightRepository.findAll())
                .hasSize(1)
                .first()
                .isEqualTo(flight);

        flightRepository.deleteById(flight.getId());

        assertThat(flightRepository.count()).isZero();
    }

}
