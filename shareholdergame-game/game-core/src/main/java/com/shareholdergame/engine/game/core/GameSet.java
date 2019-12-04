package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.Builder;

import java.util.Map;
import java.util.Set;

public class GameSet {

    private PriceScale priceScale;

    private Map<Long, Share> shares = Maps.newHashMap();

    private Set<Player> players;

    private Set<Game> games;

    private GameSet(GameSetBuilder builder) {
    }

    public static GameSetBuilder builder() {
        return new GameSetBuilder();
    }

    public static class GameSetBuilder implements Builder<GameSet> {

        private GameSetBuilder() {
        }

        public GameSetBuilder cardOption(int major, int minor) {
            return this;
        }

        public GameSetBuilder priceScale(int min, int max, int step) {
            return this;
        }

        public GameSetBuilder share(Long shareId, int initialPrice) {
            return this;
        }

        @Override
        public GameSet build() {
            return new GameSet(this);
        }
    }
}
