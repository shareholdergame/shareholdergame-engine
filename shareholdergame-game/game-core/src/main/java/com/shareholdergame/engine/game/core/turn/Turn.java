package com.shareholdergame.engine.game.core.turn;

import java.util.Map;

public class Turn {

    private BuySellStep firstBuySellStep;

    private Long appliedCardId;

    private Map<Long, Long> assignedColors;

    private BuySellStep lastBuySellStep;
}
