package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long> {
}
