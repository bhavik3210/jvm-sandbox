package com.spring.data;

import com.spring.data.model.Flight;
import com.spring.data.repository.FlightRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.spring.data.TestUtil.createFlight;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomImplTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void shouldHaveCustomImpl() {
        final Flight toDelete = createFlight("London", "Tokyo");
        final Flight toKeep = createFlight("Paris", "Tokyo");

        flightRepository.save(toDelete);
        flightRepository.save(toKeep);
        var allFlights1 = flightRepository.findAll();

        flightRepository.deleteByOrigin(toDelete.getOrigin());

        var allFlights2 = flightRepository.findAll();

        Assertions.assertThat(flightRepository.findAll())
                .hasSize(1)
                .first()
                .isEqualTo(toKeep);
    }
}
