package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.shareholdergame.engine.game.core.builder.AbstractNestedBuilder;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.Set;

public final class Game {

    private String letter;

    private GameStatus gameStatus;

    private Map<Integer, GamePlayer> turnOrderMap;

    private PriceScale priceScale;

    private Set<Color> colors;

    private Game(GameBuilder builder) {
        this.letter = builder.letter;
        this.priceScale = builder.priceScale;
        this.colors = builder.colors;
        this.turnOrderMap = Maps.newTreeMap();
        for (int i = 0; i < builder.playersInTurnOrder.length; i++) {
            String playerName = builder.playersInTurnOrder[i];
            GamePlayer.GamePlayerBuilder gamePlayerBuilder =
                    GamePlayer.builder().playerName(playerName).turnOrder(i + 1);
            PlayerCardSetBuilder playerCardSetBuilder = builder.playerCardSetMap.get(playerName);
            GamePlayer gamePlayer = gamePlayerBuilder.cards(playerCardSetBuilder.playerCards).build();
            turnOrderMap.putIfAbsent(gamePlayer.getTurnOrder(), gamePlayer);
        }
        buildInitialPositions();
    }

    private void buildInitialPositions() {
        turnOrderMap.values().forEach(gamePlayer -> {
            PlayerPosition.PlayerPositionBuilder playerPositionBuilder = PlayerPosition.builder();
            colors.forEach(color -> playerPositionBuilder.addColorUnit(color.getColorId(), color.getInitialQuantity()));
            PlayerPosition playerPosition = playerPositionBuilder.build();
            BuySellStepResult buySellStepResult = BuySellStepResult.of(playerPosition);

        });
    }

    static GameBuilder builder(GameSet.GameSetBuilder gameSetBuilder) {
        return new GameBuilder(gameSetBuilder);
    }

    public String getLetter() {
        return letter;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void doTurn(Turn turn) {

    }

    public static class GameBuilder extends AbstractNestedBuilder<GameSet.GameSetBuilder> implements Builder<Game> {

        private String letter;
        private String[] playersInTurnOrder;
        private Map<String, PlayerCardSetBuilder> playerCardSetMap = Maps.newHashMap();
        private PriceScale priceScale;
        private Set<Color> colors;

        protected GameBuilder(GameSet.GameSetBuilder nestedBuilder) {
            super(nestedBuilder);
        }

        public GameBuilder letter(String letter) {
            this.letter = letter;
            return this;
        }

        public GameBuilder turnOrder(String... playersInTurnOrder) {
            this.playersInTurnOrder = playersInTurnOrder;
            return this;
        }

        public GameBuilder colors(Set<Color> colors) {
            this.colors = colors;
            return this;
        }

        public PlayerCardSetBuilder playerCardSet(String player) {
            PlayerCardSetBuilder playerCardSetBuilder = new PlayerCardSetBuilder(this);
            playerCardSetMap.putIfAbsent(player, playerCardSetBuilder);
            return playerCardSetBuilder;
        }

        public GameBuilder priceScale(PriceScale priceScale) {
            this.priceScale = priceScale;
            return this;
        }

        @Override
        public Game build() {
            Validate.notEmpty(letter);
            Validate.notEmpty(playersInTurnOrder);
            Validate.notEmpty(playerCardSetMap);
            Validate.isTrue(playersInTurnOrder.length == playerCardSetMap.size());
            Validate.notNull(priceScale);
            Validate.notEmpty(colors);
            return new Game(this);
        }
    }

    public static class PlayerCardSetBuilder extends AbstractNestedBuilder<Game.GameBuilder> {

        private Set<PlayerCard> playerCards = Sets.newHashSet();

        public PlayerCardSetBuilder addCard(PlayerCard playerCard) {
            playerCards.add(playerCard);
            return this;
        }

        protected PlayerCardSetBuilder(GameBuilder nestedBuilder) {
            super(nestedBuilder);
        }
    }
}
