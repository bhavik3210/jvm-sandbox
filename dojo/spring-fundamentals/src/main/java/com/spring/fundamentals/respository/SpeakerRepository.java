package com.spring.fundamentals.respository;

import com.spring.fundamentals.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
