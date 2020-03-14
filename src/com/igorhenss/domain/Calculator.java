package com.igorhenss.domain;

import com.igorhenss.domain.operation.Operation;

import java.util.Objects;

public class Calculator {

    private Calculator() {}

    public static Double calculate(Operation operation, Number m, Number n) {
        validate(m);
        validate(n);

        return operation.operate(m.getValue(), n.getValue());
    }

    private static void validate(Number number) {
        if (Objects.isNull(number.getValue())) throw new IllegalArgumentException("Number (" + number.getName() + ") must not be null");
    }

}
