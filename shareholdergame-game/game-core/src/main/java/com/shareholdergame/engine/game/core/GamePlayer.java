package com.shareholdergame.engine.game.core;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

import java.util.Collections;
import java.util.Set;

public final class GamePlayer {

    private String playerName;

    private int turnOrder;

    private Set<PlayerCard> cards;

    private GamePlayer(GamePlayerBuilder builder) {
        this.playerName = builder.playerName;
        this.turnOrder = builder.turnOrder;
        this.cards = builder.cards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTurnOrder() {
        return turnOrder;
    }

    public Set<PlayerCard> getCards() {
        return Collections.unmodifiableSet(cards);
    }

    public static GamePlayerBuilder builder() {
        return new GamePlayerBuilder();
    }

    public static class GamePlayerBuilder implements Builder<GamePlayer> {

        private String playerName;
        private int turnOrder;
        private Set<PlayerCard> cards = Sets.newHashSet();

        public GamePlayerBuilder playerName(String playerName) {
            this.playerName = playerName;
            return this;
        }

        public GamePlayerBuilder turnOrder(int turnOrder) {
            this.turnOrder = turnOrder;
            return this;
        }

        public GamePlayerBuilder cards(Set<PlayerCard> playerCards) {
            this.cards = playerCards;
            return this;
        }

        @Override
        public GamePlayer build() {
            Validate.notEmpty(playerName);
            Validate.isTrue(turnOrder > 0);
            Validate.notEmpty(cards);
            return new GamePlayer(this);
        }
    }
}
