package com.igorhenss.domain.operation.advanced;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.REMAINDER;
import static org.junit.jupiter.api.Assertions.*;

class RemainderTest {

    private static final Number X = NumberDatabuilder.X;

    private static final Number Y = NumberDatabuilder.Y;

    @Test
    void shouldOperateOnOrderXY() {
        Double resultXY = calculate(REMAINDER, X, Y);

        assertEquals(X.getValue() % Y.getValue(), resultXY);
    }

    @Test
    void shouldOperateOnOrderYX_andReturnDifferentResultAsOrderXY() {
        Double resultYX = calculate(REMAINDER, Y, X);
        Double resultXY = calculate(REMAINDER, X, Y);

        assertEquals(Y.getValue() % X.getValue(), resultYX);
        assertNotEquals(resultXY, resultYX);
    }

    @Test
    void shouldReturnFalse_whenHasIdentityElementIsCalled() {
        assertFalse(REMAINDER.hasIdentityElement());
    }

    @Test
    void shouldThrowIllegalArgumentException_whenIdentityElementIsCalculated() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculate(REMAINDER, X, REMAINDER.getIdentityElement()));

        assertEquals("Number (e) must not be null", exception.getMessage());
    }

}