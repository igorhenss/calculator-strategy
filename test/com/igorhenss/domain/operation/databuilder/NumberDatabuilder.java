package com.igorhenss.domain.operation.databuilder;

import com.igorhenss.domain.Number;

public abstract class NumberDatabuilder {

    public static final Number X =  Number.of("X", 1D);
    public static final Number Y =  Number.of("Y", 10D);

    private NumberDatabuilder() {}

}
