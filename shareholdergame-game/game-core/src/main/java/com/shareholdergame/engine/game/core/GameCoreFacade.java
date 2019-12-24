package com.shareholdergame.engine.game.core;

import com.google.common.collect.Lists;
import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import com.shareholdergame.engine.game.core.configuration.GameConfigurationManager;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameCoreFacade {

    private GameConfigurationManager configurationManager;

    GameCoreFacade(GameConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    public GameConfiguration getDefaultConfiguration() {
        return configurationManager.getDefault();
    }

    public void startGameSet(Long gameSetId, String gameConfigurationName, CardOption cardOption, String... players) {

    }

    public void loadGameSet(Long gameSetId, GameReport report) {

    }

    public void doTurn(Long gameSetId, String gameLetter, Turn turn) {

    }

    public GameReport gameReport(Long gameSetId) {
        return new GameReport();
    }

    private LinkedList<Pair<String, String[]>> generateQueue(Set<Player> players) {
        LinkedList<Pair<String, String[]>> queue = Lists.newLinkedList();
        List<String[]> playerOrder = generateOrders(players);
        for (int i = 0; i < players.size(); i++) {
            String letter = String.valueOf((char) ('A' + i));
            queue.add(Pair.of(letter, playerOrder.get(i)));
        }
        return queue;
    }

    private List<String[]> generateOrders(Set<Player> players) {
        LinkedList<String> playerNames = players.stream().map(Player::getName)
                .collect(Collectors.toCollection(LinkedList::new));
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
