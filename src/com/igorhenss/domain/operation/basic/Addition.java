package com.igorhenss.domain.operation.basic;

import com.igorhenss.domain.Number;
import com.igorhenss.domain.operation.Operation;

public class Addition implements Operation {

    public static final Number IDENTITY_ELEMENT = Number.of("e", 0D);

    @Override
    public Double operate(Double x, Double y) {
        return x + y;
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
