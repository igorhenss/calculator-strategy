package com.igorhenss.domain.operation.advanced;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.Operation;

import static java.lang.Math.pow;

public class Root implements Operation {

    public static final Number IDENTITY_ELEMENT = Number.of("e", null);

    @Override
    public Double operate(Double x, Double y) {
        double result = pow(x, 1 / y);
        validateRoundness(result);
        return result;
    }

    @Override
    public Boolean hasIdentityElement() {
        return IDENTITY_ELEMENT.hasValue();
    }

    @Override
    public Number getIdentityElement() {
        return IDENTITY_ELEMENT;
    }

    private void validateRoundness(Double value) {
        if (value % 1 != 0) throw new ArithmeticException("Root result " + value + " is not round.");
    }

}
