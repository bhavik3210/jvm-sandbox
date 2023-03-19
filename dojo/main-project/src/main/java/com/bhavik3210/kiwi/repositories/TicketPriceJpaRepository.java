package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    How does Spring know, this is a repository without stereotype annotation @Repository?
    During compilation process, spring will take a look at instance if it is type of JpaRepository
    and tag it as a repository automatically.
 */
public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {
}