package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;

public final class Color {

    private Long colorId;

    private double initialPrice;

    private long initialQuantity;

    private Color(Long colorId, double initialPrice, long initialQuantity) {
        this.colorId = colorId;
        this.initialPrice = initialPrice;
        this.initialQuantity = initialQuantity;
    }

    public static Color of(Long colorId, double initialPrice, int initialQuantity) {
        Validate.notNull(colorId);
        Validate.isTrue(initialPrice > 0);
        Validate.isTrue(initialQuantity >= 0);
        return new Color(colorId, initialPrice, initialQuantity);
    }

    public Long getColorId() {
        return colorId;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public long getInitialQuantity() {
        return initialQuantity;
    }
}
