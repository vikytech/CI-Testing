package com.step.calc;

import java.math.BigInteger;

public class Calculator {
    private BigInteger result = BigInteger.valueOf(0);

    public void add(int number) {
        result = result.add(BigInteger.valueOf(number));
    }

    public BigInteger getResult() {
        return result;
    }

    public void subtract(int number) {
        result = result.subtract(BigInteger.valueOf(number));
    }

    public void multiply(int number) {
        result = result.multiply(BigInteger.valueOf(number));
    }

    public void divide(int number) {
        if (number == 0) {
            throw new RuntimeException("can't divide a number by zero :(");
         else {
            result = result.divide(BigInteger.valueOf(number));
        }
    }

}
