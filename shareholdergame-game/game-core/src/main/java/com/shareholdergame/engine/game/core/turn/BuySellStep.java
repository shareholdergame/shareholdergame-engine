package com.shareholdergame.engine.game.core.turn;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.Builder;

import java.util.Map;

public class BuySellStep {

    private Map<Long, Long> buySellStep;

    public BuySellStep(BuySellStepBuilder builder) {
        this.buySellStep = builder.buySellStep;
    }

    public static class BuySellStepBuilder implements Builder<BuySellStep> {

        private Map<Long, Long> buySellStep = Maps.newHashMap();



        @Override
        public BuySellStep build() {
            return new BuySellStep(this);
        }
    }
}
