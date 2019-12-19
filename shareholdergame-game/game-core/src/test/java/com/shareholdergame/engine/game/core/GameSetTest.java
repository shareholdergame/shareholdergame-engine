package com.shareholdergame.engine.game.core;

import org.testng.annotations.Test;

public class GameSetTest {

    @Test
    public void createGameSetTest() {
        GameConfiguration gc = GameConfiguration.builder().build();
        CardOption co = CardOption.of(4, 6);
        GameSet gameSet = GameSet.builder()
                .gameConfiguration(gc)
                .cardOption(co)
                .players("alex", "bob")
                .game('A')
                .turnOrder("alex", "bob")
                .playerCardSet("alex")
                .addCard(PlayerCard.builder().build())
                .finish()
                .playerCardSet("bob")
                .addCard(PlayerCard.builder().build())
                .finish()
                .finish()
                .game('B')
                .turnOrder("bob", "alex")
                .finish()
                .build();
    }
}