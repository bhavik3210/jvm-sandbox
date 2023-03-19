package org.java.dojo.courses.generics;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedPairTest {

    @Test
    @DisplayName("test sorted pair when left and right are already sorted")
    void testSortedPair() {
        SortedPair<Integer> pair = new SortedPair<>(1, 2);

        assertEquals(1, pair.getFirst());
        assertEquals(2, pair.getSecond());
    }

    @Test
    @DisplayName("test sorted pair when left and right are already sorted")
    void testUnsortedPair() {
        SortedPair<Integer> pair = new SortedPair<>(2, 1);

        assertEquals(1, pair.getFirst());
        assertEquals(2, pair.getSecond());
    }


}
