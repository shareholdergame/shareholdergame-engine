package com.shareholdergame.engine.game.core;

public final class Share {

    private Long shareId;

    private int initialPrice;

    private long initialQuantity;

    private Share(Long shareId, int initialPrice, long initialQuantity) {
        this.shareId = shareId;
        this.initialPrice = initialPrice;
        this.initialQuantity = initialQuantity;
    }

    public static Share of(Long shareId, int initialPrice, int initialQuantity) {
        return new Share(shareId, initialPrice, initialQuantity);
    }

    public Long getShareId() {
        return shareId;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public long getInitialQuantity() {
        return initialQuantity;
    }
}
