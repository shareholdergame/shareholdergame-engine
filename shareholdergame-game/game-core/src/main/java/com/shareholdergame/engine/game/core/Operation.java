package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Operation {

    private int operand;

    private ArithmeticOperation operation;

    private Operation(int operand, ArithmeticOperation operation) {
        this.operand = operand;
        this.operation = operation;
    }

    public static Operation of(int operand, ArithmeticOperation operation) {
        Validate.isTrue(operand != 0);
        Validate.notNull(operation);
        return new Operation(operand, operation);
    }

    public int getOperand() {
        return operand;
    }

    public int apply(int value) {
        return operation.apply(value, operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Operation that = (Operation) o;

        return new EqualsBuilder()
                .append(operand, that.operand)
                .append(operation, that.operation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(operand)
                .append(operation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("operand", operand)
                .append("operation", operation)
                .build();
    }
}
