package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;

import java.util.Collections;
import java.util.Map;

public final class BuySellStepResult {

    private Map<Long, Long> colorUnits;

    private BuySellStepResult(Map<Long, Long> colorUnits) {
        this.colorUnits = colorUnits;
    }

    public Map<Long, Long> getColorUnits() {
        return Collections.unmodifiableMap(colorUnits);
    }

    public static BuySellStepResult of(PlayerPosition playerPosition) {
        Validate.notNull(playerPosition);
        Validate.notEmpty(playerPosition.getColorUnits());
        return new BuySellStepResult(playerPosition.getColorUnits());
    }
}
