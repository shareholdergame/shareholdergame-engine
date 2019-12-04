package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.game.core.exception.CardAlreadyAppliedException;
import org.apache.commons.lang3.builder.Builder;

public final class PlayerCard {

    private Card card;

    private boolean applied;

    private PlayerCard(PlayerCardBuilder builder) {
        this.card = builder.card;
    }

    public static PlayerCardBuilder builder() {
        return new PlayerCardBuilder();
    }

    public Card getCard() {
        return card;
    }

    public boolean isApplied() {
        return applied;
    }

    public void markApplied() throws CardAlreadyAppliedException {
        if (applied) {
            throw new CardAlreadyAppliedException();
        }
        applied = true;
    }

    private static class PlayerCardBuilder implements Builder<PlayerCard> {

        private Card card;

        public PlayerCardBuilder card(Card card) {
            this.card = card;
            return this;
        }

        @Override
        public PlayerCard build() {
            return new PlayerCard(this);
        }
    }
}
