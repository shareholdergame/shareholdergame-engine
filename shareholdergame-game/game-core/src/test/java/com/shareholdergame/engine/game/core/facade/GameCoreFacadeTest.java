package com.shareholdergame.engine.game.core.facade;

import com.shareholdergame.engine.game.core.CardOption;
import com.shareholdergame.engine.game.core.GameCore;
import com.shareholdergame.engine.game.core.GameReport;
import com.shareholdergame.engine.game.core.exception.ConfigurationReadingException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GameCoreFacadeTest {

    @Test
    public void testStartGameSet() throws ConfigurationReadingException {
        GameCore.initialize();
        GameCoreFacade gameCoreFacade = GameCore.facade();

        gameCoreFacade.startGameSet(1L, gameCoreFacade.getDefaultConfiguration(),
                CardOption.of(4, 6), "alex", "bob");
        GameReport gameReport = gameCoreFacade.gameReport(1L);
        Assert.assertNotNull(gameReport);
    }
}