package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class CardOperation {

    private Long colorId;

    private final Operation operation;

    private CardOperation(Long colorId, Operation operation) {
        this.colorId = colorId;
        this.operation = operation;
    }

    public static CardOperation of(Long colorId, Operation operation) {
        Validate.notNull(colorId);
        Validate.notNull(operation);
        return new CardOperation(colorId, operation);
    }

    public Long getColorId() {
        return colorId;
    }

    public Operation getOperation() {
        return operation;
    }

    public void assignColor(Long colorId) {
        if (colorId.equals(0L)) {
            this.colorId = colorId;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CardOperation that = (CardOperation) o;

        return new EqualsBuilder()
                .append(colorId, that.colorId)
                .append(operation, that.operation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(colorId)
                .append(operation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("colorId", colorId)
                .append("operation", operation)
                .build();
    }
}
