package org.java.dojo.courses.generics;

import java.util.LinkedList;
import java.util.List;

import static org.java.dojo.util.StringUtil.printLineSeparator;

public class DemoApp {
    public static void main(String[] args) {
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("John", 80));
        personList.add(new Person("Mark", 90));
        personList.add(new Person("Jane", 100));
        personList.add(new Person("Steph", 70));

        System.out.println(personList);
        printLineSeparator();

        personList.sort(new AgeComparator());
        System.out.println(personList);
        printLineSeparator();

        personList.sort(new ReverseComparator(new AgeComparator()));
        System.out.println(personList);
        printLineSeparator();
    }
}
