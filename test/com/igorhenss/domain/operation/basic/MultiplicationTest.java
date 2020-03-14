package com.igorhenss.domain.operation.basic;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.MULTIPLICATION;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplicationTest {

    private static final Number X = NumberDatabuilder.X;
    
    private static final Number Y = NumberDatabuilder.Y;

    @Test
    void shouldOperateOnOrderXY() {
        Double resultXY = calculate(MULTIPLICATION, X, Y);

        assertEquals(X.getValue() * Y.getValue(), resultXY);
    }

    @Test
    void shouldOperateOnOrderYX_andReturnSameResultAsOrderXY() {
        Double resultYX = calculate(MULTIPLICATION, Y, X);
        Double resultXY = calculate(MULTIPLICATION, X, Y);

        assertEquals(Y.getValue() * X.getValue(), resultYX);
        assertEquals(resultXY, resultYX);
    }

    @Test
    void shouldResultOnX_whenOperatedWithIdentityElement() {
        Double resultXIdentityElement = calculate(MULTIPLICATION, X, MULTIPLICATION.getIdentityElement());

        assertEquals(X.getValue(), resultXIdentityElement);
    }

}