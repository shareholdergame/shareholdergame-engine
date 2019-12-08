package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.builder.Builder;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Game {

    private String letter;

    private Set<GamePlayer> players;

    private Game(GameBuilder gameBuilder) {

    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public void doTurn() {

    }

    private static class GameBuilder implements Builder<Game> {

        @Override
        public Game build() {
            return new Game(this);
        }
    }
}
