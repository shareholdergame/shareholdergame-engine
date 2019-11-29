package com.shareholdergame.engine.game.core;

public enum ArithmeticOperation {

    ADD(Integer::sum),

    MULT((value, operand) -> value * operand),

    DIV((value, operand) -> value / operand);

    private ArithmeticOperationFunction function;

    ArithmeticOperation(ArithmeticOperationFunction function) {
        this.function = function;
    }

    public int apply(int value, int operand) {
        return function.apply(value, operand);
    }

    @FunctionalInterface
    private interface ArithmeticOperationFunction {
        int apply(int value, int operand);
    }
}
