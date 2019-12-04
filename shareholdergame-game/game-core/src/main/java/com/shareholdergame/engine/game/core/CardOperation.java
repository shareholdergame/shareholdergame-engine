package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;

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
}
