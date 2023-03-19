package org.java.dojo.courses.java17.fundamentals;

public class Java17DemoApp {

    public static void main(String[] args) {
        System.out.println("Java 17 Fundamentals: Demo App");

        var product = new Product("Name", 12);
        System.out.println(product);


        for(int i =1; i<20; i++){
            System.out.println("- [] Section " + i);
        }
    }
}

record Product(String name, int value) {
}