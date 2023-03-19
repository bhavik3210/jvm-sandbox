package org.java.dojo.courses.gettingStartedUnitTestingWithJunit5;

public enum Doctor {
    avery("Ralph Avery"),
    johnson("Beth Johnson"),
    murphy("Pat Murpy");

    private String name;

    Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
