package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class GameSet {

    private CardOption cardOption;

    private GameConfiguration gameConfiguration;

    private Set<Player> players;

    private Map<Character, Game> games;

    private GameSet(GameSetBuilder builder) {
        this.cardOption = builder.cardOption;
        this.gameConfiguration = builder.gameConfiguration;
        this.players = builder.players.stream().map(Player::of).collect(Collectors.toSet());
    }

    public static GameSetBuilder builder() {
        return new GameSetBuilder();
    }

    public CardOption getCardOption() {
        return cardOption;
    }

    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }

    public Collection<Game> getGames() {
        return Collections.unmodifiableCollection(games.values());
    }

    public static class GameSetBuilder implements Builder<GameSet> {

        private CardOption cardOption;
        private GameConfiguration gameConfiguration;
        private Set<String> players;
        private Map<String, Game.GameBuilder> gameBuilderMap = Maps.newHashMap();

        private GameSetBuilder() {
        }

        public GameSetBuilder cardOption(CardOption cardOption) {
            this.cardOption = cardOption;
            return this;
        }

        public GameSetBuilder gameConfiguration(GameConfiguration gameConfiguration) {
            this.gameConfiguration = gameConfiguration;
            return this;
        }

        public GameSetBuilder players(String... players) {
            this.players = Sets.newHashSet(players);
            return this;
        }

        public Game.GameBuilder game(String gameLetter) {
            Game.GameBuilder gameBuilder = Game.builder(this)
                    .letter(gameLetter)
                    .priceScale(gameConfiguration.getPriceScale());
            gameBuilderMap.putIfAbsent(gameLetter, gameBuilder);
            return gameBuilder;
        }

        @Override
        public GameSet build() {
            Validate.notNull(cardOption);
            Validate.notNull(gameConfiguration);
            Validate.notEmpty(players);
            Validate.isTrue(players.size() > 1);
            return new GameSet(this);
        }
    }
}
