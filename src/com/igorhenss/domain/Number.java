package com.igorhenss.domain;

import java.util.Objects;

public class Number {

    private String name;

    private Double value;

    private Number(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public static Number of(String name, Double value) {
        return new Number(name, value);
    }

    public Boolean hasValue() {
        return Objects.nonNull(value);
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

}
