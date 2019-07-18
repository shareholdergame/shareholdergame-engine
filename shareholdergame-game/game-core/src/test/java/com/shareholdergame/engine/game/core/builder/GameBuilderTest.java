package com.shareholdergame.engine.game.core.builder;

import com.shareholdergame.engine.game.core.Game;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GameBuilderTest {

    @Test
    public void testBuild() {
        Game game = new GameBuilder()
                .cardOption(4, 6)
                .share(1L, 100)
                .player().name("alex").finish()
                .player().name("bob").finish()
                .build();

        Assert.assertNotNull(game);
    }
}