package org.java.dojo;

public class Main {
    public static void main(String[] args) {

        /*
        if (args.length < 1) {
            System.out.println("No arguments provided");
        } else {
            for (String argument : args) {
                System.out.println(argument);
            }
        }
        */

        /*
        int a = 13;
        int b = 5;

        int wholeDivider = 13/5;
        int remainder = 13%5;

        int decimalValue = Integer.parseInt(remainder + "0")/b;

        System.out.println(wholeDivider + "." + decimalValue);
        */

        performCalculations();
    }

    static void performCalculations() {
        double[] leftValues = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightValues = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};

        MathEquation[] equations = new MathEquation[4];
        for (int i = 0; i < leftValues.length; i++) {
            equations[i] = new MathEquation(leftValues[i], rightValues[i], opCodes[i]);
            equations[i].execute();
        }

        for (MathEquation item : equations) {
            System.out.println(item.toString());
        }
    }
}   