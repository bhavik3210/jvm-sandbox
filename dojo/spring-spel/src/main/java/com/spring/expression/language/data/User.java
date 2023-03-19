package com.spring.expression.language.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Value("#{'JOHN DOE'}")
    private String name;

    @Value("#{100}")
    private int age;

    private String country;
    private String language;
    private String timezone;
    private boolean isOk;
    private char firstInitial;

    public User(
            @Value("#{systemProperties['user.country']}") String country,
            @Value("#{systemProperties['user.language']}") String language
    ) {
        this.country = country;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimezone() {
        return timezone;
    }

    @Value("#{systemProperties['user.timezone']}")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public boolean getIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public char getFirstInitial() {
        return firstInitial;
    }

    public void setFirstInitial(char firstInitial) {
        this.firstInitial = firstInitial;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", timezone='" + timezone + '\'' +
                ", isOk=" + isOk +
                ", firstInitial=" + firstInitial +
                '}';
    }
}
