package com.shareholdergame.engine.game.core;

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

    private Map<Character, Game> gameMap;

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
        return Collections.unmodifiableCollection(gameMap.values());
    }

    public static class GameSetBuilder implements Builder<GameSet> {

        private CardOption cardOption;
        private GameConfiguration gameConfiguration;
        private Set<String> players;

        private GameSetBuilder() {
        }

        public GameSetBuilder cardOption(int major, int minor) {
            this.cardOption = CardOption.of(major, minor);
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
