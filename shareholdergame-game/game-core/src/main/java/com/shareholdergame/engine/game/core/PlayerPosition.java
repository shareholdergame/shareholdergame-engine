package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

import java.util.Map;

public final class PlayerPosition {

    private Map<Long, Long> colorUnits;

    private double cash;

    private PlayerPosition(PlayerPositionBuilder builder) {
        this.colorUnits = builder.colorUnits;
        this.cash = builder.cash;
    }

    public Map<Long, Long> getColorUnits() {
        return colorUnits;
    }

    public double getCash() {
        return cash;
    }

    public static PlayerPositionBuilder builder() {
        return new PlayerPositionBuilder();
    }

    public static class PlayerPositionBuilder implements Builder<PlayerPosition> {

        private Map<Long, Long> colorUnits = Maps.newHashMap();
        private double cash;

        public PlayerPositionBuilder addColorUnit(Long colorId, Long unitsQuantity) {
            colorUnits.putIfAbsent(colorId, unitsQuantity);
            return this;
        }

        public PlayerPositionBuilder cash(double cash) {
            this.cash = cash;
            return this;
        }

        public PlayerPositionBuilder copy(BuySellStepResult buySellStepResult) {
            buySellStepResult.getColorUnits().forEach(this::addColorUnit);
            this.cash = buySellStepResult.getCash();
            return this;
        }

        @Override
        public PlayerPosition build() {
            Validate.notEmpty(colorUnits);
            Validate.isTrue(cash >= 0.0);
            return new PlayerPosition(this);
        }
    }
}
