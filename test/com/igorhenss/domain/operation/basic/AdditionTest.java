package com.igorhenss.domain.operation.basic;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.ADDITION;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionTest {

    private static final Number X = NumberDatabuilder.X;

    private static final Number Y = NumberDatabuilder.Y;

    @Test
    void shouldOperateOnOrderXY() {
        Double resultXY = calculate(ADDITION, X, Y);

        assertEquals(X.getValue() + Y.getValue(), resultXY);
    }

    @Test
    void shouldOperateOnOrderYX_andReturnSameResultAsOrderXY() {
        Double resultYX = calculate(ADDITION, Y, X);
        Double resultXY = calculate(ADDITION, X, Y);

        assertEquals(Y.getValue() + X.getValue(), resultYX);
        assertEquals(resultXY, resultYX);
    }

    @Test
    void shouldResultOnX_whenOperatedWithIdentityElement() {
        Double resultXIdentityElement = calculate(ADDITION, X, ADDITION.getIdentityElement());

        assertEquals(X.getValue(), resultXIdentityElement);
    }

}