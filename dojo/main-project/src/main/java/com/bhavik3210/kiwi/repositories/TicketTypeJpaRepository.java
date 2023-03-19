package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType, String> {
}
