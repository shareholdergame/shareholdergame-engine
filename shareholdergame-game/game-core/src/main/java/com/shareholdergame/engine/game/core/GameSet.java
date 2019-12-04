package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.builder.Builder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class GameSet {

    private CardOption cardOption;

    private PriceScale priceScale;

    private Map<Long, Share> shares;

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

    public Map<Long, Share> getShares() {
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
        private Map<Long, Share> shareMap = Maps.newHashMap();
        private Set<Player.PlayerBuilder> playerBuilders = Sets.newHashSet();

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

        public GameSetBuilder share(Long shareId, int initialPrice, int initialQuantity) {
            shareMap.putIfAbsent(shareId, Share.of(shareId, initialPrice, initialQuantity));
            return this;
        }

        @Override
        public GameSet build() {
            return new GameSet(this);
        }
    }
}
