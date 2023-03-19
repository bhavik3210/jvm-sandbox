package com.spring.fundamentals.service;

import com.spring.fundamentals.model.Speaker;
import com.spring.fundamentals.respository.HibernateSpeakerRepositoryImpl;
import com.spring.fundamentals.respository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService{

    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
