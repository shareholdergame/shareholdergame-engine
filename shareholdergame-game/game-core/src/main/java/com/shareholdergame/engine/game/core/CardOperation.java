package com.shareholdergame.engine.game.core;

public final class CardOperation {

    private Long shareId = 0L;

    private final Operation operation;

    public CardOperation(Long shareId, Operation operation) {
        this.shareId = shareId;
        this.operation = operation;
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
