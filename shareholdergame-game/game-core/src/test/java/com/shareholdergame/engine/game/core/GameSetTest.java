package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GameSetTest {

    @Test
    public void createGameSetTest() {
        GameConfiguration gc = GameConfiguration.builder()
                .priceScale(PriceScale.of(10, 250, 10))
                .addColor(Color.of(1L, 100, 1))
                .addColor(Color.of(2L, 100, 1))
                .addColor(Color.of(3L, 100, 1))
                .addColor(Color.of(4L, 100, 1))
                .cardSet(CardSetUtil.buildCardSet())
                .build();
        CardOption co = CardOption.of(4, 6);
        GameSet gameSet = GameSet.builder()
                .gameConfiguration(gc)
                .cardOption(co)
                .players("alex", "bob")
                .game("A")
                .turnOrder("alex", "bob")
                .playerCardSet("alex")
                .addCard(PlayerCard.builder().build())
                .finish()
                .playerCardSet("bob")
                .addCard(PlayerCard.builder().build())
                .finish()
                .finish()
                .game("B")
                .turnOrder("bob", "alex")
                .playerCardSet("alex")
                .addCard(PlayerCard.builder().build())
                .finish()
                .playerCardSet("bob")
                .addCard(PlayerCard.builder().build())
                .finish()
                .finish()
                .build();

        Assert.assertNotNull(gameSet);
    }
}