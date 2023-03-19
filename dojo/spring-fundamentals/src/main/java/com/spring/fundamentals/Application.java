package com.spring.fundamentals;

import com.spring.fundamentals.service.SpeakerService;
import com.spring.fundamentals.service.SpeakerServiceImpl;

public class Application {
    public static void main(String[] args) {
        SpeakerService service = new SpeakerServiceImpl();

        System.out.println(service.findAll().get(0).getFirstName());
    }
}