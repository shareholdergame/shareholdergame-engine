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

    private static class GameSetBuilder implements Builder<GameSet> {

        @Override
        public GameSet build() {
            return new GameSet(this);
        }
    }
}
