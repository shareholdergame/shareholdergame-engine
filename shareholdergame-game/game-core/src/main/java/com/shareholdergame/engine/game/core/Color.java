package com.shareholdergame.engine.game.core;

public final class Color {

    private Long colorId;

    private int initialPrice;

    private long initialQuantity;

    private Color(Long colorId, int initialPrice, long initialQuantity) {
        this.colorId = colorId;
        this.initialPrice = initialPrice;
        this.initialQuantity = initialQuantity;
    }

    public static Color of(Long colorId, int initialPrice, int initialQuantity) {
        return new Color(colorId, initialPrice, initialQuantity);
    }

    public Long getColorId() {
        return colorId;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public long getInitialQuantity() {
        return initialQuantity;
    }
}
