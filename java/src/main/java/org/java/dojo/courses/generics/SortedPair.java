package org.java.dojo.courses.generics;

/**
 * Type Bounds
 * public class SortedPair<T `extends Comparable`>
 * Compiler knows that any "type" that is passed in as a placement for T needs to have an interface comparable implemented.
 * See code for more details on why this was needed. i.e. `compareTo` method
 *
 * @param <T>: T is expected to have Comparable implemented and of type T, which means it can be compared to the same type of itself
 */
public class SortedPair<T extends Comparable<T>> {
    private final T first;
    private final T second;

    public SortedPair(T first, T second) {

        if (first.compareTo(second) < 0) {
            this.first = first;
            this.second = second;
        } else {
            this.first = second;
            this.second = first;
        }
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
