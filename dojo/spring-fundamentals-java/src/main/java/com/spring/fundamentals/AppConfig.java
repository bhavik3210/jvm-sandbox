package com.spring.fundamentals;

import com.spring.fundamentals.respository.HibernateSpeakerRepositoryImpl;
import com.spring.fundamentals.respository.SpeakerRepository;
import com.spring.fundamentals.service.SpeakerService;
import com.spring.fundamentals.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        SpeakerServiceImpl service = new SpeakerServiceImpl();
        service.setRepository(getSpeakerRepository());
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }
}
