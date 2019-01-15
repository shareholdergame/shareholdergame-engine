package com.shareholdergame.engine.facade.dto.game;

public class Turn {

    private BuySellStep firstStep;

    private CardStep cardStep;

    private BuySellStep lastStep;

    public BuySellStep getFirstStep() {
        return firstStep;
    }

    public void setFirstStep(BuySellStep firstStep) {
        this.firstStep = firstStep;
    }

    public CardStep getCardStep() {
        return cardStep;
    }

    public void setCardStep(CardStep cardStep) {
        this.cardStep = cardStep;
    }

    public BuySellStep getLastStep() {
        return lastStep;
    }

    public void setLastStep(BuySellStep lastStep) {
        this.lastStep = lastStep;
    }
}
