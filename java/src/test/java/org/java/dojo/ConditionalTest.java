package org.java.dojo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConditionalTest {

    @Test
    @DisplayName("test ternary operator")
    void testTernaryOperator() {
        int value1 = 7;
        int value2 = 5;
        int maxValue = value1 > value2 ? value1 : value2;
        assertEquals(7, maxValue);
    }

    @Test
    @DisplayName("test if statement")
    void testIfElseStatement() {
        int value = 2;
        if (value < 3) {
            value = 3;
        } else {
            value = 2;
        }

        assertEquals(3, value);
    }

    @Test
    @DisplayName("test logical operators")
    void testLogicalOperators() {
        // test for when this cannot be divided by 0 and use of &
        assertThrows(ArithmeticException.class, () -> {
            int studentsB = 150;
            int roomsB = 0;
            boolean resultB = false;
            if (roomsB > 0 & studentsB / roomsB > 30) {
                resultB = true;
            }
        });


        int students = 150, rooms = 4;
        boolean result = false;
        if (rooms > 0 && students / rooms > 30)
            result = true;
        assertEquals(true, result);
    }

    @Test

    @DisplayName("test multiple if else statements")
    void testMultipleIfElseStatement() {
        double value1 = 100.0d;
        double value2 = 50.0;
        double result = 0.0;
        char opCode = 'd';

        if (opCode == 'a') {
            result = value1 + value2;
        } else if (opCode == 's') {
            result = value1 - value2;
        } else if (opCode == 'm') {
            result = value1 * value2;
        } else if (opCode == 'd') {
            if (value2 != 0) {
                result = value1 / value2;
            }
        } else {
            result = 0.0;
        }

        assertEquals(2.0, result);
    }

    @Test
    @DisplayName("test switch statement")
    void testSwitchStatement() {
        double value1 = 100.0d;
        double value2 = 50.0;
        double result = 0.0;
        char opCode = 'd';

        switch (opCode) {
            case 'a':
                result = value1 + value2;
                break;
            case 's':
                result = value1 - value2;
                break;
            case 'm':
                result = value1 * value2;
                break;
            case 'd':
                result = value2 != 0 ? value1 / value2 : 0.0;
                break;
            default:
                result = 0.0;
                break;
        }

        assertEquals(2.0, result);
    }
}
