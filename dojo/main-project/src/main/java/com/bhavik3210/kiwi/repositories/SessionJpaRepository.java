package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long> {
    List<Session> findBySessionNameContains(String name);
}
