package com.shareholdergame.engine.game.core.builder;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.shareholdergame.engine.game.core.Game;
import org.apache.commons.lang3.builder.Builder;

import java.util.Map;
import java.util.Set;

public class GameBuilder implements Builder<Game> {

    private int[] cardOptions = new int[] {0, 0};

    private int[] priceScale = new int[] {10, 250};

    private int scaleStep = 10;

    private Map<Long, Long> shares = Maps.newHashMap();

    private Set<PlayerBuilder> playerBuilders = Sets.newHashSet();

    public GameBuilder cardOption(int major, int minor) {
        return this;
    }

    public GameBuilder share(Long shareId, int initialPrice) {
        return this;
    }

    public PlayerBuilder player() {
        PlayerBuilder playerBuilder = new PlayerBuilder(this);
        playerBuilders.add(playerBuilder);
        return playerBuilder;
    }

    @Override
    public Game build() {
        return new Game();
    }
}
