package com.igorhenss.domain.operation;

import com.igorhenss.domain.operation.advanced.Percentage;
import com.igorhenss.domain.operation.advanced.Power;
import com.igorhenss.domain.operation.advanced.Remainder;
import com.igorhenss.domain.operation.advanced.Root;
import com.igorhenss.domain.operation.basic.Addition;
import com.igorhenss.domain.operation.basic.Division;
import com.igorhenss.domain.operation.basic.Multiplication;
import com.igorhenss.domain.operation.basic.Subtraction;

public abstract class Operations {

    public static final Division DIVISION = new Division();
    public static final Multiplication MULTIPLICATION = new Multiplication();
    public static final Percentage PERCENTAGE = new Percentage();
    public static final Power POWER = new Power();
    public static final Remainder REMAINDER = new Remainder();
    public static final Root ROOT = new Root();
    public static final Subtraction SUBTRACTION = new Subtraction();
    public static final Addition ADDITION = new Addition();

    private Operations() {}

}
