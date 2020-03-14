package com.igorhenss.domain.operation.advanced;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.PERCENTAGE;
import static org.junit.jupiter.api.Assertions.*;

class PercentageTest {

    private static final Number X = NumberDatabuilder.X;

    private static final Number Y = NumberDatabuilder.Y;

    @Test
    void shouldOperateOnOrderXY() {
        Double resultXY = calculate(PERCENTAGE, X, Y);

        assertEquals(X.getValue() * 100 / Y.getValue(), resultXY);
    }

    @Test
    void shouldOperateOnOrderYX_andReturnDifferentResultAsOrderXY() {
        Double resultYX = calculate(PERCENTAGE, Y, X);
        Double resultXY = calculate(PERCENTAGE, X, Y);

        assertEquals(Y.getValue() * 100 / X.getValue(), resultYX);
        assertNotEquals(resultXY, resultYX);
    }

    @Test
    void shouldReturnFalse_whenHasIdentityElementIsCalled() {
        assertFalse(PERCENTAGE.hasIdentityElement());
    }

    @Test
    void shouldThrowIllegalArgumentException_whenIdentityElementIsCalculated() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculate(PERCENTAGE, X, PERCENTAGE.getIdentityElement()));

        assertEquals("Number (e) must not be null", exception.getMessage());
    }

}