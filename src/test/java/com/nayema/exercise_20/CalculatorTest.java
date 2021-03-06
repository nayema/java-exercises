package com.nayema.exercise_20;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("Unit")
class CalculatorTest {

    @Test
    public void itMultipliesTwoNumbers() {
        Calculator calculator = new Calculator();

        double product = calculator.multiply(2, 3);

        assertThat(product, is(equalTo(6.0)));
    }

    @Test
    public void itDividesTwoNumbers() {
        Calculator calculator = new Calculator();

        double quotient = calculator.divide(6, 3);

        assertThat(quotient, is(equalTo(2.0)));
    }

    @Test
    public void itExponentiatesBaseNumberWithExponentNumber() {
        Calculator calculator = new Calculator();

        double exponentiatedNumber = calculator.exponentiate(6, 3);

        assertThat(exponentiatedNumber, is(equalTo(216.0)));
    }
}