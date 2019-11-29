package com.shareholdergame.engine.game.core;

public class Operation {

    private int operand;

    private ArithmeticOperation operation;

    private Operation(int operand, ArithmeticOperation operation) {
        this.operand = operand;
        this.operation = operation;
    }

    public static Operation of(int operand, ArithmeticOperation operation) {
        return new Operation(operand, operation);
    }

    public int getOperand() {
        return operand;
    }

    public int apply(int value) {
        return operation.apply(value, operand);
    }
}
