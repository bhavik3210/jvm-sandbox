package org.java.dojo.courses.generics;

import java.util.Comparator;

/**
 * delegating work to a specific of the type comparator
 * Passing a Parameter to a Generic Type
 *
 * @param <T>
 */
public class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> delegateComparator;

    public ReverseComparator(Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    @Override
    public int compare(T obj1, T obj2) {
        return -1 * delegateComparator.compare(obj1, obj2);
    }
}
