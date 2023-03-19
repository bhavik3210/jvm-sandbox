package com.spring.fundamentals.service;

import com.spring.fundamentals.model.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> findAll();
}
