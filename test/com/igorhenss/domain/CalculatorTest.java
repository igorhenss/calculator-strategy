package com.igorhenss.domain;

import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.ADDITION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private static final Number X = NumberDatabuilder.X;

    private static final Number Y = NumberDatabuilder.Y;

    private Number noValueNumber = Number.of("NoValueNumber", null);

    @Test
    void shouldCalculate_whenBothNumbersAreValid() {
        Double result = calculate(ADDITION, X, Y);

        assertEquals(X.getValue() + Y.getValue(), result);
    }

    @Test
    void shouldThrowException_whenCalculateFirstNumberIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculate(ADDITION, noValueNumber, X));

        assertEquals("Number (NoValueNumber) must not be null", exception.getMessage());
    }

    @Test
    void shouldThrowException_whenCalculateSecondNumberIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculate(ADDITION, X, noValueNumber));

        assertEquals("Number (NoValueNumber) must not be null", exception.getMessage());
    }

}