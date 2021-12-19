package com.shareholdergame.engine.game.core;

public enum ArithmeticOperation {

    ADD(Double::sum),

    MULT((value, operand) -> value * operand);

    private final ArithmeticOperationFunction function;

    ArithmeticOperation(ArithmeticOperationFunction function) {
        this.function = function;
    }

    public double apply(double value, double operand) {
        return function.apply(value, operand);
    }

    @FunctionalInterface
    private interface ArithmeticOperationFunction {
        double apply(double value, double operand);
    }
}
