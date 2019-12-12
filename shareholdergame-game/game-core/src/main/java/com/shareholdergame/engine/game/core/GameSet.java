package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.Builder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class GameSet {

    private CardOption cardOption;

    private PriceScale priceScale;

    private Map<Long, Color> shares;

    private Set<Player> players;

    private Set<Game> games;

    private GameSet(GameSetBuilder builder) {
        this.cardOption = builder.cardOption;
        this.shares = builder.shareMap;
        this.priceScale = builder.priceScale;
    }

    public static GameSetBuilder builder() {
        return new GameSetBuilder();
    }

    public CardOption getCardOption() {
        return cardOption;
    }

    public PriceScale getPriceScale() {
        return priceScale;
    }

    public Map<Long, Color> getShares() {
        return Collections.unmodifiableMap(shares);
    }

    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public Set<Game> getGames() {
        return Collections.unmodifiableSet(games);
    }

    public static class GameSetBuilder implements Builder<GameSet> {

        private CardOption cardOption;
        private PriceScale priceScale;
        private Map<Long, Color> shareMap = Maps.newHashMap();

        private GameSetBuilder() {
        }

        public GameSetBuilder cardOption(int major, int minor) {
            cardOption = CardOption.of(major, minor);
            return this;
        }

        public GameSetBuilder priceScale(int min, int max, int step) {
            priceScale = PriceScale.of(min, max, step);
            return this;
        }

        public GameSetBuilder color(Long colorId, int initialPrice, int initialQuantity) {
            shareMap.putIfAbsent(colorId, Color.of(colorId, initialPrice, initialQuantity));
            return this;
        }

        @Override
        public GameSet build() {
            return new GameSet(this);
        }
    }
}
