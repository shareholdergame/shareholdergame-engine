package com.shareholdergame.engine.game.core;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class GameSet {

    private CardOption cardOption;

    private GameConfiguration gameConfiguration;

    private Set<Player> players;

    private Map<String, Game> games;

    private GameSet(GameSetBuilder builder) {
        this.cardOption = builder.cardOption;
        this.gameConfiguration = builder.gameConfiguration;
        this.players = builder.players.stream().map(Player::of).collect(Collectors.toSet());
        this.games = Maps.newTreeMap();
        builder.gameBuilderMap.values().forEach(gameBuilder -> {
            Game game = gameBuilder.build();
            games.putIfAbsent(game.getLetter(), game);
        });
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

    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
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
                    .colors(gameConfiguration.getColors())
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
            Validate.isTrue(gameBuilderMap.size() >= players.size());
            return new GameSet(this);
        }
    }
}
