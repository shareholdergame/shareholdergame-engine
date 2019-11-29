package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.builder.Builder;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {

    private Exchange exchange;

    private Bank bank;

    private Set<Player> players;

    private Game(GameBuilder gameBuilder) {
        players = gameBuilder.playerBuilders.stream().map(Player.PlayerBuilder::build).collect(Collectors.toSet());
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public void doTurn() {

    }

    public static class GameBuilder implements Builder<Game> {

        private int[] cardOptions = new int[] {0, 0};

        private int[] priceScale = new int[] {10, 250};

        private int scaleStep = 10;

        private Map<Long, Long> shares = Maps.newHashMap();

        private Set<Player.PlayerBuilder> playerBuilders = Sets.newHashSet();

        public GameBuilder cardOption(int major, int minor) {
            return this;
        }

        public GameBuilder priceScale(int min, int max, int step) {
            return this;
        }

        public GameBuilder share(Long shareId, int initialPrice) {
            return this;
        }

        public Player.PlayerBuilder player() {
            Player.PlayerBuilder playerBuilder = new Player.PlayerBuilder(this);
            playerBuilders.add(playerBuilder);
            return playerBuilder;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
