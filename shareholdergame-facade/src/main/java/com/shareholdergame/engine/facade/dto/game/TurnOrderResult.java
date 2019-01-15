package com.shareholdergame.engine.facade.dto.game;

public class TurnOrderResult {

    private short turnOrder;

    private PlayerResult result;

    public short getTurnOrder() {
        return turnOrder;
    }

    public void setTurnOrder(short turnOrder) {
        this.turnOrder = turnOrder;
    }

    public PlayerResult getResult() {
        return result;
    }

    public void setResult(PlayerResult result) {
        this.result = result;
    }
}
