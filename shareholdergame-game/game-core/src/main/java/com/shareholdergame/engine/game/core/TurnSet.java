package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

public class TurnSet {

    private Map<Integer, Map<Integer, TurnRecord>> turns = Maps.newHashMap();

    public Set<TurnRecord> getByTurnOrder(int turnOrder) {
        return null;
    }

    public void addTurn(BuySellStepResult buySellStepResult) {
        
    }
}
