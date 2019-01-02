package com.shareholdergame.engine.facade.dto.game;

import java.util.Set;

public class ReportPlayer {

    private Long playerId;

    private short turnOrder;

    private Set<PlayerCard> playerCards;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public short getTurnOrder() {
        return turnOrder;
    }

    public void setTurnOrder(short turnOrder) {
        this.turnOrder = turnOrder;
    }

    public Set<PlayerCard> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(Set<PlayerCard> playerCards) {
        this.playerCards = playerCards;
    }
}
