package com.spring.fundamentals.respository;

import com.spring.fundamentals.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<Speaker>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("John");
        speaker.setLastName("Doe");

        speakers.add(speaker);

        return speakers;
    }

}
