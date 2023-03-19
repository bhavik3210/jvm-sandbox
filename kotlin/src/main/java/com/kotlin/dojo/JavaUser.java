package com.kotlin.dojo;

public class JavaUser {
    private String name;

    public JavaUser(String name) {
        this.name = name;
    }

    public void create(JavaCreated createdEvent) {
        createdEvent.onCreate(this);
    }

    @Override
    public String toString() {
        return "JavaUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
