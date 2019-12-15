package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;

public class PriceScale {

    private double minPrice;

    private double maxPrice;

    private double step;

    private PriceScale(double minPrice, double maxPrice, double step) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.step = step;
    }

    public static PriceScale of(double minPrice, double maxPrice, double step) {
        Validate.isTrue(minPrice >= 0.0);
        Validate.isTrue(maxPrice > minPrice);
        Validate.isTrue(step < (maxPrice - minPrice) && step > 0.0);
        return new PriceScale(minPrice, maxPrice, step);
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public double getStep() {
        return step;
    }
}
