package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.Validate;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class BuySellStepResult {

    private Map<Long, Long> colorUnits;

    private double cash = 0.0;

    private BuySellStepResult(PlayerPosition playerPosition) {
        this.colorUnits = Maps.newHashMap(playerPosition.getColorUnits());
        this.cash = playerPosition.getCash();
    }

    public Map<Long, Long> getColorUnits() {
        return Collections.unmodifiableMap(colorUnits);
    }

    public double getCash() {
        return cash;
    }

    public static BuySellStepResult of(PlayerPosition playerPosition) {
        Validate.notNull(playerPosition);
        Validate.notEmpty(playerPosition.getColorUnits());
        return new BuySellStepResult(playerPosition);
    }
}
