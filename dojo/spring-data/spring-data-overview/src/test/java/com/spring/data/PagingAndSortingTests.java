package com.spring.data;

import com.spring.data.model.Flight;
import com.spring.data.repository.FlightRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Iterator;

import static com.spring.data.TestUtil.createFlight;
import static org.springframework.data.domain.Sort.Direction.DESC;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PagingAndSortingTests {

    @Autowired
    private FlightRepository flightRepository;

    @Before("")
    public void setup() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldSortFlightByDestination() {
        final Flight madrid = createFlight("London", "Madrid");
        final Flight london = createFlight("London", "London");
        final Flight paris = createFlight("London", "Paris");

        flightRepository.save(madrid);
        flightRepository.save(london);
        flightRepository.save(paris);

        final Iterable<Flight> flights = flightRepository.findAll(Sort.by("destination"));

        Assertions.assertThat(flights).hasSize(3);

        final Iterator<Flight> iterator = flights.iterator();

        Assertions.assertThat(iterator.next().getDestination()).isEqualTo("London");
        Assertions.assertThat(iterator.next().getDestination()).isEqualTo("Madrid");
        Assertions.assertThat(iterator.next().getDestination()).isEqualTo("Paris");
    }

    @Test
    public void shouldSortFlightsByScheduledAndThenName() {
        final LocalDateTime now = LocalDateTime.now();
        final Flight paris1 = createFlight("Paris", now);
        final Flight paris2 = createFlight("Paris", now.plusHours(2));
        final Flight paris3 = createFlight("Paris", now.plusHours(1));
        final Flight london1 = createFlight("London", now.plusHours(1));
        final Flight london2 = createFlight("London", now);

        flightRepository.save(paris1);
        flightRepository.save(paris2);
        flightRepository.save(paris3);
        flightRepository.save(london1);
        flightRepository.save(london2);

        final Iterable<Flight> flights = flightRepository
                .findAll(Sort.by("destination", "scheduledAt"));

        Assertions.assertThat(flights).hasSize(5);

        final Iterator<Flight> iterator = flights.iterator();

        Assertions.assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(london2);
        Assertions.assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(london1);
        Assertions.assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris1);
        Assertions.assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris3);
        Assertions.assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris2);
    }

    @Test
    public void shouldPageResults() {
        for (int i = 0; i < 100; i++) {
            flightRepository.save(createFlight(String.valueOf(i), LocalDateTime.now()));
        }

        final Page<Flight> page = flightRepository.findAll(PageRequest.of(2, 5));

        Assertions.assertThat(page.getTotalElements()).isEqualTo(100);
        Assertions.assertThat(page.getNumberOfElements()).isEqualTo(5);
        Assertions.assertThat(page.getTotalPages()).isEqualTo(20);
        Assertions.assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("10", "11", "12", "13", "14");

    }


    @Test
    public void shouldPageAndSortDerivedQuery() {
        for (int i = 0; i < 10; i++) {
            final Flight flight = createFlight(String.valueOf(i), LocalDateTime.now());
            flight.setOrigin("Paris");
            flightRepository.save(flight);
        }

        for (int i = 0; i < 10; i++) {
            final Flight flight = createFlight(String.valueOf(i), LocalDateTime.now());
            flight.setOrigin("London");
            flightRepository.save(flight);
        }

        final Page<Flight> page = flightRepository.
                findByOrigin("London", PageRequest.of(0, 5, Sort.by(DESC, "destination")));

        Assertions.assertThat(page.getTotalElements()).isEqualTo(10);
        Assertions.assertThat(page.getNumberOfElements()).isEqualTo(5);
        Assertions.assertThat(page.getTotalPages()).isEqualTo(2);
        Assertions.assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("9", "8", "7", "6", "5");

    }
}
