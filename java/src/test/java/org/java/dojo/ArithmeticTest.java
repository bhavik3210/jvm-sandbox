package org.java.dojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticTest {

    @Test
    @DisplayName("test decimal value off of division and modulo operator")
    void testDecimalValue() {
        int a = 13;
        int b = 5;

        int wholeDivider = 13 / 5;
        int remainder = 13 % 5;

        int decimalValue = Integer.parseInt(remainder + "0") / b;

        String actualValue = wholeDivider + "." + decimalValue;
        String expectedValue = "2.6";

        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("test Prefix operation")
    void testPrefixOperator() {
//        System.out.println();
//        System.out.println("================= Prefix =================");

        int initialValue = 5;
//        System.out.println("initialValue: " + initialValue);
        int resultValue = ++initialValue; // initialValue was incremented by one and stored in original initialValue
//        System.out.println("OPERATION => \"++initialValue\" APPLIED");
//        System.out.println("resultValue: " + resultValue);
//        System.out.println("initialValue: " + initialValue);
        assertEquals(6, resultValue);
    }

    @Test
    @DisplayName("test Postfix operation")
    void testPostfixOperator() {
//        System.out.println();
//        System.out.println("================= Postfix =================");

        int initialValue = 5;
//        System.out.println("initialValue: " + initialValue);
         /*
            initialValue below was incremented by one and stored in original initialValue
            however in this case it was returned before the operation was applied
        */
        int resultValue = initialValue++;
//        System.out.println("OPERATION => \"initialValue++\" APPLIED");
//        System.out.println("resultValue: " + resultValue + " (This value was assigned before operation was applied due to how postfix operation works)");
//        System.out.println("initialValue: " + initialValue);
        assertEquals(5, resultValue);

        /**
         ::Additional Notes::
         Main thing to note in both Prefix and Postfix the original variable will be changed regardless of prefix or postfix.
         The ONLY difference is the behavior of the returned value.
         ++initialValue will return the value after applying the increment by one operation
         initialValue++ will return the value before applying the increment by one operation
         */
    }

    @Test
    @DisplayName("test compound assignment operator Addition")
    void testCompoundAssignmentOperatorAddition() {
        int value = 23;
        value += 2; // Equivalent to value = value + 2
        assertEquals(25, value);
    }


    @Test
    @DisplayName("test compound assignment operator Subtraction")
    void testCompoundAssignmentOperatorSubtraction() {
        int value = 23;
        value -= 2; // Equivalent to value = value - 2
        assertEquals(21, value);
    }


    @Test
    @DisplayName("test compound assignment operator Multiplication")
    void testCompoundAssignmentOperatorMultiplication() {
        int value = 23;
        value *= 2; // Equivalent to value = value * 2
        assertEquals(46, value);
    }

    @Test
    @DisplayName("test compound assignment operator Division")
    void testCompoundAssignmentOperatorDivision() {
        int value = 24;
        value /= 2; // Equivalent to value = value / 2
        assertEquals(12, value);
    }

    @Test
    @DisplayName("test compound assignment operator Modulo")
    void testCompoundAssignmentOperatorModulo() {
        int value = 23;
        value %= 2; // Equivalent to value = value % 2
        assertEquals(1, value);
    }

    @Test
    @DisplayName("test operator precedence")
    void testOperatorPrecedence() {
        int valA = 21;
        int valB = 6;
        int valC = 3;
        int valD = 1;
        int result1 = valA - valB / valC;
        assertEquals(19, result1);

        int result2 = (valA - valB) / valC;
        assertEquals(5, result2);

        int result3 = valA / valC * valD + valB;
        assertEquals(13, result3);

        int result4 = valA / (valC * (valD + valB));
        assertEquals(1, result4);
    }

    @Test
    @DisplayName("test type conversions")
    void testTypeConversions() {
        float floatVal = 1.0f;
        double doubleVal = 4.0;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 5;

        short result1 = byteVal;
        short result2 = (short) longVal; //have to do this explicitly because of narrow conversion
        short result3 = (short) (byteVal - longVal); //calculation performed as long but then long is coverted to short
        float result4 = longVal - floatVal; //float so we don't loose decimal point
    }
}
