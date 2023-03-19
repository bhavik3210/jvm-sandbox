package org.java.dojo;

public class TestUtil {
    static double calculateOperation(char opCode, double leftVal, double rightVal) {
        double result = 0.0;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0;
                break;
            default:
                result = 0.0;
                break;
        }
        return result;
    }

    static String learningStrings() {
        return "";
    }
}
