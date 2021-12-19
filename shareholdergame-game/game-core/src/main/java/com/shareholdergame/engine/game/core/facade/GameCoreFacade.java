package com.shareholdergame.engine.game.core.facade;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.shareholdergame.engine.game.core.*;
import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import com.shareholdergame.engine.game.core.configuration.GameConfigurationManager;
import com.shareholdergame.engine.game.core.exception.ConfigurationReadingException;
import com.shareholdergame.engine.game.core.turn.Turn;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameCoreFacade {

    private GameConfigurationManager configurationManager;

    private Map<Long, GameSet> cache = Maps.newHashMap();

    public GameCoreFacade(GameConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    public GameConfiguration getDefaultConfiguration() throws ConfigurationReadingException {
        return configurationManager.getDefault();
    }

    public void startGameSet(Long gameSetId, GameConfiguration gameConfiguration, CardOption cardOption, String... players) {
        Validate.notNull(gameSetId);
        Validate.notNull(gameConfiguration);
        Validate.notNull(cardOption);
        Validate.notEmpty(players);

        GameSet.GameSetBuilder gameSetBuilder = GameSet.builder();
        gameSetBuilder.cardOption(cardOption).gameConfiguration(gameConfiguration).players(players);

        List<Pair<String, String[]>> gameSequence = generateTurnOrder(Sets.newHashSet(players));
        gameSequence.forEach(item -> {
            String letter = item.getLeft();
            String[] players1 = item.getRight();
            Game.GameBuilder gameBuilder = gameSetBuilder.game(letter).turnOrder(players1);
            LinkedList<PlayerCard> majorShuffledCards = shuffleCards(gameConfiguration.getCardSet().getMajorCards());
            LinkedList<PlayerCard> minorShuffledCards = shuffleCards(gameConfiguration.getCardSet().getMinorCards());
            Stream.of(players1).forEach(player -> {
                Game.PlayerCardSetBuilder playerCardSetBuilder = gameBuilder.playerCardSet(player);
                for (int i = 0; i < cardOption.getMajor(); i++) {
                    playerCardSetBuilder.addCard(majorShuffledCards.pop());
                }
                for (int i = 0; i < cardOption.getMinor(); i++) {
                    playerCardSetBuilder.addCard(minorShuffledCards.pop());
                }
                playerCardSetBuilder.finish();
            });
            gameBuilder.finish();
        });
        GameSet gameSet = gameSetBuilder.build();
        cache.put(gameSetId, gameSet);
    }

    private LinkedList<PlayerCard> shuffleCards(Set<Card> cards) {
        List<Card> shuffled = Lists.newArrayList(cards);
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(shuffled);
        }
        return shuffled.stream()
                .map(card -> PlayerCard.builder().card(card).build())
                .collect(Collectors.toCollection(Lists::newLinkedList));
    }

    public void loadGameSet(Long gameSetId, GameReport report) {

    }

    public void doTurn(Long gameSetId, String gameLetter, Turn turn) {

    }

    public GameReport gameReport(Long gameSetId) {
        return generateReport(cache.get(gameSetId));
    }

    private GameReport generateReport(GameSet gameSet) {
        return new GameReport();
    }

    private List<Pair<String, String[]>> generateTurnOrder(Set<String> players) {
        List<Pair<String, String[]>> queue = Lists.newArrayList();
        List<String[]> playerOrder = generateOrders(players);
        for (int i = 0; i < players.size(); i++) {
            String letter = String.valueOf((char) ('A' + i));
            queue.add(Pair.of(letter, playerOrder.get(i)));
        }
        return queue;
    }

    private List<String[]> generateOrders(Set<String> players) {
        LinkedList<String> playerNames = new LinkedList<>(players);
        List<String[]> orders = Lists.newArrayList();
        for (int i = 0; i < players.size(); i++) {
            if (i > 0) {
                String playerName = playerNames.pop();
                playerNames.addLast(playerName);
            }
            orders.add(playerNames.toArray(new String[0]));
        }
        return orders;
    }
}
