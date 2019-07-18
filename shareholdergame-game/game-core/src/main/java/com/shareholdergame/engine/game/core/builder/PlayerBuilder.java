package com.shareholdergame.engine.game.core.builder;

import com.shareholdergame.engine.game.core.Player;
import org.apache.commons.lang3.builder.Builder;

public class PlayerBuilder implements Builder<Player> {

    private GameBuilder gameBuilder;

    private String name;

    public String getName() {
        return name;
    }

    public PlayerBuilder(GameBuilder gameBuilder) {
        this.gameBuilder = gameBuilder;
    }

    public PlayerBuilder card() {
        return this;
    }

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public GameBuilder finish() {
        return gameBuilder;
    }

    @Override
    public Player build() {
        return new Player();
    }
}
