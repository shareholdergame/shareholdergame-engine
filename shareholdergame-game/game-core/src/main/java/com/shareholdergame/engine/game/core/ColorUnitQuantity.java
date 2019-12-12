package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class ColorUnitQuantity implements Comparable<ColorUnitQuantity> {

    private final Long colorId;

    private Long quantity = 0L;

    private ColorUnitQuantity(Long colorId) {
        this.colorId = colorId;
    }

    public Long getColorId() {
        return colorId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public static ColorUnitQuantity of(Long colorId, Long quantity) {
        ColorUnitQuantity colorUnitQuantity = new ColorUnitQuantity(colorId);
        colorUnitQuantity.quantity = quantity;
        return colorUnitQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ColorUnitQuantity that = (ColorUnitQuantity) o;

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
    public int compareTo(ColorUnitQuantity o) {
        return (int) (this.colorId - o.colorId);
    }
}
