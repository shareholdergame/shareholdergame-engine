package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class ColorUnitPrice implements Comparable<ColorUnitPrice> {

    private final Long colorId;

    private double price = 0.0;

    private ColorUnitPrice(Long colorId) {
        this.colorId = colorId;
    }

    public Long getColorId() {
        return colorId;
    }

    public Double getPrice() {
        return price;
    }

    public static ColorUnitPrice of(Long colorId, double price) {
        ColorUnitPrice colorUnitPrice = new ColorUnitPrice(colorId);
        colorUnitPrice.price = price;
        return colorUnitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ColorUnitPrice that = (ColorUnitPrice) o;

        return new EqualsBuilder()
                .append(colorId, that.colorId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(colorId)
                .toHashCode();
    }

    @Override
    public int compareTo(ColorUnitPrice o) {
        return (int) (this.colorId - o.colorId);
    }
}
