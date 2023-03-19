package org.java.dojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopingTest {


    @Test
    @DisplayName("test while loop (factorial example)")
    void testWhileLoop() {
        int someValue = 4;
        int result = 1;

        while (someValue > 1) {
            result *= someValue;
            someValue--;
        }

        assertEquals(24, result);
    }

    @Test
    @DisplayName("test do while loops")
    void testSDoWhileLoops() {
        int iVal = 5;
        do {
            System.out.print(iVal);
            System.out.print(" * 2 = ");
            iVal *= 2;
            System.out.println(iVal);
        } while (iVal < 25);

        assertEquals(40, iVal);

        iVal = 50;
        do {
            System.out.print(iVal);
            System.out.print(" * 2 = ");
            iVal *= 2;
            System.out.println(iVal);
        } while (iVal < 25);
        assertEquals(100, iVal);
    }

    @Test
    @DisplayName("test arrays and parallel arrays")
    void testParallelArrays() {
        double[] leftVals = {100.0, 25.0, 34.0, 32.0};
        double[] rightVals = {10.0, 5.0, 3.0, 2.0};
        char[] opcodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opcodes.length];

        for (int i = 0; i < opcodes.length; i++) {
            results[i] = TestUtil.calculateOperation(opcodes[i], leftVals[i], rightVals[i]);
        }

        double[] expectedResult = {10.0, 30.0, 31.0, 64.0};
        assertArrayEquals(expectedResult, results);
    }

    @Test
    @DisplayName("test for each loop")
    void testForEachLoop() {
        double[] leftVals = {100.0, 25.0, 34.0, 32.0};
        double[] rightVals = {10.0, 5.0, 3.0, 2.0};
        char[] opcodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opcodes.length];

        for (int i = 0; i < opcodes.length; i++) {
            results[i] = TestUtil.calculateOperation(opcodes[i], leftVals[i], rightVals[i]);
        }

        for (double value : results) {
            System.out.println(value + ",");
        }
    }
}
