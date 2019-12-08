package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class CardOperation {

    private Long shareId;

    private final Operation operation;

    private CardOperation(Long shareId, Operation operation) {
        this.shareId = shareId;
        this.operation = operation;
    }

    public static CardOperation of(Long shareId, Operation operation) {
        Validate.notNull(shareId);
        Validate.notNull(operation);
        return new CardOperation(shareId, operation);
    }

    public Long getShareId() {
        return shareId;
    }

    public Operation getOperation() {
        return operation;
    }

    public void assignShare(Long shareId) {
        if (shareId.equals(0L)) {
            this.shareId = shareId;
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
                .append(shareId, that.shareId)
                .append(operation, that.operation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(shareId)
                .append(operation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("shareId", shareId)
                .append("operation", operation)
                .build();
    }
}
