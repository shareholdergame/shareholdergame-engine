package com.shareholdergame.engine.game.core;

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

    public static GameBuilder builder() {
        return new GameBuilder();
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

    private static class GameBuilder implements Builder<Game> {

        @Override
        public Game build() {
            return new Game(this);
        }
    }
}
