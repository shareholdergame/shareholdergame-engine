package com.shareholdergame.engine.game.core;

public class PlayerCard {

    private Card card;

    private boolean applied;

    public void markApplied() {
        if (applied) {
            throw new RuntimeException();
        }
        applied = true;
    }
}
