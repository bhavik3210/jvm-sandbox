package org.java.dojo.courses.generics;

import java.util.Comparator;

/**
 * Implementing Generic Type Comparator
 */
public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(final Person left, final Person right) {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
