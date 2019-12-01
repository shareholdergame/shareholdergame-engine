package com.shareholdergame.engine.game.core;

public class PriceScale {

    private int minPrice;

    private int maxPrice;

    private int step;

    private PriceScale(int minPrice, int maxPrice, int step) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.step = step;
    }

    public PriceScale of(int minPrice, int maxPrice, int step) {
        return new PriceScale(minPrice, maxPrice, step);
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getStep() {
        return step;
    }
}
