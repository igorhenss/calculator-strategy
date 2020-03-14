package com.igorhenss.domain;

import com.igorhenss.domain.operation.databuilder.NumberDatabuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    private static final Number X = NumberDatabuilder.X;

    private Number noValueNumber = Number.of("NO_VALUE_NUMBER", null);

    @Test
    void shouldReturnFalse_whenNumberHasNoValue() {
        assertFalse(noValueNumber.hasValue());
    }

    @Test
    void shouldReturnNull_whenNumberHasNoValue() {
        assertNull(noValueNumber.getValue());
    }

    @Test
    void shouldReturnTrue_whenNumberHasValue() {
        assertTrue(X.hasValue());
    }

    @Test
    void shouldReturnValue_whenNumberHasValue() {
        assertEquals(NumberDatabuilder.X.getValue(), X.getValue());
    }

    @Test
    void shouldReturnName() {
        assertEquals("NO_VALUE_NUMBER", noValueNumber.getName());
    }

}
