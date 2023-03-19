package org.java.dojo;

class MathEquation {
    private final double leftVal;
    private final double rightVal;
    private final char opCode;
    private final char opCodeSymbol;
    private double result;

    MathEquation(double leftVal, double rightVal, char opCode) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.opCode = opCode;
        try {
            this.opCodeSymbol = getOpCodeSymbol(opCode);
        } catch (InvalidOpCodeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    void execute() {
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
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0;
                break;
        }
    }

    private char getOpCodeSymbol(char opCode) throws InvalidOpCodeException {
        switch (opCode) {
            case 'd':
                return '/';
            case 's':
                return '-';
            case 'a':
                return '+';
            case 'm':
                return 'x';
            default:
                throw new InvalidOpCodeException("Invalid Op Code! Please provide one of the followings: 'd' 's' 'a' 'm' ");
        }
    }

    public double getLeftVal() {
        return leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(leftVal);
        stringBuilder.append(" ");
        stringBuilder.append(opCodeSymbol);
        stringBuilder.append(" ");
        stringBuilder.append(rightVal);
        stringBuilder.append(" = ");
        stringBuilder.append(result);
        return stringBuilder.toString();
    }
}