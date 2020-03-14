package com.igorhenss.domain.operation.advanced;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.ROOT;
import static org.junit.jupiter.api.Assertions.*;

class RootTest {

    private static final Number X = NumberDatabuilder.X;

    private static final Number Y = NumberDatabuilder.Y;

    @Test
    void shouldOperateOnOrderXY() {
        Double resultXY = calculate(ROOT, X, Y);

        assertEquals(Math.pow(X.getValue(), 1 / Y.getValue()), resultXY);
    }

    @Test
    void shouldOperateOnOrderYX_andReturnDifferentResultAsOrderXY() {
        Double resultYX = calculate(ROOT, Y, X);
        Double resultXY = calculate(ROOT, X, Y);

        assertEquals(Math.pow(Y.getValue(), 1 / X.getValue()), resultYX);
        assertNotEquals(resultXY, resultYX);
    }

    @Test
    void shouldReturnFalse_whenHasIdentityElementIsCalled() {
        assertFalse(ROOT.hasIdentityElement());
    }

    @Test
    void shouldThrowIllegalArgumentException_whenIdentityElementIsCalculated() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculate(ROOT, X, ROOT.getIdentityElement()));

        assertEquals("Number (e) must not be null", exception.getMessage());
    }

}