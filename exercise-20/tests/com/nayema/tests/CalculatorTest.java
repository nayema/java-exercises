package com.nayema.tests;

import com.nayema.Calculator;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CalculatorTest {
    @Test
    void itMultipliesTwoNumbers() {
        Calculator calculator = new Calculator();

        double product = calculator.multiply(2, 3);

        assertThat(product, is(equalTo(6.0)));
    }

    @Test
    void itDividesTwoNumbers() {
        Calculator calculator = new Calculator();

        double dividedAnswer = calculator.divide(6, 3);

        assertThat(dividedAnswer, is(equalTo(2.0)));
    }

    @Test
    void itExponentiatesBaseNumberWithExponentNumber() {
        Calculator calculator = new Calculator();

        double exponentiatedNumber = calculator.exponentiate(6, 3);

        assertThat(exponentiatedNumber, is(equalTo(216.0)));
    }
}