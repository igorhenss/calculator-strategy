package com.igorhenss.domain.operation.advanced;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.Operation;

public class Power implements Operation {

    public static final Number IDENTITY_ELEMENT = Number.of("e", null);

    @Override
    public Double operate(Double x, Double y) {
        return Math.pow(x, y);
    }

    @Override
    public Boolean hasIdentityElement() {
        return IDENTITY_ELEMENT.hasValue();
    }

    @Override
    public Number getIdentityElement() {
        return IDENTITY_ELEMENT;
    }

}
