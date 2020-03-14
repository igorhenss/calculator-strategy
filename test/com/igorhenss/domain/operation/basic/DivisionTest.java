package com.igorhenss.domain.operation.basic;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.DIVISION;
import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    private static final Number X = NumberDatabuilder.X;
    
    private static final Number Y = NumberDatabuilder.Y;

    @Test
    void shouldOperateOnOrderXY() {
        Double resultXY = calculate(DIVISION, X, Y);

        assertEquals(X.getValue() / Y.getValue(), resultXY);
    }

    @Test
    void shouldOperateOnOrderYX_andReturnDifferentResultAsOrderXY() {
        Double resultYX = calculate(DIVISION, Y, X);
        Double resultXY = calculate(DIVISION, X, Y);

        assertEquals(Y.getValue() / X.getValue(), resultYX);
        assertNotEquals(resultXY, resultYX);
    }

    @Test
    void shouldReturnFalse_whenHasIdentityElementIsCalled() {
        assertFalse(DIVISION.hasIdentityElement());
    }

    @Test
    void shouldThrowIllegalArgumentException_whenIdentityElementIsCalculated() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculate(DIVISION, X, DIVISION.getIdentityElement()));

        assertEquals("Number (e) must not be null", exception.getMessage());
    }

}