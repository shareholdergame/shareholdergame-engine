package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;

import java.util.Map;

public final class PlayerPosition {

    private Map<Long, Long> colorUnits;

    private PlayerPosition(Map<Long, Long> colorUnits) {
        this.colorUnits = colorUnits;
    }

    public Map<Long, Long> getColorUnits() {
        return colorUnits;
    }

    public static PlayerPosition of(BuySellStepResult buySellStepResult) {
        Validate.notNull(buySellStepResult);
        Validate.notEmpty(buySellStepResult.getColorUnits());
        return new PlayerPosition(buySellStepResult.getColorUnits());
    }
}
