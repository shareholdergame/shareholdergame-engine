package com.shareholdergame.engine.game.core;

import com.google.common.collect.Sets;
import com.shareholdergame.engine.game.core.builder.AbstractNestedBuilder;

import java.util.Set;

public class Player {

    private String name;

    private Set<ShareQuantity> shareQuantitySet = Sets.newTreeSet();

    private Player(PlayerBuilder playerBuilder) {

    }

    public static class PlayerBuilder extends AbstractNestedBuilder<Game.GameBuilder> {

        private String name;

        PlayerBuilder(Game.GameBuilder gameBuilder) {
            super(gameBuilder);
        }

        public PlayerBuilder card() {
            return this;
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
