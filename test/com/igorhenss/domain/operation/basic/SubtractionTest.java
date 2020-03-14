package com.igorhenss.domain.operation.basic;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.SUBTRACTION;
import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {

    private static final Number X = NumberDatabuilder.X;
    
    private static final Number Y = NumberDatabuilder.Y;

    @Test
    void shouldOperateOnOrderXY() {
        Double resultXY = calculate(SUBTRACTION, X, Y);

        assertEquals(X.getValue() - Y.getValue(), resultXY);
    }

    @Test
    void shouldOperateOnOrderYX_andReturnDifferentResultAsOrderXY() {
        Double resultYX = calculate(SUBTRACTION, Y, X);
        Double resultXY = calculate(SUBTRACTION, X, Y);

        assertEquals(Y.getValue() - X.getValue(), resultYX);
        assertNotEquals(resultXY, resultYX);
    }

    @Test
    void shouldReturnFalse_whenHasIdentityElementIsCalled() {
        assertFalse(SUBTRACTION.hasIdentityElement());
    }

    @Test
    void shouldThrowIllegalArgumentException_whenIdentityElementIsCalculated() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculate(SUBTRACTION, X, SUBTRACTION.getIdentityElement()));

        assertEquals("Number (e) must not be null", exception.getMessage());
    }

}