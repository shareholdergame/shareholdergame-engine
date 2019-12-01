package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.builder.Builder;

public final class CardOperation {

    private Long shareId;

    private final Operation operation;

    public CardOperation(Long shareId, Operation operation) {
        this.shareId = shareId;
        this.operation = operation;
    }

    private CardOperation(CardOperationBuilder builder) {
        this.shareId = builder.shareId;
        this.operation = builder.operation;
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

    public static CardOperationBuilder builder() {
        return new CardOperationBuilder();
    }

    private static class CardOperationBuilder implements Builder<CardOperation> {

        private Long shareId = 0L;
        private Operation operation;

        public CardOperationBuilder shareId(Long shareId) {
            this.shareId = shareId;
            return this;
        }

        public CardOperationBuilder operation(Operation operation) {
            this.operation = operation;
            return this;
        }

        @Override
        public CardOperation build() {
            return new CardOperation(this);
        }
    }
}
