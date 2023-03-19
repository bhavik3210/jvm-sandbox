package com.spring.data;

import com.spring.data.model.Flight;
import com.spring.data.repository.FlightRepository;
import com.spring.data.service.FlightsService;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionalTests {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightsService flightsService;

    @Before("")
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldNotRollBackWhenTheresNoTransaction() {
        try {
            flightsService.saveFlight(new Flight());
        } catch (Exception e) {
            // Do nothing
        } finally {
            Assertions.assertThat(flightRepository.findAll())
                    .isNotEmpty();
        }
    }

    @Test
    public void shouldNotRollBackWhenTheresIsATransaction() {
        try {
            flightsService.saveFlightTransactional(new Flight());
        } catch (Exception e) {
            // Do nothing
        } finally {
            Assertions.assertThat(flightRepository.findAll())
                    .isNotEmpty();
        }
    }

}