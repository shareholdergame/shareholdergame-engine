package com.shareholdergame.engine.facade.dto.game;

import java.util.Set;

public class BuySellStep {

    private Set<BuySellOperation> buySellOperations;

    public Set<BuySellOperation> getBuySellOperations() {
        return buySellOperations;
    }

    public void setBuySellOperations(Set<BuySellOperation> buySellOperations) {
        this.buySellOperations = buySellOperations;
    }
}
