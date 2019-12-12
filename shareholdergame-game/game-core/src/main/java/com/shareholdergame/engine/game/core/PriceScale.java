package com.shareholdergame.engine.game.core;

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
