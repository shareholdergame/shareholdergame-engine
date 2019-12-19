package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.shareholdergame.engine.game.core.builder.AbstractNestedBuilder;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.Set;

public final class Game {

    private String letter;

    private GameStatus gameStatus;

    private Map<Integer, Pair<String, Set<PlayerCard>>> turnOrderMap;

    private Game(GameBuilder gameBuilder) {
        this.gameStatus = GameStatus.CREATED;
    }

    static GameBuilder builder(GameSet.GameSetBuilder gameSetBuilder) {
        return new GameBuilder(gameSetBuilder);
    }

    public String getLetter() {
        return letter;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void start() {

    }

    public void doTurn(Turn turn) {

    }

    public static class GameBuilder extends AbstractNestedBuilder<GameSet.GameSetBuilder> implements Builder<Game> {

        private String[] playersInTurnOrder;
        private Map<String, PlayerCardSetBuilder> playerCardSetMap = Maps.newHashMap();

        protected GameBuilder(GameSet.GameSetBuilder nestedBuilder) {
            super(nestedBuilder);
        }

        public GameBuilder turnOrder(String... playersInTurnOrder) {
            this.playersInTurnOrder = playersInTurnOrder;
            return this;
        }

        public PlayerCardSetBuilder playerCardSet(String player) {
            PlayerCardSetBuilder playerCardSetBuilder = new PlayerCardSetBuilder(this);
            playerCardSetMap.putIfAbsent(player, playerCardSetBuilder);
            return playerCardSetBuilder;
        }

        @Override
        public Game build() {
            Validate.notEmpty(playersInTurnOrder);
            return new Game(this);
        }
    }

    public static class PlayerCardSetBuilder extends AbstractNestedBuilder<Game.GameBuilder> {

        private Set<PlayerCard> playerCards = Sets.newHashSet();

        public PlayerCardSetBuilder addCard(PlayerCard playerCard) {
            playerCards.add(playerCard);
            return this;
        }

        protected PlayerCardSetBuilder(GameBuilder nestedBuilder) {
            super(nestedBuilder);
        }
    }
}
