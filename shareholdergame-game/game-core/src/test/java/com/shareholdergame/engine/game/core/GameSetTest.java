package com.shareholdergame.engine.game.core;

import org.testng.annotations.Test;

public class GameSetTest {

    @Test
    public void createGameSetTest() {
        GameConfiguration gc = GameConfiguration.builder().build();
        CardOption co = CardOption.of(4, 6);
        GameSet gameSet = GameSet.initialize(gc, co, "alex", "andrew");
    }
}