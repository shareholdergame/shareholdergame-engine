package com.shareholdergame.engine.game.core;

import org.testng.annotations.Test;

public class GameSetTest {

    @Test
    public void createGameSetTest() {
        GameSet gameSet = GameSet.builder()
                .cardOption(4, 6)
                .priceScale(10, 250, 10)
                .share(1L, 100, 1)
                .share(2L, 100, 1)
                .share(3L, 100, 1)
                .share(4L, 100, 1)
                /*.player("alice")
                .player("bob")*/
                .build();
    }
}