package com.igorhenss;

import com.igorhenss.domain.Number;

import java.util.Random;

import static com.igorhenss.domain.Calculator.calculate;
import static com.igorhenss.domain.operation.Operations.*;
import static java.lang.String.format;
import static java.lang.System.out;

public class Main {

    private static final Random RANDOM = new Random();

    public static final Number HALF = Number.of("HALF", 0.5);
    public static final Number ONE = Number.of("ONE", calculate(ADDITION, HALF, HALF));
    public static final Number TWO = Number.of("TWO", calculate(ADDITION, ONE, ONE));
    public static final Number THREE = Number.of("THREE", calculate(ADDITION, ONE, TWO));
    public static final Number FOUR = Number.of("FOUR", calculate(ADDITION, TWO, TWO));
    public static final Number EIGHT = Number.of("EIGHT", calculate(ADDITION, FOUR, FOUR));
    public static final Number TEN = Number.of("TEN", calculate(ADDITION, EIGHT, TWO));
    public static final Number NINE_AND_A_HALF = Number.of("NINE_AND_A_HALF", calculate(SUBTRACTION, TEN, HALF));
    public static final Number TEN_AND_A_HALF = Number.of("TEN_AND_A_HALF", calculate(ADDITION, TEN, HALF));
    public static final Number TWENTY_SEVEN = Number.of("TWENTY_SEVEN", calculate(POWER, THREE, THREE));

    public static void main(String[] args) {

        String equation = "2 * ( 9.5 + 10.5 ) - 1 / ( 10 % 4 )";

        Number addResult = Number.of("ADD_RESULT", calculate(ADDITION, NINE_AND_A_HALF, TEN_AND_A_HALF));
        Number rmdResult = Number.of("RMD_RESULT", calculate(REMAINDER, TEN, FOUR));

        Number muxResult = Number.of("MUX_RESULT", calculate(MULTIPLICATION, TWO, addResult));
        Number subResult = Number.of("SUB_RESULT", calculate(SUBTRACTION, muxResult, ONE));

        Double equationResult = calculate(DIVISION, subResult, rmdResult);

        show(format("Result of the equation %s is %.2f.", equation, equationResult));

        linebreak();

        show(format("Square root of four (4) is %.2f.", calculate(ROOT, FOUR, TWO)));
        show(format("Cube root of twenty seven (27) is %.2f.", calculate(ROOT, TWENTY_SEVEN, THREE)));

        linebreak();

        randomAdditions();

    }

    private static void linebreak() {
        out.println();
    }

    private static void randomAdditions() {
        int amountOfAdditions = RANDOM.nextInt(25);

        for (int i = 0; i <= amountOfAdditions; i++) {
            Number x = Number.of("X", RANDOM.nextDouble() * 10);
            Number y = Number.of("Y", RANDOM.nextDouble() * 10);

            show(format("%d: %.2f + %.2f = %.2f", i, x.getValue(), y.getValue(), calculate(ADDITION, x, y)));
        }
    }

    private static void show(String message) {
        out.println(message);
    }

}
