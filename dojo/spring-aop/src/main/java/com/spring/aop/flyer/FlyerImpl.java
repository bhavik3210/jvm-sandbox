package com.spring.aop.flyer;

public class FlyerImpl implements Flyer {

    @Override
    public void takeOff() {
        System.out.println("Taking off");
    }

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void land() {
        System.out.println("Landing");
    }

}
