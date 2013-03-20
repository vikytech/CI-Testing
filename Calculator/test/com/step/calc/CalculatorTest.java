package com.step.calc;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldAddGivenNumber() {
        calculator.add(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(1)));
    }

    @Test
    public void shouldAddTwoNumbers() {
        calculator.add(1);
        calculator.add(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(2)));
    }

    @Test
    public void shouldAddTwoMaximumIntegers() {
        calculator.add(Integer.MAX_VALUE);
        calculator.add(Integer.MAX_VALUE);
        long maxValue = Integer.MAX_VALUE;
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(maxValue * 2)));
    }

    @Test
    public void addingZeroShouldNotChangeTheResult() {
        calculator.add(1);
        calculator.add(0);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(1)));
    }

    @Test
    public void shouldAddNegativeNumber() {
        calculator.add(-1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(-1)));
    }

    @Test
    public void shouldAddTwoMinimumIntegers() {
        calculator.add(Integer.MIN_VALUE);
        calculator.add(Integer.MIN_VALUE);
        long expected = (long) Integer.MIN_VALUE * 2;
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(expected)));
    }

    @Test
    public void shouldSubtractNumber() {
        calculator.subtract(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(-1)));

    }

    @Test
    public void shouldSubtractTwoNumber() {
        calculator.subtract(1);
        calculator.subtract(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(-2)));
    }

    @Test
    public void shouldSubtractTwoMaximumIntegers() {
        calculator.subtract(Integer.MAX_VALUE);
        calculator.subtract(Integer.MAX_VALUE);
        long expected = (long) Integer.MIN_VALUE * 2 + 2;
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(expected)));
    }

    @Test
    public void shouldSubtractTwoMinimumIntegers() {
        calculator.subtract(Integer.MIN_VALUE);
        calculator.subtract(Integer.MIN_VALUE);
        long expected = (long) Integer.MAX_VALUE * 2 + 2;
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(expected)));
    }

    @Test
    public void addAndSubtractShouldNotChangeTheResult() {
        calculator.add(1);
        calculator.subtract(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(0)));
    }

    @Test
    public void shouldSubtractNumbers() {
        calculator.subtract(-34);
        calculator.subtract(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(33)));
    }

    @Test
    public void shouldSubtractTwoNegativeNumber() {
        calculator.subtract(-1);
        calculator.subtract(-1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(2)));
    }

    @Test
    public void shouldMultiplyGivenNumber() {
        calculator.multiply(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(0)));
    }

    @Test
    public void shouldMultiplyTwoGivenNumbers() {
        calculator.multiply(1);
        calculator.multiply(2);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(0)));
    }

    @Test
    public void shouldAddAndMultiplyGivenNumbers() {
        calculator.add(2);
        calculator.multiply(2);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(4)));
    }

    @Test
    public void shouldAddMultiplyAndSubtractGivenNumbers() {
        calculator.add(1);
        calculator.multiply(2);
        calculator.subtract(1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(1)));
    }

    @Test
    public void shouldAddMultiplyAndSubtractGivenNegativeNumbers() {
        calculator.add(-1);
        calculator.multiply(2);
        calculator.subtract(-1);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(-1)));
    }

    @Test
    public void shouldAddAndMultiplyMaximumNumbers() {
        calculator.add(Integer.MAX_VALUE);
        calculator.multiply(Integer.MAX_VALUE);
        BigInteger maxValue = BigInteger.valueOf((long) Integer.MAX_VALUE * Integer.MAX_VALUE);
        assertThat(calculator.getResult(), equalTo(maxValue));
    }

    @Test
    public void shouldAddAndMultiply3MaximumNumbers() {
        calculator.add(Integer.MAX_VALUE);
        calculator.multiply(Integer.MAX_VALUE);
        calculator.multiply(Integer.MAX_VALUE);
//        long maxValue = (long) Integer.MAX_VALUE * Integer.MAX_VALUE * Integer.MAX_VALUE;
        BigInteger expected = BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.valueOf(Integer.MAX_VALUE)));
        assertThat(calculator.getResult(), equalTo(expected));
    }

    @Test
    public void shouldDivideGivenNumber() {
        calculator.divide(2);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(0)));
    }

    @Test
    public void shouldDivideTwoNumbers() {
        calculator.add(12);
        calculator.divide(2);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(6)));
    }

    @Test
    public void shouldAddAndDivideTwoNumbers() {
        calculator.add(12);
        calculator.divide(2);
        calculator.divide(2);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(3)));
    }

    @Test
    public void shouldAddSubtractMultiplyAndDivideGivenNumbers() {
        calculator.add(12);
        calculator.subtract(2);
        calculator.divide(2);
        calculator.add(5);
        calculator.multiply(10);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(100)));
    }

    @Test
    public void shouldAddSubtractMultiplyAndDivideGivenNegativeNumbers() {
        calculator.add(12);
        calculator.subtract(2);
        calculator.divide(2);
        calculator.add(-5);
        calculator.multiply(10);
        assertThat(calculator.getResult(), equalTo(BigInteger.valueOf(0)));
    }

    @Test(expected = RuntimeException.class)
    public void shouldAddMultiplyAndDivideGivenNumbers() {
        calculator.add(2);
        calculator.multiply(0);
        calculator.divide(0);
    }
}